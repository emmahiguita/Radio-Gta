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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
    private val _offlineStationIds = MutableStateFlow<Set<String>>(emptySet())

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
            repository.getAllStations().collect { stations ->
                allStationsCache.clear()
                allStationsCache.addAll(stations)
                val offlineIds = withContext(Dispatchers.IO) {
                    stations.filter { repository.isStationOfflineReady(it) }.map { it.id }.toSet()
                }
                _offlineStationIds.value = offlineIds
            }
        }
        // Actualizar progreso y pista en curso cada segundo según posición real de ExoPlayer
        viewModelScope.launch {
            while (true) {
                delay(1000)
                val pos = playbackConnection.currentPositionMs()
                val dur = playbackConnection.durationMs()
                if (dur > 0L) {
                    _progress.value = (pos.toFloat() / dur).coerceIn(0f, 1f)
                    val totalTracks = uiState.value.activeStation?.tracklist?.size ?: 0
                    if (totalTracks > 0) {
                        _currentTrackIndex.value = radioClock.trackIndexForPosition(pos, dur, totalTracks)
                    }
                }
            }
        }
    }

    fun setGameFilter(game: Game?) { _selectedFilter.value = game }

    /** Permite sintonizar una emisora o filtrar por generación directamente desde un Intent o acceso directo. */
    fun handleDeepLink(gameFilterName: String?, stationId: String?) {
        if (!gameFilterName.isNullOrBlank()) {
            val matchedGame = Game.entries.firstOrNull {
                it.name.equals(gameFilterName, ignoreCase = true) ||
                    it.shortName.equals(gameFilterName, ignoreCase = true)
            }
            _selectedFilter.value = matchedGame
        }
        if (!stationId.isNullOrBlank()) {
            viewModelScope.launch {
                val stations = allStationsCache.ifEmpty { repository.getAllStations().first() }
                val station = stations.firstOrNull { it.id == stationId }
                if (station != null && uiState.value.activeStation?.id != station.id) {
                    onStationClick(station)
                }
            }
        }
    }

    fun onStationClick(station: Station) {
        _errorMessage.value = null
        if (uiState.value.activeStation?.id == station.id) {
            playbackConnection.togglePlayPause()
        } else {
            val (startIndex, _) = radioClock.computeStartPosition(station.tracklist)
            _currentTrackIndex.value = startIndex
            _progress.value = 0f
            viewModelScope.launch {
                val resolvedUri = withContext(Dispatchers.IO) {
                    repository.resolvePlaybackUri(station)
                }
                playbackConnection.playStation(
                    station = station,
                    playbackUri = resolvedUri,
                    trackIndex = startIndex,
                    liveTune = true
                )
            }
        }
    }

    /** Salta a la siguiente canción o segmento de la emisora activa sin reiniciar el stream. */
    fun skipNext() {
        val station = uiState.value.activeStation ?: return
        val dur = playbackConnection.durationMs()
        val total = station.tracklist.size
        if (total > 0) {
            val next = radioClock.nextTrackIndex(_currentTrackIndex.value, total)
            _currentTrackIndex.value = next
            if (dur > 0L) {
                val targetMs = radioClock.seekPositionForTrack(next, total, dur)
                playbackConnection.seekTo(targetMs)
            }
        } else if (dur > 0L) {
            playbackConnection.seekTo(playbackConnection.currentPositionMs() + 180_000L)
        }
    }

    /** Salta a la canción o segmento anterior de la emisora activa sin reiniciar el stream. */
    fun skipPrevious() {
        val station = uiState.value.activeStation ?: return
        val dur = playbackConnection.durationMs()
        val total = station.tracklist.size
        if (total > 0) {
            val prev = radioClock.previousTrackIndex(_currentTrackIndex.value, total)
            _currentTrackIndex.value = prev
            if (dur > 0L) {
                val targetMs = radioClock.seekPositionForTrack(prev, total, dur)
                playbackConnection.seekTo(targetMs)
            }
        } else if (dur > 0L) {
            playbackConnection.seekTo(playbackConnection.currentPositionMs() - 180_000L)
        }
    }

    fun togglePlayPause() { playbackConnection.togglePlayPause() }
    fun stop() {
        playbackConnection.stop()
        _currentTrackIndex.value = 0
        _progress.value = 0f
    }

    fun isStationOffline(station: Station): Boolean = station.id in _offlineStationIds.value

    fun clearError() { _errorMessage.value = null }

    override fun onCleared() {
        super.onCleared()
        playbackConnection.disconnect()
    }
}


