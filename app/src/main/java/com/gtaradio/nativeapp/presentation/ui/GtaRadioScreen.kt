package com.gtaradio.nativeapp.presentation.ui

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.model.Track
import com.gtaradio.nativeapp.presentation.ui.components.*
import com.gtaradio.nativeapp.presentation.ui.theme.GtaColors

/**
 * Pantalla principal de GTA Radio — orquestadora Compose sin lógica de negocio.
 * Principio SOLID: SRP. Todos los controles de radio están disponibles:
 * play, pausa, skip anterior/siguiente, stop y barra de progreso.
 */
@Composable
fun GtaRadioScreen(
    stations: List<Station>,
    selectedGame: Game?,
    activeStation: Station?,
    currentPlayingId: String?,
    isPlaying: Boolean,
    isBuffering: Boolean,
    errorMessage: String?,
    currentTrack: Track?,
    progress: Float,
    isOfflineReady: (Station) -> Boolean,
    onGameSelect: (Game?) -> Unit,
    onStationClick: (Station) -> Unit,
    onTogglePlayPause: () -> Unit,
    onSkipPrevious: () -> Unit,
    onSkipNext: () -> Unit,
    onStop: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = GtaColors.Background,
        contentWindowInsets = WindowInsets.safeDrawing,
        bottomBar = {
            AnimatedVisibility(
                visible = (activeStation != null),
                enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
                exit = slideOutVertically(targetOffsetY = { it }) + fadeOut()
            ) {
                if (activeStation != null) {
                    BottomPlaybackBar(
                        station = activeStation,
                        currentTrack = currentTrack,
                        isPlaying = isPlaying,
                        isBuffering = isBuffering,
                        progress = progress,
                        onTogglePlayPause = onTogglePlayPause,
                        onSkipPrevious = onSkipPrevious,
                        onSkipNext = onSkipNext,
                        onStop = onStop
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            HeaderSection(errorMessage = errorMessage)
            GameFilterRow(selectedGame = selectedGame, onGameSelect = onGameSelect)
            Spacer(modifier = Modifier.height(4.dp))
            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f).padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(top = 4.dp, bottom = 16.dp)
            ) {
                items(stations, key = { it.id }) { station ->
                    val isSelected = (station.id == currentPlayingId)
                    StationCard(
                        station = station,
                        isSelected = isSelected,
                        isPlaying = isPlaying && isSelected,
                        isBuffering = isBuffering && isSelected,
                        isOfflineReady = isOfflineReady(station),
                        onClick = { onStationClick(station) }
                    )
                }
            }
        }
    }
}

