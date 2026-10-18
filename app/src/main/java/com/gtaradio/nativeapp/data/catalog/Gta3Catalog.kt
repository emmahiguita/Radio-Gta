package com.gtaradio.nativeapp.data.catalog

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.model.Track

/**
 * Catálogo Oficial de Emisoras de Grand Theft Auto III (Liberty City, 2001).
 * Principio SOLID: Responsabilidad Única (SRP) - Provee los metadatos y fuentes reales de GTA III.
 */
object Gta3Catalog {
    val stations = listOf(
        Station(
            id = "gta3_head_radio",
            name = "Head Radio",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta3rs/Head%20Radio.mp3",
            genre = "Soft Rock / Pop",
            host = "Michael Hunt",
            fileAliases = listOf("head_radio", "HEAD", "Head Radio"),
            tracklist = listOf(
                Track("Dil-Don't", "Stripe Summer"),
                Track("Whatever", "Good Thing"),
                Track("Craig Gray", "Fade Away"),
                Track("Conor & Jay", "Change"),
                Track("Frankie Fame", "See Through You"),
                Track("Scatwerk", "Electronic Go Go"),
                Track("Dezma", "Life Is But A Mere Supply")
            )
        ),
        Station(
            id = "gta3_double_clef",
            name = "Double Clef FM",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta3rs/Double%20Clef%20FM.mp3",
            genre = "Classical / Opera",
            host = "Morgan Merryweather",
            fileAliases = listOf("double_clef", "CLASS", "Double Clef FM"),
            tracklist = listOf(
                Track("Wolfgang Amadeus Mozart", "Non piu andrai farfallone amoroso"),
                Track("Gaetano Donizetti", "Chi mi frena in tal momento"),
                Track("Giuseppe Verdi", "Libiamo ne' lieti calici"),
                Track("Wolfgang Amadeus Mozart", "Finch'han dal vino"),
                Track("Giacomo Puccini", "O mio babbino caro"),
                Track("Giuseppe Verdi", "La donna è mobile")
            )
        ),
        Station(
            id = "gta3_flashback",
            name = "Flashback 95.6",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta3rs/Flashback%20FM.mp3",
            genre = "80s Pop / Scarface OST",
            host = "Toni",
            fileAliases = listOf("flashback", "FLASH", "Flashback 95.6", "Flashback FM"),
            tracklist = listOf(
                Track("Debbie Harry", "Rush Rush"),
                Track("Elizabeth Daily", "Shake It Up"),
                Track("Paul Engemann", "Push It to the Limit"),
                Track("Amy Holland", "She's On Fire"),
                Track("Elizabeth Daily", "I'm Hot Tonight")
            )
        ),
        Station(
            id = "gta3_game_radio",
            name = "Game Radio FM",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta3rs/Game%20Radio.mp3",
            genre = "Hip-Hop / Underground Rap",
            host = "DJ Stretch Armstrong & Lord Sear",
            fileAliases = listOf("game_radio", "GAME", "Game Radio FM", "Game Radio"),
            tracklist = listOf(
                Track("Reef", "Scary Movies (Instrumental)"),
                Track("Royce Da 5'9\"", "We're Live (Danger)"),
                Track("Nature", "Nature Freestyle"),
                Track("JoJo Pellegrino", "JoJo Pellegrino Freestyle"),
                Track("Pretty Ugly & Royce Da 5'9\"", "Spit Game"),
                Track("Royce Da 5'9\"", "I'm the King"),
                Track("Black Rob", "By a Stranger"),
                Track("Agallah & Sean Price", "Rising to the Top")
            )
        ),
        Station(
            id = "gta3_lips_106",
            name = "Lips 106",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta3rs/Lips%20106.mp3",
            genre = "Pop / Top 40",
            host = "Andee",
            fileAliases = listOf("lips_106", "LIPS", "Lips 106"),
            tracklist = listOf(
                Track("Fatamarse", "Bump To The Music"),
                Track("Marydancin", "Wash Him Off"),
                Track("April's in Paris", "Feels Like I Just Can't Take No More"),
                Track("Lucy", "Forever"),
                Track("Boyz 2 Girlz", "Pray It Goes Ok?"),
                Track("Da Shootaz", "Grand Theft Auto"),
                Track("Funky Bjs", "Joyride")
            )
        ),
        Station(
            id = "gta3_msx_fm",
            name = "MSX FM",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta3rs/MSX%20FM.mp3",
            genre = "Drum & Bass / Jungle",
            host = "MC Codebreaker & DJ Timecode",
            fileAliases = listOf("msx_fm", "MSX", "MSX FM"),
            tracklist = listOf(
                Track("Calyx", "Quagmire"),
                Track("Rascal & Klone", "Get Wild"),
                Track("Ryme Tyme", "Judgment Day"),
                Track("Hex", "Force"),
                Track("Omni Trio", "First Contact"),
                Track("Aquasky", "Spectre"),
                Track("Rascal & Klone", "Winner Takes All"),
                Track("TJ Rizing", "Agent 007"),
                Track("Calyx", "Leviathan"),
                Track("D.Kay", "Monolith"),
                Track("Dom & Ryme Tyme", "Iceberg")
            )
        ),
        Station(
            id = "gta3_rise_fm",
            name = "Rise FM",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta3rs/Rise%20FM.mp3",
            genre = "Trance / Rave",
            host = "Andre The Accelerator",
            fileAliases = listOf("rise_fm", "RISE", "Rise FM"),
            tracklist = listOf(
                Track("Chris Walsh & Dave Beran", "Shake (Revolt Clogrock Remix)"),
                Track("Shiver", "Deep Time"),
                Track("R.R.D.S.", "Innerbattle"),
                Track("Slyder", "Score (Original Mix)"),
                Track("Slyder", "Neo (The One)")
            )
        ),
        Station(
            id = "gta3_chatterbox",
            name = "Chatterbox FM",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta3rs/Chatterbox%20FM.mp3",
            genre = "Talk Radio",
            host = "Lazlow",
            fileAliases = listOf("chatterbox", "CHAT", "Chatterbox FM")
        ),
        Station(
            id = "gta3_kjah",
            name = "K-JAH",
            game = Game.GTA_III,
            audioUrl = "https://archive.org/download/gta3rs/K-JAH.mp3",
            genre = "Dub / Roots Reggae",
            host = "Horace 'the Pacifist' Walsh",
            fileAliases = listOf("kjah", "KJAH", "K-JAH"),
            tracklist = listOf(
                Track("Scientist", "Dance of the Vampires"),
                Track("Scientist", "Your Teeth in My Neck"),
                Track("Scientist", "The Corpse Rises"),
                Track("Scientist", "The Mummy's Shroud"),
                Track("Scientist", "Plague of Zombies")
            )
        )
    )
}

