package com.gtaradio.nativeapp.domain.usecase

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.repository.StationRepository
import kotlinx.coroutines.flow.Flow

class GetStationsUseCase(
    private val repository: StationRepository
) {
    operator fun invoke(filterGame: Game? = null): Flow<List<Station>> {
        return if (filterGame == null) {
            repository.getAllStations()
        } else {
            repository.getStationsByGame(filterGame)
        }
    }
}
