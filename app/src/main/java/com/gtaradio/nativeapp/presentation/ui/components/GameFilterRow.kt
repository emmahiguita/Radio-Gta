package com.gtaradio.nativeapp.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.presentation.ui.theme.GtaColors

/**
 * Fila de filtros horizontales para navegar entre las 5 generaciones de GTA.
 * Principio SOLID: Componente desacoplado que notifica cambios mediante lambdas.
 */
@Composable
fun GameFilterRow(
    selectedGame: Game?,
    onGameSelect: (Game?) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        GameFilterChip(
            title = "Todas (64)",
            isSelected = (selectedGame == null),
            onClick = { onGameSelect(null) }
        )

        Game.values().forEach { game ->
            GameFilterChip(
                title = game.shortName,
                isSelected = (selectedGame == game),
                onClick = { onGameSelect(game) }
            )
        }
    }
}

@Composable
private fun GameFilterChip(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val bgColor by animateColorAsState(
        targetValue = if (isSelected) GtaColors.Gold else GtaColors.Card,
        label = "chipBg"
    )
    val textColor = if (isSelected) Color.Black else Color.White

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(bgColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Text(
            text = title,
            color = textColor,
            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
            fontSize = 12.sp
        )
    }
}
