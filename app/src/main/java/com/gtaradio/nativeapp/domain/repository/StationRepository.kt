package com.gtaradio.nativeapp.domain.repository

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {
    fun getAllStations(): Flow<List<Station>>
    fun getStationsByGame(game: Game): Flow<List<Station>>
    suspend fun findStationById(id: String): Station?
}
