package com.gtaradio.nativeapp.data.repository

import com.gtaradio.nativeapp.data.catalog.*
import com.gtaradio.nativeapp.data.source.OfflineAudioResolver
import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.repository.StationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Implementación concreta del repositorio de emisoras.
 * Principios SOLID:
 * - SRP: Se encarga exclusivamente de orquestar el acceso a las fuentes de datos de emisoras.
 * - OCP: Nuevos juegos o catálogos se añaden como módulos sin modificar la lógica interna.
 * - DIP: Cumple la interfaz del dominio StationRepository.
 */
class DefaultStationRepository(
    private val offlineResolver: OfflineAudioResolver = OfflineAudioResolver()
) : StationRepository {

    // Colección canónica unificada con todas las emisoras de las 5 generaciones
    private val allStations: List<Station> = listOf(
        Gta3Catalog.stations,
        ViceCityCatalog.stations,
        SanAndreasCatalog.stations,
        Gta4Catalog.stations,
        Gta5Catalog.stations
    ).flatten()

    override fun getAllStations(): Flow<List<Station>> = flow {
        emit(allStations)
    }

    override fun getStationsByGame(game: Game): Flow<List<Station>> = flow {
        emit(allStations.filter { it.game == game })
    }

    override suspend fun findStationById(id: String): Station? {
        return allStations.firstOrNull { it.id == id }
    }

    /**
     * Resuelve la URI de audio (local offline o stream remoto) mediante el componente dedicado.
     */
    fun resolvePlaybackUri(station: Station): String {
        return offlineResolver.resolve(station)
    }

    /**
     * Verifica si la emisora se encuentra descargada en la memoria interna del teléfono.
     */
    fun isStationOfflineReady(station: Station): Boolean {
        return offlineResolver.isOfflineReady(station)
    }
}
