package com.gtaradio.nativeapp.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.gtaradio.nativeapp.presentation.ui.theme.GtaColors

/**
 * Tarjeta individual para mostrar cada emisora de radio real de GTA.
 * Principio SOLID: Componente de presentación sin acoplamiento a servicios o red.
 */
@Composable
fun StationCard(
    station: Station,
    isSelected: Boolean,
    isPlaying: Boolean,
    isBuffering: Boolean,
    isOfflineReady: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isSelected) GtaColors.Gold else Color(0xFF2A2A2A)
    val cardBg = if (isSelected) GtaColors.CardActive else GtaColors.Card

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick),
        color = cardBg,
        border = BorderStroke(1.dp, borderColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = station.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = station.game.shortName,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = GtaColors.GoldDark
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = station.genre,
                    fontSize = 12.sp,
                    color = GtaColors.TextMuted,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                station.host?.let { host ->
                    Text(
                        text = "DJ: $host",
                        fontSize = 11.sp,
                        color = Color(0xFF757575),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Indicador de estado de reproducción
            if (isPlaying) {
                EqualizerIndicator()
            } else if (isBuffering) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 2.dp,
                    color = GtaColors.Gold
                )
            } else if (isOfflineReady) {
                Text(
                    text = "● LOCAL",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = GtaColors.OfflineGreen
                )
            }
        }
    }
}
