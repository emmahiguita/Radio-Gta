package com.gtaradio.nativeapp.data.catalog

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station

/**
 * Catálogo Oficial de Emisoras de Grand Theft Auto IV (Liberty City, 2008).
 * Principio SOLID: Responsabilidad Única (SRP) - Provee los metadatos y fuentes de GTA IV.
 */
object Gta4Catalog {
    val stations = listOf(
        Station(
            id = "vladivostok",
            name = "Vladivostok FM",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Vladivostok%20FM.mp3",
            genre = "Eastern European Dance / Pop",
            host = "Ruslana",
            fileAliases = listOf("vladivostok", "VLAD", "Vladivostok FM")
        ),
        Station(
            id = "liberty_rock",
            name = "Liberty Rock Radio",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Liberty%20Rock%20Radio.mp3",
            genre = "Classic Rock",
            host = "Iggy Pop",
            fileAliases = listOf("liberty_rock", "LRR", "Liberty Rock Radio")
        ),
        Station(
            id = "electro_choc",
            name = "Electro-Choc",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Electro-Choc.mp3",
            genre = "Electro House / Club",
            host = "François K",
            fileAliases = listOf("electro_choc", "ELECTRO", "Electro-Choc")
        ),
        Station(
            id = "san_juan",
            name = "San Juan Sounds",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/San%20Juan%20Sounds.mp3",
            genre = "Latin / Reggaeton",
            host = "Daddy Yankee",
            fileAliases = listOf("san_juan", "SANJUAN", "San Juan Sounds")
        ),
        Station(
            id = "massive_b",
            name = "Massive B Soundsystem",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Massive%20B%20Soundsystem.mp3",
            genre = "Dancehall / Reggae",
            host = "Bobby Konders",
            fileAliases = listOf("massive_b", "MASSIVEB", "Massive B Soundsystem")
        ),
        Station(
            id = "the_beat",
            name = "The Beat 102.7",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/The%20Beat%20102.7.mp3",
            genre = "Contemporary Hip-Hop",
            host = "Mister Cee & DJ Green Lantern",
            fileAliases = listOf("the_beat", "THEBEAT", "The Beat 102.7")
        ),
        Station(
            id = "the_vibe",
            name = "The Vibe 98.8",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/The%20Vibe%2098.8.mp3",
            genre = "Soul / R&B",
            host = "Vaughn Harper",
            fileAliases = listOf("the_vibe", "THEVIBE", "The Vibe 98.8")
        ),
        Station(
            id = "jazz_nation",
            name = "Jazz Nation Radio",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Jazz%20Nation%20Radio.mp3",
            genre = "Jazz / Bebop",
            host = "Roy Haynes",
            fileAliases = listOf("jazz_nation", "JNR", "Jazz Nation Radio")
        ),
        Station(
            id = "fusion_fm",
            name = "Fusion FM",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Fusion%20FM.mp3",
            genre = "Jazz Fusion / Funk",
            host = "Roy Ayers",
            fileAliases = listOf("fusion_fm", "FUSION", "Fusion FM")
        ),
        Station(
            id = "radio_broker",
            name = "Radio Broker",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Radio%20Broker.mp3",
            genre = "Indie Rock / Alternative",
            host = "Juliette Lewis",
            fileAliases = listOf("radio_broker", "BROKER", "Radio Broker")
        ),
        Station(
            id = "wktt",
            name = "WKTT Radio",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/WKTT%20Radio.mp3",
            genre = "Talk Radio (We Know The Truth)",
            host = "Richard Bastion",
            fileAliases = listOf("wktt", "WKTT", "WKTT Radio")
        ),
        Station(
            id = "plr",
            name = "Public Liberty Radio",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Public%20Liberty%20Radio.mp3",
            genre = "Liberal Talk Radio",
            host = "Various Hosts",
            fileAliases = listOf("plr", "PLR", "Public Liberty Radio")
        )
    )
}
