package com.gtaradio.nativeapp.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gtaradio.nativeapp.presentation.ui.theme.GtaColors

private const val GITHUB_REPO_URL = "https://github.com/emmahiguita/Radio-Gta"
private const val GITHUB_PROFILE_URL = "https://github.com/emmahiguita"

/**
 * Icono vectorial oficial de GitHub (Octocat) dibujado en Compose Canvas (24x24 viewport).
 */
@Composable
fun GitHubOctocatIcon(
    modifier: Modifier = Modifier.size(16.dp),
    tint: Color = Color.White
) {
    val octocatPath = remember {
        PathParser().parsePathString(
            "M12,2A10,10 0 0,0 2,12C2,16.42 4.87,20.17 8.84,21.5C9.34,21.58 9.5,21.27 9.5,21C9.5,20.77 9.5,20.14 9.5,19.31C6.73,19.91 6.14,17.97 6.14,17.97C5.68,16.81 5.03,16.5 5.03,16.5C4.12,15.88 5.1,15.9 5.1,15.9C6.1,15.97 6.63,16.93 6.63,16.93C7.5,18.45 8.97,18 9.54,17.76C9.63,17.11 9.89,16.67 10.17,16.42C7.95,16.17 5.62,15.31 5.62,11.5C5.62,10.39 6,9.5 6.65,8.79C6.55,8.54 6.2,7.5 6.75,6.15C6.75,6.15 7.59,5.88 9.5,7.17C10.29,6.95 11.15,6.84 12,6.84C12.85,6.84 13.71,6.95 14.5,7.17C16.41,5.88 17.25,6.15 17.25,6.15C17.8,7.5 17.45,8.54 17.35,8.79C18,9.5 18.38,10.39 18.38,11.5C18.38,15.32 16.04,16.16 13.81,16.41C14.17,16.72 14.5,17.33 14.5,18.26C14.5,19.6 14.5,20.68 14.5,21C14.5,21.27 14.66,21.59 15.17,21.5C19.14,20.16 22,16.42 22,12A10,10 0 0,0 12,2Z"
        ).toPath().apply {
            fillType = PathFillType.EvenOdd
        }
    }

    Canvas(modifier = modifier) {
        val scaleFactor = size.minDimension / 24f
        scale(scale = scaleFactor, pivot = androidx.compose.ui.geometry.Offset.Zero) {
            drawPath(path = octocatPath, color = tint)
        }
    }
}

/**
 * Cabecera principal con branding auténtico, acceso directo a GitHub (@emmahiguita) e información del repositorio.
 * Principio SOLID: Responsabilidad Única (SRP).
 */
@Composable
fun HeaderSection(errorMessage: String?) {
    val uriHandler = LocalUriHandler.current
    var showGitDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(GtaColors.Surface)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "GTA RADIO",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp,
                        color = GtaColors.Gold,
                        letterSpacing = 1.5.sp,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(
                        modifier = Modifier
                            .background(Color(0xFF1E2B22), RoundedCornerShape(4.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "● LIVE",
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold,
                            color = GtaColors.OfflineGreen,
                            maxLines = 1
                        )
                    }
                }

                Text(
                    text = "5 GENERACIONES • EN VIVO & OFFLINE",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = GtaColors.TextMuted,
                    maxLines = 1
                )

                Text(
                    text = "github.com/emmahiguita/Radio-Gta",
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Medium,
                    color = GtaColors.GoldDark,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .clickable { showGitDialog = true }
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Botón con icono de GitHub que redirige al repositorio de @emmahiguita + botón de info Git
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { uriHandler.openUri(GITHUB_REPO_URL) },
                    color = Color(0xFF24292E),
                    border = BorderStroke(1.dp, GtaColors.Gold),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp)
                    ) {
                        GitHubOctocatIcon(
                            modifier = Modifier.size(16.dp),
                            tint = GtaColors.Gold
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Column {
                            Text(
                                text = "GitHub",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                maxLines = 1
                            )
                            Text(
                                text = "@emmahiguita",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = GtaColors.Gold,
                                maxLines = 1
                            )
                        }
                    }
                }

                // Botón circular de información del repositorio Git
                Surface(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .clickable { showGitDialog = true },
                    color = Color(0xFF24292E),
                    border = BorderStroke(1.dp, Color(0xFF444444)),
                    shape = CircleShape
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = "ⓘ",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = GtaColors.Gold
                        )
                    }
                }
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

    if (showGitDialog) {
        AlertDialog(
            onDismissRequest = { showGitDialog = false },
            containerColor = Color(0xFF1A1A1A),
            titleContentColor = GtaColors.Gold,
            textContentColor = Color.White,
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    GitHubOctocatIcon(modifier = Modifier.size(22.dp), tint = GtaColors.Gold)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Información de Git & Autor",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp
                    )
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("• Proyecto: GTA Radio (Android Nativo)", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    Text("• Autor: Emmanuel Higuita (@emmahiguita)", fontSize = 13.sp, color = GtaColors.Gold)
                    Text("• Repositorio: github.com/emmahiguita/Radio-Gta", fontSize = 12.sp, color = Color(0xFFCCCCCC))
                    Text("• Rama: main (Clean Architecture & SOLID)", fontSize = 12.sp, color = Color(0xFFCCCCCC))
                    Text("• Emisoras: 64 estaciones originales completas (GTA III, Vice City, San Andreas, GTA IV y GTA V)", fontSize = 12.sp, color = Color(0xFFAAAAAA))
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showGitDialog = false
                        uriHandler.openUri(GITHUB_REPO_URL)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GtaColors.Gold,
                        contentColor = Color.Black
                    )
                ) {
                    Text("Abrir Repo en GitHub", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = {
                        showGitDialog = false
                        uriHandler.openUri(GITHUB_PROFILE_URL)
                    },
                    border = BorderStroke(1.dp, GtaColors.Gold)
                ) {
                    Text("Perfil @emmahiguita", color = GtaColors.Gold)
                }
            }
        )
    }
}
