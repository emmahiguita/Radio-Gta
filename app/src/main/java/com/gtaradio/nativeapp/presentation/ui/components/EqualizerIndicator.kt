package com.gtaradio.nativeapp.presentation.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gtaradio.nativeapp.presentation.ui.theme.GtaColors

/**
 * Ecualizador animado de 3 barras para retroalimentación visual en vivo.
 * Principio SOLID: Componente de renderizado puro y aislado.
 */
@Composable
fun EqualizerIndicator() {
    val infiniteTransition = rememberInfiniteTransition(label = "eq")

    val h1 by infiniteTransition.animateFloat(
        initialValue = 0.3f, targetValue = 1.0f,
        animationSpec = infiniteRepeatable(tween(400, easing = LinearEasing), RepeatMode.Reverse),
        label = "h1"
    )
    val h2 by infiniteTransition.animateFloat(
        initialValue = 0.8f, targetValue = 0.2f,
        animationSpec = infiniteRepeatable(tween(350, easing = LinearEasing), RepeatMode.Reverse),
        label = "h2"
    )
    val h3 by infiniteTransition.animateFloat(
        initialValue = 0.4f, targetValue = 0.9f,
        animationSpec = infiniteRepeatable(tween(450, easing = LinearEasing), RepeatMode.Reverse),
        label = "h3"
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.height(20.dp)
    ) {
        Box(modifier = Modifier.width(3.dp).fillMaxHeight(h1).background(GtaColors.Gold, RoundedCornerShape(1.dp)))
        Box(modifier = Modifier.width(3.dp).fillMaxHeight(h2).background(GtaColors.Gold, RoundedCornerShape(1.dp)))
        Box(modifier = Modifier.width(3.dp).fillMaxHeight(h3).background(GtaColors.Gold, RoundedCornerShape(1.dp)))
    }
}
