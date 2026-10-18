package com.gtaradio.nativeapp.playback

import android.content.ComponentName
import android.content.Context
import androidx.core.content.ContextCompat
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import com.google.common.util.concurrent.ListenableFuture
import com.gtaradio.nativeapp.domain.model.PlaybackState
import com.gtaradio.nativeapp.domain.model.Station
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Puente de comunicación entre el ViewModel y MediaController (Media3).
 * Principio SOLID: Responsabilidad Única (SRP) — aísla el ciclo de vida del controlador.
 * Gestiona play, pausa, skip, seek y posición de reproducción sin fugas de memoria.
 */
class PlaybackConnection(
    private val context: Context,
    private val stationResolver: (String) -> Station?
) {
    private var controllerFuture: ListenableFuture<MediaController>? = null
    private var mediaController: MediaController? = null

    private val _playbackState = MutableStateFlow<PlaybackState>(PlaybackState.Idle)
    val playbackState: StateFlow<PlaybackState> = _playbackState.asStateFlow()

    private val playerListener = object : Player.Listener {
        override fun onIsPlayingChanged(isPlaying: Boolean) { updateCurrentState() }
        override fun onPlaybackStateChanged(playbackState: Int) { updateCurrentState() }
        override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) { updateCurrentState() }
        override fun onPlayerError(error: PlaybackException) {
            _playbackState.value = PlaybackState.Error(error.localizedMessage ?: "Error de reproducción")
        }
    }

    fun connect() {
        if (mediaController != null || controllerFuture != null) return
        val sessionToken = SessionToken(context, ComponentName(context, RadioPlaybackService::class.java))
        val future = MediaController.Builder(context, sessionToken).buildAsync()
        controllerFuture = future
        future.addListener({
            try {
                val controller = future.get()
                mediaController = controller
                controller.addListener(playerListener)
                updateCurrentState()
            } catch (e: Exception) {
                _playbackState.value = PlaybackState.Error("Fallo al conectar con el servicio: ${e.message}")
            }
        }, ContextCompat.getMainExecutor(context))
    }

    private fun updateCurrentState() {
        val controller = mediaController ?: return
        val currentStation = controller.currentMediaItem?.mediaId?.let { stationResolver(it) }
        if (currentStation == null) { _playbackState.value = PlaybackState.Idle; return }
        _playbackState.value = when {
            controller.playbackState == Player.STATE_BUFFERING -> PlaybackState.Buffering(currentStation)
            controller.isPlaying -> PlaybackState.Playing(currentStation)
            controller.playbackState == Player.STATE_READY -> PlaybackState.Paused(currentStation)
            else -> PlaybackState.Idle
        }
    }

    /**
     * Inicia la reproducción de una emisora.
     * @param seekToMs Posición inicial en milisegundos (para RadioClock o skip).
     * @param trackIndex Índice de la canción en la playlist de la emisora.
     */
    fun playStation(
        station: Station,
        playbackUri: String? = null,
        seekToMs: Long = 0L,
        trackIndex: Int = 0
    ) {
        val controller = mediaController ?: return

        // Si ya es la misma estación y se pide reanudar simplemente
        if (controller.currentMediaItem?.mediaId == station.id && seekToMs == 0L && trackIndex == 0) {
            if (!controller.isPlaying) controller.play()
            return
        }

        val uriToPlay = playbackUri ?: station.audioUrl
        val metadata = MediaMetadata.Builder()
            .setTitle(station.name)
            .setArtist(station.game.displayName)
            .setAlbumTitle(station.genre)
            .setTrackNumber(trackIndex)
            .build()

        val mediaItem = MediaItem.Builder()
            .setMediaId(station.id)
            .setUri(uriToPlay)
            .setMediaMetadata(metadata)
            .build()

        controller.setMediaItem(mediaItem, seekToMs)
        controller.repeatMode = Player.REPEAT_MODE_ONE
        controller.prepare()
        controller.play()
    }

    fun togglePlayPause() {
        val controller = mediaController ?: return
        if (controller.isPlaying) controller.pause() else controller.play()
    }

    fun stop() {
        mediaController?.stop()
        _playbackState.value = PlaybackState.Idle
    }

    /** Posición actual de reproducción en milisegundos. */
    fun currentPositionMs(): Long = mediaController?.currentPosition ?: 0L

    /** Duración total del ítem actual en milisegundos. */
    fun durationMs(): Long = mediaController?.duration?.takeIf { it > 0 } ?: 0L

    fun disconnect() {
        mediaController?.removeListener(playerListener)
        controllerFuture?.let { MediaController.releaseFuture(it) }
        controllerFuture = null
        mediaController = null
        _playbackState.value = PlaybackState.Idle
    }
}
