package com.gtaradio.nativeapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gtaradio.nativeapp.presentation.ui.theme.GtaColors

/**
 * Cabecera principal con branding auténtico y avisos de estado.
 * Principio SOLID: Responsabilidad Única (SRP).
 */
@Composable
fun HeaderSection(errorMessage: String?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(GtaColors.Surface)
            .padding(horizontal = 20.dp, vertical = 14.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "GTA RADIO",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = GtaColors.Gold,
                    letterSpacing = 2.sp
                )
                Text(
                    text = "5 GENERACIONES • NATIVO & OFFLINE",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = GtaColors.TextMuted,
                    letterSpacing = 1.sp
                )
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFF222222), RoundedCornerShape(6.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "OFFLINE READY",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = GtaColors.OfflineGreen
                )
            }
        }

        errorMessage?.let { error ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = error,
                color = Color(0xFFFF5252),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
