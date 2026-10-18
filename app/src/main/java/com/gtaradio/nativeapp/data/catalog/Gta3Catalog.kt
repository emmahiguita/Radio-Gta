package com.gtaradio.nativeapp.data.catalog

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station

/**
 * Catálogo Oficial de Emisoras de Grand Theft Auto III (Liberty City, 2001).
 * Principio SOLID: Responsabilidad Única (SRP) - Provee los metadatos y fuentes de GTA III.
 */
object Gta3Catalog {
    val stations = listOf(
        Station(
            id = "gta3_head_radio",
            name = "Head Radio",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta-iii-radio/Head%20Radio.mp3",
            genre = "Soft Rock / Pop",
            host = "Michael Hunt",
            fileAliases = listOf("head_radio", "HEAD", "Head Radio")
        ),
        Station(
            id = "gta3_double_clef",
            name = "Double Clef FM",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta-iii-radio/Double%20Clef%20FM.mp3",
            genre = "Classical / Opera",
            host = "Morgan Merryweather",
            fileAliases = listOf("double_clef", "CLASS", "Double Clef FM")
        ),
        Station(
            id = "gta3_flashback",
            name = "Flashback 95.6",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta-iii-radio/Flashback%2095.6.mp3",
            genre = "80s Pop / Scarface OST",
            host = "Toni",
            fileAliases = listOf("flashback", "FLASH", "Flashback 95.6")
        ),
        Station(
            id = "gta3_game_radio",
            name = "Game Radio FM",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta-iii-radio/Game%20Radio%20FM.mp3",
            genre = "Hip-Hop / Underground Rap",
            host = "DJ Stretch Armstrong & Lord Sear",
            fileAliases = listOf("game_radio", "GAME", "Game Radio FM")
        ),
        Station(
            id = "gta3_lips_106",
            name = "Lips 106",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta-iii-radio/Lips%20106.mp3",
            genre = "Pop / Top 40",
            host = "Andee",
            fileAliases = listOf("lips_106", "LIPS", "Lips 106")
        ),
        Station(
            id = "gta3_msx_fm",
            name = "MSX FM",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta-iii-radio/MSX%20FM.mp3",
            genre = "Drum & Bass / Jungle",
            host = "MC Codebreaker & DJ Timecode",
            fileAliases = listOf("msx_fm", "MSX", "MSX FM")
        ),
        Station(
            id = "gta3_rise_fm",
            name = "Rise FM",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta-iii-radio/Rise%20FM.mp3",
            genre = "Trance / Rave",
            host = "Andre The Accelerator",
            fileAliases = listOf("rise_fm", "RISE", "Rise FM")
        ),
        Station(
            id = "gta3_chatterbox",
            name = "Chatterbox FM",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta-iii-radio/Chatterbox%20FM.mp3",
            genre = "Talk Radio",
            host = "Lazlow",
            fileAliases = listOf("chatterbox", "CHAT", "Chatterbox FM")
        ),
        Station(
            id = "gta3_kjah",
            name = "K-JAH",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta-iii-radio/K-JAH.mp3",
            genre = "Dub / Roots Reggae",
            host = "Horace 'the Pacifist' Walsh",
            fileAliases = listOf("kjah", "KJAH", "K-JAH")
        )
    )
}
