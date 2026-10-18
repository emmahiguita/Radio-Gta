package com.gtaradio.nativeapp.domain.model

/**
 * Representa una canción individual con metadatos reales del juego original.
 * Cada Track puede reproducirse como segmento de la playlist de una emisora.
 */
data class Track(
    val artist: String,
    val title: String,
    /** Duración aproximada en segundos (0 = desconocida, se obtiene en tiempo real de ExoPlayer). */
    val durationSeconds: Int = 0
)
