package com.gtaradio.nativeapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import com.gtaradio.nativeapp.presentation.ui.GtaRadioScreen
import com.gtaradio.nativeapp.presentation.ui.theme.GtaColors
import com.gtaradio.nativeapp.presentation.viewmodel.RadioViewModel

/**
 * MainActivity — punto de entrada de GTA Radio.
 * Principio SOLID: SRP — ciclo de vida Android + enlace Compose/ViewModel exclusivamente.
 */
class MainActivity : ComponentActivity() {

    private val viewModel: RadioViewModel by viewModels()

    private val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { _ -> }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permissionsToRequest = mutableListOf<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
            ) {
                permissionsToRequest.add(Manifest.permission.POST_NOTIFICATIONS)
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_AUDIO)
                != PackageManager.PERMISSION_GRANTED
            ) {
                permissionsToRequest.add(Manifest.permission.READ_MEDIA_AUDIO)
            }
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
            ) {
                permissionsToRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
        if (permissionsToRequest.isNotEmpty()) {
            requestPermissions.launch(permissionsToRequest.toTypedArray())
        }

        handleIntent(intent)

        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(
                    primary = GtaColors.Gold,
                    background = GtaColors.Background,
                    surface = GtaColors.Surface,
                    onSurface = Color.White
                )
            ) {
                val uiState by viewModel.uiState.collectAsState()

                GtaRadioScreen(
                    stations = uiState.stations,
                    selectedGame = uiState.selectedGameFilter,
                    activeStation = uiState.activeStation,
                    currentPlayingId = uiState.activeStation?.id,
                    isPlaying = uiState.isPlaying,
                    isBuffering = uiState.isBuffering,
                    errorMessage = uiState.errorMessage,
                    currentTrack = uiState.currentTrack,
                    progress = uiState.progress,
                    isOfflineReady = { station -> viewModel.isStationOffline(station) },
                    onGameSelect = { game -> viewModel.setGameFilter(game) },
                    onStationClick = { station -> viewModel.onStationClick(station) },
                    onTogglePlayPause = { viewModel.togglePlayPause() },
                    onSkipPrevious = { viewModel.skipPrevious() },
                    onSkipNext = { viewModel.skipNext() },
                    onStop = { viewModel.stop() }
                )
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        val gameFilter = intent?.getStringExtra("game_filter")
        val stationId = intent?.getStringExtra("station_id")
        if (gameFilter != null || stationId != null) {
            viewModel.handleDeepLink(gameFilter, stationId)
        }
    }
}

