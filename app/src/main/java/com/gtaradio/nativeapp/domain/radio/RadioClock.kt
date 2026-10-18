package com.gtaradio.nativeapp.domain.radio

import com.gtaradio.nativeapp.domain.model.Track

/**
 * RadioClock — Motor de reproducción de radio sincronizado con el reloj del sistema.
 *
 * Principio SOLID: Responsabilidad Única (SRP).
 * Principio: No depende de ExoPlayer ni de la capa de datos.
 *
 * COMPORTAMIENTO COMO EN GTA:
 * Todas las emisoras emiten en paralelo. Calcular la posición actual
 * equivale a determinar en qué punto exacto de la emisión completa (y en qué canción)
 * se encontraría la emisora si hubiera estado transmitiendo desde el
 * inicio del tiempo UNIX, rotando en bucle indefinidamente.
 */
class RadioClock {

    private val defaultTrackDurationSec = 240L // 4 minutos promedio por segmento musical + DJ

    /**
     * Calcula qué canción y en qué milisegundo de la EMISIÓN COMPLETA comienza la reproducción
     * cuando aún no se conoce la duración real del archivo en ExoPlayer.
     */
    fun computeStartPosition(
        tracklist: List<Track>,
        trackDurations: Map<Int, Long> = emptyMap()
    ): Pair<Int, Long> {
        if (tracklist.isEmpty()) return Pair(0, 0L)

        val durations = tracklist.mapIndexed { i, track ->
            trackDurations[i]
                ?: if (track.durationSeconds > 0) track.durationSeconds * 1000L
                else defaultTrackDurationSec * 1000L
        }
        val totalDurationMs = durations.sum()
        if (totalDurationMs <= 0) return Pair(0, 0L)

        val epochMs = System.currentTimeMillis()
        val positionInPlaylistMs = epochMs % totalDurationMs

        var accumulated = 0L
        for ((index, duration) in durations.withIndex()) {
            if (positionInPlaylistMs < accumulated + duration) {
                // Retornamos la posición acumulada global en la emisión completa
                return Pair(index, positionInPlaylistMs)
            }
            accumulated += duration
        }

        return Pair(0, 0L)
    }

    /**
     * Calcula la posición exacta en vivo (ms) dentro de la duración real de la emisión reportada por ExoPlayer.
     * Usado apenas la emisora entra en STATE_READY para sintonizar en tiempo real como en GTA.
     */
    fun computeLiveOffsetMs(realDurationMs: Long, stationSeed: String = ""): Long {
        if (realDurationMs <= 0L) return 0L
        val seedOffset = (stationSeed.hashCode().toLong() and 0x7FFFFFFFL) * 13_337L
        return (System.currentTimeMillis() + seedOffset) % realDurationMs
    }

    /**
     * Determina el índice de la pista actual en función de la posición y duración real de la emisión.
     */
    fun trackIndexForPosition(positionMs: Long, durationMs: Long, totalTracks: Int): Int {
        if (totalTracks <= 0 || durationMs <= 0L) return 0
        val clampedPos = positionMs.coerceIn(0L, durationMs - 1L)
        return ((clampedPos.toDouble() / durationMs.toDouble()) * totalTracks)
            .toInt()
            .coerceIn(0, totalTracks - 1)
    }

    /**
     * Calcula el milisegundo exacto al que debe hacer seek ExoPlayer al saltar a una pista específica.
     */
    fun seekPositionForTrack(trackIndex: Int, totalTracks: Int, durationMs: Long): Long {
        if (durationMs <= 0L || totalTracks <= 0) return 0L
        val safeIndex = trackIndex.coerceIn(0, totalTracks - 1)
        return (safeIndex.toLong() * durationMs) / totalTracks
    }

    /**
     * Índice del siguiente track después de un skip hacia adelante.
     */
    fun nextTrackIndex(current: Int, total: Int): Int {
        return if (total <= 1) 0 else (current + 1) % total
    }

    /**
     * Índice del track anterior después de un skip hacia atrás.
     */
    fun previousTrackIndex(current: Int, total: Int): Int {
        return if (total <= 1) 0 else (current - 1 + total) % total
    }
}

