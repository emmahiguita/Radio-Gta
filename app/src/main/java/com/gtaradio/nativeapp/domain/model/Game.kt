package com.gtaradio.nativeapp.domain.model

enum class Game(val displayName: String, val shortName: String, val folderName: String) {
    GTA_III("Grand Theft Auto III", "GTA III", "GTA_III"),
    VICE_CITY("Grand Theft Auto: Vice City", "Vice City", "GTA_Vice_City"),
    SAN_ANDREAS("Grand Theft Auto: San Andreas", "San Andreas", "GTA_San_Andreas"),
    GTA_IV("Grand Theft Auto IV", "GTA IV", "GTA_IV"),
    GTA_V("Grand Theft Auto V", "GTA V", "GTA_V")
}
