package com.gtaradio.nativeapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gtaradio.nativeapp.data.repository.DefaultStationRepository
import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.PlaybackState
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.radio.RadioClock
import com.gtaradio.nativeapp.domain.usecase.GetStationsUseCase
import com.gtaradio.nativeapp.playback.PlaybackConnection
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * ViewModel principal para GTA Radio.
 * Principios SOLID: SRP (orquesta UI state), DIP (depende de abstracciones).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class RadioViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DefaultStationRepository()
    private val getStationsUseCase = GetStationsUseCase(repository)
    private val radioClock = RadioClock()

    private val allStationsCache = mutableListOf<Station>()

    val playbackConnection = PlaybackConnection(application) { id ->
        allStationsCache.firstOrNull { it.id == id }
    }

    private val _selectedFilter = MutableStateFlow<Game?>(null)
    private val _errorMessage = MutableStateFlow<String?>(null)
    private val _currentTrackIndex = MutableStateFlow(0)
    private val _progress = MutableStateFlow(0f)

    val uiState: StateFlow<RadioUiState> = combine(
        _selectedFilter.flatMapLatest { filter -> getStationsUseCase(filter) },
        _selectedFilter,
        playbackConnection.playbackState,
        _errorMessage
    ) { stations: List<Station>, filter: Game?, playbackState: PlaybackState, error: String? ->
        if (allStationsCache.isEmpty() && stations.isNotEmpty()) {
            allStationsCache.addAll(stations)
        }
        Triple(stations, filter, Pair(playbackState, error))
    }.combine(_currentTrackIndex) { triple, trackIndex ->
        Pair(triple, trackIndex)
    }.combine(_progress) { (triple, trackIndex), progress ->
        val (stations, filter, pair) = triple
        val (playbackState, error) = pair

        val activeStation = when (playbackState) {
            is PlaybackState.Playing -> playbackState.station
            is PlaybackState.Paused -> playbackState.station
            is PlaybackState.Buffering -> playbackState.station
            else -> null
        }
        val currentTrack = activeStation?.tracklist?.getOrNull(trackIndex)

        RadioUiState(
            stations = stations,
            selectedGameFilter = filter,
            playbackState = playbackState,
            activeStation = activeStation,
            isPlaying = playbackState is PlaybackState.Playing,
            isBuffering = playbackState is PlaybackState.Buffering,
            errorMessage = (playbackState as? PlaybackState.Error)?.message ?: error,
            currentTrack = currentTrack,
            currentTrackIndex = trackIndex,
            progress = progress
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = RadioUiState()
    )

    init {
        playbackConnection.connect()
        viewModelScope.launch {
            repository.getAllStations().collect {
                allStationsCache.clear()
                allStationsCache.addAll(it)
            }
        }
        // Actualizar progreso cada segundo para la barra de reproducción
        viewModelScope.launch {
            while (true) {
                delay(1000)
                val pos = playbackConnection.currentPositionMs()
                val dur = playbackConnection.durationMs()
                if (dur > 0) _progress.value = (pos.toFloat() / dur).coerceIn(0f, 1f)
            }
        }
    }

    fun setGameFilter(game: Game?) { _selectedFilter.value = game }

    fun onStationClick(station: Station) {
        if (uiState.value.activeStation?.id == station.id) {
            playbackConnection.togglePlayPause()
        } else {
            // Calcular posición basada en el reloj del sistema (comportamiento GTA)
            val (startIndex, startPositionMs) = radioClock.computeStartPosition(station.tracklist)
            _currentTrackIndex.value = startIndex
            val resolvedUri = repository.resolvePlaybackUri(station)
            playbackConnection.playStation(station, resolvedUri, startPositionMs)
        }
    }

    /** Salta a la siguiente canción de la tracklist de la emisora activa. */
    fun skipNext() {
        val station = uiState.value.activeStation ?: return
        val total = station.tracklist.size
        if (total == 0) return
        val next = radioClock.nextTrackIndex(_currentTrackIndex.value, total)
        _currentTrackIndex.value = next
        val resolvedUri = repository.resolvePlaybackUri(station)
        // Skip desde el inicio de esa canción
        playbackConnection.playStation(station, resolvedUri, seekToMs = 0L, trackIndex = next)
    }

    /** Salta a la canción anterior de la tracklist. */
    fun skipPrevious() {
        val station = uiState.value.activeStation ?: return
        val total = station.tracklist.size
        if (total == 0) return
        val prev = radioClock.previousTrackIndex(_currentTrackIndex.value, total)
        _currentTrackIndex.value = prev
        val resolvedUri = repository.resolvePlaybackUri(station)
        playbackConnection.playStation(station, resolvedUri, seekToMs = 0L, trackIndex = prev)
    }

    fun togglePlayPause() { playbackConnection.togglePlayPause() }
    fun stop() {
        playbackConnection.stop()
        _currentTrackIndex.value = 0
        _progress.value = 0f
    }

    fun isStationOffline(station: Station): Boolean = repository.isStationOfflineReady(station)

    fun clearError() { _errorMessage.value = null }

    override fun onCleared() {
        super.onCleared()
        playbackConnection.disconnect()
    }
}
