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
 * equivale a determinar en qué canción y en qué segundo de esa canción
 * se encontraría la emisora si hubiera estado transmitiendo desde el
 * inicio del tiempo UNIX, rotando en bucle indefinidamente.
 *
 * Posición = epochMs % duraciónTotalPlaylist
 */
class RadioClock {

    /**
     * Duración promedio de una canción pop/rock en segundos.
     * Se usa cuando no se conoce la duración exacta del archivo.
     */
    private val defaultTrackDurationSec = 240L // 4 minutos promedio

    /**
     * Calcula qué canción y en qué segundo comienza la reproducción.
     * @param tracklist Lista de canciones de la emisora.
     * @param trackDurations Duraciones reales en ms (de ExoPlayer). Puede estar vacía.
     * @return Par (índice de canción, posición en ms dentro de esa canción).
     */
    fun computeStartPosition(
        tracklist: List<Track>,
        trackDurations: Map<Int, Long> = emptyMap()
    ): Pair<Int, Long> {
        if (tracklist.isEmpty()) return Pair(0, 0L)

        // Duración total de la playlist en milisegundos
        val durations = tracklist.mapIndexed { i, _ ->
            trackDurations[i] ?: (defaultTrackDurationSec * 1000L)
        }
        val totalDurationMs = durations.sum()
        if (totalDurationMs <= 0) return Pair(0, 0L)

        // Posición actual en la rotación circular de la playlist
        val epochMs = System.currentTimeMillis()
        val positionInPlaylistMs = epochMs % totalDurationMs

        // Encontrar qué canción y en qué milisegundo estamos
        var accumulated = 0L
        for ((index, duration) in durations.withIndex()) {
            if (positionInPlaylistMs < accumulated + duration) {
                val positionInTrackMs = positionInPlaylistMs - accumulated
                return Pair(index, positionInTrackMs)
            }
            accumulated += duration
        }

        return Pair(0, 0L)
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
