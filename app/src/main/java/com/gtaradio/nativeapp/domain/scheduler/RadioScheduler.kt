package com.gtaradio.nativeapp.domain.scheduler

import com.gtaradio.nativeapp.domain.model.AudioSegment
import com.gtaradio.nativeapp.domain.model.SegmentType
import kotlin.random.Random

data class SchedulerConfig(
    val maxRecentHistory: Int = 8,
    val jingleChance: Float = 0.60f,
    val adBlockChance: Float = 0.35f,
    val maxConsecutiveAds: Int = 3
)

class RadioScheduler(
    private val config: SchedulerConfig = SchedulerConfig()
) {
    private val recentSongHistory = ArrayDeque<String>()
    private var songsSinceLastAdBlock = 0

    fun planNextSequence(
        songs: List<AudioSegment>,
        jingles: List<AudioSegment>,
        ads: List<AudioSegment>,
        djSpeech: List<AudioSegment>
    ): List<AudioSegment> {
        val resultSequence = mutableListOf<AudioSegment>()

        // 1. Inserción de tanda comercial si se superó el umbral
        if (songsSinceLastAdBlock >= 3 && Random.nextFloat() < config.adBlockChance && ads.isNotEmpty()) {
            val adCount = Random.nextInt(1, config.maxConsecutiveAds + 1).coerceAtMost(ads.size)
            resultSequence.addAll(ads.shuffled().take(adCount))
            songsSinceLastAdBlock = 0

            // Jingle de regreso a la emisora tras los comerciales
            if (jingles.isNotEmpty()) {
                resultSequence.add(jingles.random())
            }
        }

        // 2. Selección de canción sin repetición reciente (FIFO)
        val candidateSongs = songs.filterNot { it.id in recentSongHistory }.ifEmpty { songs }
        if (candidateSongs.isNotEmpty()) {
            val nextSong = candidateSongs.random()

            // Actualizar memoria FIFO
            recentSongHistory.addLast(nextSong.id)
            if (recentSongHistory.size > config.maxRecentHistory) {
                recentSongHistory.removeFirst()
            }

            // 3. Evaluar locución de DJ o identificación de estación
            if (Random.nextFloat() < config.jingleChance) {
                val intro = djSpeech.filter { it.type == SegmentType.DJ_INTRO }.randomOrNull()
                    ?: jingles.randomOrNull()
                intro?.let { resultSequence.add(it) }
            }

            resultSequence.add(nextSong)
            songsSinceLastAdBlock++
        }

        return resultSequence
    }

    fun clearHistory() {
        recentSongHistory.clear()
        songsSinceLastAdBlock = 0
    }
}
