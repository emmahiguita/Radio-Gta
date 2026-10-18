package com.gtaradio.nativeapp.data.catalog

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station

/**
 * Catálogo Oficial de Emisoras de Grand Theft Auto V (Los Santos & Blaine County, 2013).
 * Principio SOLID: Responsabilidad Única (SRP) - Provee los metadatos y fuentes de GTA V.
 */
object Gta5Catalog {
    val stations = listOf(
        Station(
            id = "los_santos_rock",
            name = "Los Santos Rock Radio",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Los%20Santos%20Rock%20Radio.mp3",
            genre = "Classic Rock / Pop Rock",
            host = "Kenny Loggins",
            fileAliases = listOf("los_santos_rock", "LSRR", "Los Santos Rock Radio")
        ),
        Station(
            id = "non_stop_pop",
            name = "Non-Stop-Pop FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Non-Stop-Pop%20FM.mp3",
            genre = "Pop / Dance 80s-2010s",
            host = "Cara Delevingne",
            fileAliases = listOf("non_stop_pop", "NSP", "Non-Stop-Pop FM")
        ),
        Station(
            id = "radio_los_santos_v",
            name = "Radio Los Santos",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Radio%20Los%20Santos.mp3",
            genre = "Modern Hip-Hop / Trap",
            host = "Big Boy",
            fileAliases = listOf("radio_los_santos_v", "RLSV", "Radio Los Santos")
        ),
        Station(
            id = "west_coast_classics",
            name = "West Coast Classics",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/West%20Coast%20Classics.mp3",
            genre = "90s West Coast Rap",
            host = "DJ Pooh",
            fileAliases = listOf("west_coast_classics", "WCC", "West Coast Classics")
        ),
        Station(
            id = "rebel_radio",
            name = "Rebel Radio",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Rebel%20Radio.mp3",
            genre = "Outlaw Country / Rockabilly",
            host = "Jesco White",
            fileAliases = listOf("rebel_radio", "REBEL", "Rebel Radio")
        ),
        Station(
            id = "channel_x",
            name = "Channel X",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Channel%20X.mp3",
            genre = "Punk Rock / Hardcore",
            host = "Keith Morris",
            fileAliases = listOf("channel_x", "CHANNELX", "Channel X")
        ),
        Station(
            id = "flylo_fm",
            name = "FlyLo FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/FlyLo%20FM.mp3",
            genre = "Experimental / Electronic",
            host = "Flying Lotus",
            fileAliases = listOf("flylo_fm", "FLYLO", "FlyLo FM")
        ),
        Station(
            id = "space_1032",
            name = "Space 103.2",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Space%20103.2.mp3",
            genre = "Funk / Post-Disco",
            host = "Bootsy Collins",
            fileAliases = listOf("space_1032", "SPACE", "Space 103.2")
        ),
        Station(
            id = "the_lowdown",
            name = "The Lowdown 91.1",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/The%20Lowdown%2091.1.mp3",
            genre = "Classic Soul / R&B",
            host = "Pam Grier",
            fileAliases = listOf("the_lowdown", "LOWDOWN", "The Lowdown 91.1")
        ),
        Station(
            id = "soulwax_fm",
            name = "Soulwax FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Soulwax%20FM.mp3",
            genre = "Techno / Electro House",
            host = "Soulwax",
            fileAliases = listOf("soulwax_fm", "SOULWAX", "Soulwax FM")
        ),
        Station(
            id = "vinewood_boulevard",
            name = "Vinewood Boulevard Radio",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Vinewood%20Boulevard%20Radio.mp3",
            genre = "Alternative / Garage Rock",
            host = "Nate Schwarz & Stephen Pope",
            fileAliases = listOf("vinewood_boulevard", "VBR", "Vinewood Boulevard Radio")
        ),
        Station(
            id = "blue_ark",
            name = "Blue Ark",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Blue%20Ark.mp3",
            genre = "Reggae / Dancehall / Dub",
            host = "Lee 'Scratch' Perry",
            fileAliases = listOf("blue_ark", "BLUEARK", "Blue Ark")
        ),
        Station(
            id = "worldwide_fm",
            name = "Worldwide FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Worldwide%20FM.mp3",
            genre = "Jazz / Ambient / World",
            host = "Gilles Peterson",
            fileAliases = listOf("worldwide_fm", "WORLDWIDE", "Worldwide FM")
        ),
        Station(
            id = "radio_mirror_park",
            name = "Radio Mirror Park",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/Radio%20Mirror%20Park.mp3",
            genre = "Indie Pop / Synthwave",
            host = "Twin Shadow",
            fileAliases = listOf("radio_mirror_park", "RMP", "Radio Mirror Park")
        ),
        Station(
            id = "east_los_fm",
            name = "East Los FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/East%20Los%20FM.mp3",
            genre = "Mexican Electronic / Corrido",
            host = "Don Cheto & Camilo Lara",
            fileAliases = listOf("east_los_fm", "EASTLOS", "East Los FM")
        ),
        Station(
            id = "the_lab",
            name = "The Lab",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/The%20Lab.mp3",
            genre = "Hip-Hop / Synth Funk",
            host = "The Alchemist & Oh No",
            fileAliases = listOf("the_lab", "THELAB", "The Lab")
        ),
        Station(
            id = "blonded",
            name = "blonded Los Santos 97.8 FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/blonded%20Los%20Santos%2097.8%20FM.mp3",
            genre = "Eclectic / Rap / Soul",
            host = "Frank Ocean",
            fileAliases = listOf("blonded", "BLONDED", "blonded Los Santos")
        ),
        Station(
            id = "motomami",
            name = "MOTOMAMI Los Santos",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gta-v-radio/MOTOMAMI%20Los%20Santos.mp3",
            genre = "Reggaeton / Pop / Experimental",
            host = "Rosalía & Arca",
            fileAliases = listOf("motomami", "MOTOMAMI", "MOTOMAMI Los Santos")
        )
    )
}
