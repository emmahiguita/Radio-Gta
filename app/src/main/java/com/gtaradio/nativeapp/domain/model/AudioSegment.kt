package com.gtaradio.nativeapp.domain.model

enum class SegmentType {
    MONOLITHIC_TRACK,
    SONG,
    DJ_INTRO,
    DJ_OUTRO,
    STATION_ID,
    ADVERTISEMENT,
    TALK_SEGMENT
}

data class AudioSegment(
    val id: String,
    val title: String,
    val artist: String? = null,
    val type: SegmentType,
    val audioUrl: String,
    val durationMs: Long = 0L
)
