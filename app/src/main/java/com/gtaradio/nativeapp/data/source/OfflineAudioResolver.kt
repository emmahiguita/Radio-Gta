package com.gtaradio.nativeapp.data.source

import android.os.Environment
import com.gtaradio.nativeapp.domain.model.Station
import java.io.File
import java.io.FileInputStream

/**
 * Componente de resolución Offline-First para emisoras de radio.
 * Principio SOLID: Responsabilidad Única (SRP).
 * Busca y valida la existencia y permiso real de lectura de emisiones completas en el dispositivo.
 */
class OfflineAudioResolver {

    private val supportedExtensions = listOf("mp3", "ogg", "wav", "m4a", "flac", "aac")

    /**
     * Tamaño mínimo de una emisión de radio real completa (15 MB).
     * Evita que muestras truncadas o canciones sueltas reemplacen la emisora real del juego.
     */
    private val minRealBroadcastBytes = 15L * 1024L * 1024L

    /**
     * Resuelve el URI de reproducción:
     * 1. Si existe una emisión completa y legible localmente en /sdcard/GTA_Radio/{Juego}/ retorna file://...
     * 2. Si no existe o no hay permiso de lectura, retorna la URL remota real como respaldo.
     */
    fun resolve(station: Station): String {
        val candidateDirs = listOfNotNull(
            File("/sdcard/GTA_Radio/${station.game.folderName}"),
            File("/sdcard/GTA_Radio"),
            File("/sdcard/Music/GTA_Radio/${station.game.folderName}"),
            File("/sdcard/Music/GTA_Radio"),
            runCatching { File(Environment.getExternalStorageDirectory(), "GTA_Radio/${station.game.folderName}") }.getOrNull(),
            runCatching { File(Environment.getExternalStorageDirectory(), "GTA_Radio") }.getOrNull()
        )

        val candidateNames = (listOf(station.id, station.name) + station.fileAliases).distinct()

        for (dir in candidateDirs) {
            if (!dir.exists() || !dir.isDirectory) continue

            // Coincidencia exacta por nombre + extensión
            for (name in candidateNames) {
                for (ext in supportedExtensions) {
                    val file = File(dir, "$name.$ext")
                    if (isValidBroadcastFile(file)) {
                        return file.toURI().toString()
                    }
                }
            }

            // Coincidencia difusa (normalizando espacios y mayúsculas)
            val filesInDir = runCatching { dir.listFiles() }.getOrNull() ?: emptyArray()
            for (f in filesInDir) {
                if (!isValidBroadcastFile(f)) continue
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
     * Verifica que el archivo exista, corresponda a una emisión completa y tenga permiso real de lectura (evita EACCES).
     */
    private fun isValidBroadcastFile(file: File): Boolean {
        if (!file.exists() || !file.isFile || file.length() < minRealBroadcastBytes) return false
        return runCatching {
            FileInputStream(file).use { stream -> stream.read() >= 0 }
        }.getOrDefault(false)
    }

    /**
     * Determina si el archivo de la emisora está disponible y legible físicamente en el móvil sin red.
     */
    fun isOfflineReady(station: Station): Boolean {
        return resolve(station).startsWith("file:")
    }
}

