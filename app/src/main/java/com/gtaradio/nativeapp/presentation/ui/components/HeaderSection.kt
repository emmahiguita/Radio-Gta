package com.gtaradio.nativeapp.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gtaradio.nativeapp.presentation.ui.theme.GtaColors

private const val GITHUB_REPO_URL = "https://github.com/emmahiguita/Radio-Gta"
private const val FACEBOOK_URL = "https://www.facebook.com/Devemmai/"

/**
 * Icono vectorial de GitHub (Octocat) en Compose Canvas (24x24 viewport).
 */
@Composable
fun GitHubOctocatIcon(
    modifier: Modifier = Modifier.size(18.dp),
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
 * Icono vectorial de Facebook en Compose Canvas (24x24 viewport).
 */
@Composable
fun FacebookIcon(
    modifier: Modifier = Modifier.size(18.dp),
    tint: Color = Color.White
) {
    val fbPath = remember {
        PathParser().parsePathString(
            "M12 2.04C6.5 2.04 2 6.53 2 12.06C2 17.06 5.66 21.21 10.44 21.96V14.96H7.9V12.06H10.44V9.85C10.44 7.34 11.93 5.96 14.22 5.96C15.31 5.96 16.45 6.15 16.45 6.15V8.62H15.19C13.95 8.62 13.56 9.39 13.56 10.18V12.06H16.34L15.89 14.96H13.56V21.96A10 10 0 0 0 22 12.06C22 6.53 17.5 2.04 12 2.04Z"
        ).toPath()
    }

    Canvas(modifier = modifier) {
        val scaleFactor = size.minDimension / 24f
        scale(scale = scaleFactor, pivot = androidx.compose.ui.geometry.Offset.Zero) {
            drawPath(path = fbPath, color = tint)
        }
    }
}

/**
 * Cabecera principal limpia y minimalista con un único icono discreto para redes/Git.
 * Principio SOLID: Responsabilidad Única (SRP).
 */
@Composable
fun HeaderSection(errorMessage: String?) {
    val uriHandler = LocalUriHandler.current
    var showLinksModal by remember { mutableStateOf(false) }

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
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "GTA RADIO",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = GtaColors.Gold,
                    letterSpacing = 2.sp
                )
                Text(
                    text = "5 GENERACIONES • EN VIVO & OFFLINE",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = GtaColors.TextMuted,
                    letterSpacing = 0.4.sp,
                    maxLines = 1
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Un único icono discreto que abre los enlaces del desarrollador (GitHub + Facebook) sin estorbar el diseño
            Surface(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable { showLinksModal = true },
                color = Color(0xFF222222),
                border = BorderStroke(1.dp, Color(0xFF3A3A3A)),
                shape = CircleShape
            ) {
                Box(contentAlignment = Alignment.Center) {
                    GitHubOctocatIcon(
                        modifier = Modifier.size(18.dp),
                        tint = GtaColors.Gold
                    )
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

    if (showLinksModal) {
        AlertDialog(
            onDismissRequest = { showLinksModal = false },
            containerColor = Color(0xFF1A1A1A),
            titleContentColor = GtaColors.Gold,
            textContentColor = Color.White,
            title = {
                Text(
                    text = "Devemmai • Enlaces Oficiales",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    // Opción 1: GitHub
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .clickable {
                                showLinksModal = false
                                uriHandler.openUri(GITHUB_REPO_URL)
                            },
                        color = Color(0xFF24292E),
                        border = BorderStroke(1.dp, GtaColors.Gold),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp)
                        ) {
                            GitHubOctocatIcon(modifier = Modifier.size(20.dp), tint = GtaColors.Gold)
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("GitHub (@emmahiguita)", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
                                Text("github.com/emmahiguita/Radio-Gta", fontSize = 11.sp, color = Color(0xFFBBBBBB))
                            }
                        }
                    }

                    // Opción 2: Facebook
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .clickable {
                                showLinksModal = false
                                uriHandler.openUri(FACEBOOK_URL)
                            },
                        color = Color(0xFF1B263B),
                        border = BorderStroke(1.dp, Color(0xFF1877F2)),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp)
                        ) {
                            FacebookIcon(modifier = Modifier.size(20.dp), tint = Color(0xFF1877F2))
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text("Facebook (Devemmai)", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
                                Text("facebook.com/Devemmai", fontSize = 11.sp, color = Color(0xFFBBBBBB))
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showLinksModal = false }) {
                    Text("Cerrar", color = GtaColors.Gold)
                }
            }
        )
    }
}
