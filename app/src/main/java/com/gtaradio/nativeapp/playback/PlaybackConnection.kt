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
import com.gtaradio.nativeapp.domain.radio.RadioClock
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Puente de comunicación entre el ViewModel y MediaController (Media3).
 * Principio SOLID: Responsabilidad Única (SRP) — aísla el ciclo de vida del controlador.
 * Gestiona play, pausa, skip, seek, sintonización en vivo (RadioClock) y fallback automático.
 */
class PlaybackConnection(
    private val context: Context,
    private val stationResolver: (String) -> Station?
) {
    private var controllerFuture: ListenableFuture<MediaController>? = null
    private var mediaController: MediaController? = null
    private val radioClock = RadioClock()

    private var pendingStationIdForLiveTune: String? = null
    private var lastAttemptedUri: String? = null
    private var pendingCommand: (() -> Unit)? = null

    private val _playbackState = MutableStateFlow<PlaybackState>(PlaybackState.Idle)
    val playbackState: StateFlow<PlaybackState> = _playbackState.asStateFlow()

    private val playerListener = object : Player.Listener {
        override fun onIsPlayingChanged(isPlaying: Boolean) {
            updateCurrentState()
        }

        override fun onPlaybackStateChanged(playbackState: Int) {
            // No sobrescribir un estado de Error cuando ExoPlayer pasa a STATE_IDLE tras fallar
            if (playbackState == Player.STATE_IDLE && _playbackState.value is PlaybackState.Error) {
                return
            }

            updateCurrentState()
        }

        override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
            updateCurrentState()
        }

        override fun onPlayerError(error: PlaybackException) {
            val controller = mediaController
            val currentStation = controller?.currentMediaItem?.mediaId?.let { stationResolver(it) }

            // Si falló un archivo local (ej. EACCES o archivo corrupto), hacer fallback automático al stream online real
            if (currentStation != null && lastAttemptedUri?.startsWith("file:") == true) {
                playStation(
                    station = currentStation,
                    playbackUri = currentStation.audioUrl,
                    seekToMs = 0L,
                    liveTune = true
                )
                return
            }

            pendingStationIdForLiveTune = null
            val stationLabel = currentStation?.name?.let { " en $it" } ?: ""
            _playbackState.value = PlaybackState.Error(
                "Error de reproducción$stationLabel: verifica tu conexión a internet"
            )
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
                pendingCommand?.invoke()
                pendingCommand = null
            } catch (e: Exception) {
                _playbackState.value = PlaybackState.Error("Fallo al conectar con el servicio: ${e.message}")
            }
        }, ContextCompat.getMainExecutor(context))
    }

    private fun updateCurrentState() {
        val controller = mediaController ?: return
        val currentStation = controller.currentMediaItem?.mediaId?.let { stationResolver(it) }
        if (currentStation == null) {
            if (_playbackState.value !is PlaybackState.Error) {
                _playbackState.value = PlaybackState.Idle
            }
            return
        }
        _playbackState.value = when {
            controller.playbackState == Player.STATE_BUFFERING -> PlaybackState.Buffering(currentStation)
            controller.isPlaying -> PlaybackState.Playing(currentStation)
            controller.playbackState == Player.STATE_READY -> PlaybackState.Paused(currentStation)
            else -> if (_playbackState.value is PlaybackState.Error) _playbackState.value else PlaybackState.Idle
        }
    }

    /**
     * Inicia la reproducción de una emisora real de GTA.
     * @param seekToMs Posición inicial explícita en milisegundos (si liveTune es false).
     * @param trackIndex Índice de la canción en la playlist de la emisora.
     * @param liveTune Si es true, sintoniza la emisión en el punto exacto del reloj en vivo desde el primer request.
     */
    fun playStation(
        station: Station,
        playbackUri: String? = null,
        seekToMs: Long = 0L,
        trackIndex: Int = 0,
        liveTune: Boolean = false
    ) {
        val controller = mediaController
        if (controller == null) {
            pendingCommand = { playStation(station, playbackUri, seekToMs, trackIndex, liveTune) }
            connect()
            return
        }

        val uriToPlay = playbackUri ?: station.audioUrl
        lastAttemptedUri = uriToPlay
        pendingStationIdForLiveTune = null

        val (computedTrackIndex, computedPosMs) = radioClock.computeStartPosition(station.tracklist)
        val initialPos = if (liveTune) {
            if (computedPosMs > 0L) computedPosMs else radioClock.computeLiveOffsetMs(1_800_000L, station.id)
        } else {
            seekToMs.coerceAtLeast(0L)
        }
        val effectiveTrackIndex = if (liveTune) computedTrackIndex else trackIndex

        // Retroalimentación visual inmediata mientras conecta
        _playbackState.value = PlaybackState.Buffering(station)

        val currentTrack = station.tracklist.getOrNull(effectiveTrackIndex)

        val artistSubtitle = if (currentTrack != null) {
            "${currentTrack.artist} — ${currentTrack.title} (${station.game.shortName})"
        } else {
            "${station.game.displayName} • ${station.genre}"
        }

        val metadata = MediaMetadata.Builder()
            .setTitle(station.name)
            .setArtist(artistSubtitle)
            .setAlbumTitle(station.game.displayName)
            .setDisplayTitle(station.name)
            .setSubtitle(artistSubtitle)
            .setTrackNumber(effectiveTrackIndex)
            .build()

        val mediaItem = MediaItem.Builder()
            .setMediaId(station.id)
            .setUri(uriToPlay)
            .setMediaMetadata(metadata)
            .build()

        controller.setMediaItem(mediaItem, initialPos)
        controller.repeatMode = Player.REPEAT_MODE_ONE
        controller.prepare()
        controller.play()
    }

    /**
     * Salta directamente a un milisegundo dentro de la emisión activa sin reiniciar el stream.
     */
    fun seekTo(positionMs: Long) {
        val controller = mediaController ?: return
        val dur = controller.duration
        val target = if (dur > 0L) ((positionMs % dur) + dur) % dur else positionMs.coerceAtLeast(0L)
        pendingStationIdForLiveTune = null
        controller.seekTo(target)
        if (!controller.isPlaying) {
            controller.play()
        }
    }

    fun togglePlayPause() {
        val controller = mediaController ?: return
        if (controller.isPlaying) {
            controller.pause()
        } else {
            if (controller.playbackState == Player.STATE_IDLE) {
                controller.prepare()
            }
            controller.play()
        }
    }

    fun stop() {
        pendingStationIdForLiveTune = null
        mediaController?.stop()
        mediaController?.clearMediaItems()
        _playbackState.value = PlaybackState.Idle
    }

    /** Posición actual de reproducción en milisegundos. */
    fun currentPositionMs(): Long = mediaController?.currentPosition?.coerceAtLeast(0L) ?: 0L

    /** Duración total del ítem actual en milisegundos. */
    fun durationMs(): Long = mediaController?.duration?.takeIf { it > 0L } ?: 0L

    fun disconnect() {
        mediaController?.removeListener(playerListener)
        controllerFuture?.let { MediaController.releaseFuture(it) }
        controllerFuture = null
        mediaController = null
        _playbackState.value = PlaybackState.Idle
    }
}

