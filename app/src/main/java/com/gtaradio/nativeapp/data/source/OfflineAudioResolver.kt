package com.gtaradio.nativeapp.data.source

import android.os.Environment
import com.gtaradio.nativeapp.domain.model.Station
import java.io.File

/**
 * Componente de resolución Offline-First para emisoras de radio.
 * Principio SOLID: Responsabilidad Única (SRP).
 * Busca y valida la existencia de archivos de audio reales en el almacenamiento del dispositivo.
 */
class OfflineAudioResolver {

    private val supportedExtensions = listOf("mp3", "ogg", "wav", "m4a", "flac", "aac")

    /**
     * Resuelve el URI de reproducción:
     * 1. Si existe localmente en /sdcard/GTA_Radio/{Juego}/ retorna file://...
     * 2. Si no existe, retorna la URL remota como respaldo.
     */
    fun resolve(station: Station): String {
        val candidateDirs = listOf(
            File("/sdcard/GTA_Radio/${station.game.folderName}"),
            File("/sdcard/GTA_Radio"),
            File("/sdcard/Music/GTA_Radio/${station.game.folderName}"),
            File("/sdcard/Music/GTA_Radio"),
            File(Environment.getExternalStorageDirectory(), "GTA_Radio/${station.game.folderName}"),
            File(Environment.getExternalStorageDirectory(), "GTA_Radio")
        )

        val candidateNames = (listOf(station.id, station.name) + station.fileAliases).distinct()

        for (dir in candidateDirs) {
            if (!dir.exists() || !dir.isDirectory) continue

            // Coincidencia exacta por nombre + extensión
            for (name in candidateNames) {
                for (ext in supportedExtensions) {
                    val file = File(dir, "$name.$ext")
                    if (file.exists() && file.length() > 0) {
                        return file.toURI().toString()
                    }
                }
            }

            // Coincidencia difusa (normalizando espacios y mayúsculas)
            val filesInDir = dir.listFiles() ?: emptyArray()
            for (f in filesInDir) {
                if (!f.isFile || f.length() == 0L) continue
                val base = f.nameWithoutExtension.lowercase().replace(" ", "").replace("-", "").replace("_", "")
                val matches = candidateNames.any { alias ->
                    val normAlias = alias.lowercase().replace(" ", "").replace("-", "").replace("_", "")
                    base == normAlias || base.contains(normAlias) || normAlias.contains(base)
                }
                if (matches) {
                    return f.toURI().toString()
                }
            }
        }

        return station.audioUrl
    }

    /**
     * Determina si el archivo de la emisora está disponible físicamente en el móvil sin red.
     */
    fun isOfflineReady(station: Station): Boolean {
        return resolve(station).startsWith("file:")
    }
}
