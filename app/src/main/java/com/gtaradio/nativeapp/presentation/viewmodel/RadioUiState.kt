package com.gtaradio.nativeapp.presentation.viewmodel

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.PlaybackState
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.model.Track

/**
 * Estado de UI inmutable para GtaRadioScreen.
 * Incluye info de la pista actual en reproducción (artista / título).
 */
data class RadioUiState(
    val stations: List<Station> = emptyList(),
    val selectedGameFilter: Game? = null,
    val playbackState: PlaybackState = PlaybackState.Idle,
    val activeStation: Station? = null,
    val isPlaying: Boolean = false,
    val isBuffering: Boolean = false,
    val errorMessage: String? = null,
    /** Canción actualmente en reproducción (null si no hay tracklist o es monolítico). */
    val currentTrack: Track? = null,
    /** Índice dentro de la playlist de la emisora activa. */
    val currentTrackIndex: Int = 0,
    /** Progreso de reproducción 0.0–1.0 (basado en reloj ExoPlayer). */
    val progress: Float = 0f
)
