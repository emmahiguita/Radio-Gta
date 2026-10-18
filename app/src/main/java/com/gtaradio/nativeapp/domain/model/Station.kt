package com.gtaradio.nativeapp.domain.model

data class Station(
    val id: String,
    val name: String,
    val game: Game,
    val audioUrl: String,
    val genre: String,
    val host: String? = null,
    val isMonolithic: Boolean = true,
    val segments: List<AudioSegment> = emptyList(),
    val fileAliases: List<String> = emptyList(),
    /** Lista de canciones reales tal como aparecen en el juego original. */
    val tracklist: List<Track> = emptyList()
)
