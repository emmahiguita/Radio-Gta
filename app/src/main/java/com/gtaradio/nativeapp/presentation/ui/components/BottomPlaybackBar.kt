package com.gtaradio.nativeapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.model.Track
import com.gtaradio.nativeapp.presentation.ui.theme.GtaColors

/**
 * Barra inferior de reproducción con controles de radio completos.
 * Incluye: skip anterior, play/pausa, skip siguiente, barra de progreso y canción actual.
 * Principio SOLID: SRP — componente de control desacoplado.
 */
@Composable
fun BottomPlaybackBar(
    station: Station,
    currentTrack: Track?,
    isPlaying: Boolean,
    isBuffering: Boolean,
    progress: Float,
    onTogglePlayPause: () -> Unit,
    onSkipPrevious: () -> Unit,
    onSkipNext: () -> Unit,
    onStop: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF1A1A1A),
        shadowElevation = 16.dp,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            // Barra de progreso real
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth().height(2.dp),
                color = GtaColors.Gold,
                trackColor = Color(0xFF333333)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Info de emisora y canción actual
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = station.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    // Si hay tracklist, muestra artista — canción; si no, muestra género
                    val subtitle = if (currentTrack != null)
                        "${currentTrack.artist} — ${currentTrack.title}"
                    else if (isBuffering) "Conectando..."
                    else "${station.game.shortName} • ${station.genre}"
                    Text(
                        text = subtitle,
                        fontSize = 11.sp,
                        color = GtaColors.Gold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Controles: ⏮ ▶/⏸ ⏭ ⏹
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Skip anterior
                    IconButton(onClick = onSkipPrevious, modifier = Modifier.size(36.dp)) {
                        Text("⏮", fontSize = 16.sp, color = Color.White)
                    }

                    // Play / Pausa
                    IconButton(
                        onClick = onTogglePlayPause,
                        modifier = Modifier.size(44.dp).clip(CircleShape).background(GtaColors.Gold)
                    ) {
                        if (isBuffering) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                strokeWidth = 2.dp,
                                color = Color.Black
                            )
                        } else {
                            Text(
                                text = if (isPlaying) "⏸" else "▶",
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    // Skip siguiente
                    IconButton(onClick = onSkipNext, modifier = Modifier.size(36.dp)) {
                        Text("⏭", fontSize = 16.sp, color = Color.White)
                    }

                    // Stop
                    IconButton(onClick = onStop, modifier = Modifier.size(36.dp)) {
                        Text("⏹", fontSize = 16.sp, color = Color(0xFFFF5252))
                    }
                }
            }
        }
    }
}
