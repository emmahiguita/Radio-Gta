package com.gtaradio.nativeapp.domain.model

sealed interface PlaybackState {
    data object Idle : PlaybackState
    data class Buffering(val station: Station) : PlaybackState
    data class Playing(val station: Station) : PlaybackState
    data class Paused(val station: Station) : PlaybackState
    data class Error(val message: String) : PlaybackState
}
