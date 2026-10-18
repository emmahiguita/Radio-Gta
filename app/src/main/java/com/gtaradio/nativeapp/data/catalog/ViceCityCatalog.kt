package com.gtaradio.nativeapp.data.catalog

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.model.Track

/**
 * Catálogo de Vice City con tracklists reales extraídas de GTA Wiki.
 * Fuente: gta.fandom.com — todas las pistas son del juego original (1986).
 */
object ViceCityCatalog {
    val stations = listOf(
        Station(
            id = "flash_fm",
            name = "Flash FM",
            game = Game.VICE_CITY,
            audioUrl = "https://archive.org/download/gtavcrs/Flash%20FM.mp3",
            genre = "Pop / Synth 80s", host = "DJ Toni",
            fileAliases = listOf("flash_fm", "FLASH", "Flash FM"),
            tracklist = listOf(
                Track("Hall & Oates", "Out of Touch"),
                Track("Electric Light Orchestra", "Four Little Diamonds"),
                Track("Michael Jackson", "Billie Jean"),
                Track("The Outfield", "Your Love"),
                Track("Talk Talk", "Life's What You Make It"),
                Track("Bryan Adams", "Run to You"),
                Track("Wang Chung", "Dance Hall Days"),
                Track("Go West", "Call Me"),
                Track("Lionel Richie", "Running with the Night"),
                Track("Laura Branigan", "Self Control"),
                Track("INXS", "Kiss the Dirt"),
                Track("Yes", "Owner of a Lonely Heart"),
                Track("REO Speedwagon", "Keep On Loving You")
            )
        ),
        Station(
            id = "wave_103",
            name = "Wave 103",
            game = Game.VICE_CITY,
            audioUrl = "https://archive.org/download/gtavcrs/Wave%20103.mp3",
            genre = "New Wave / Synthpop", host = "Adam First",
            fileAliases = listOf("wave_103", "WAVE", "Wave 103"),
            tracklist = listOf(
                Track("Frankie Goes to Hollywood", "Two Tribes"),
                Track("Tears for Fears", "Pale Shelter"),
                Track("Human League", "Human"),
                Track("Blondie", "Atomic"),
                Track("A Flock of Seagulls", "I Ran (So Far Away)"),
                Track("The Psychedelic Furs", "Love My Way"),
                Track("The Buggles", "Video Killed the Radio Star"),
                Track("Spandau Ballet", "True"),
                Track("New Order", "Blue Monday"),
                Track("The Cure", "A Forest"),
                Track("Duran Duran", "Is There Something I Should Know?"),
                Track("Altered Images", "Happy Birthday")
            )
        ),
        Station(
            id = "vrock",
            name = "V-Rock",
            game = Game.VICE_CITY,
            audioUrl = "https://archive.org/download/gtavcrs/V-Rock.mp3",
            genre = "Heavy Metal / Hard Rock", host = "Lazlow",
            fileAliases = listOf("vrock", "VROCK", "V-Rock"),
            tracklist = listOf(
                Track("Twisted Sister", "I Wanna Rock"),
                Track("Mötley Crüe", "Too Young to Fall in Love"),
                Track("The Cult", "She Sells Sanctuary"),
                Track("Ozzy Osbourne", "Bark at the Moon"),
                Track("Iron Maiden", "2 Minutes to Midnight"),
                Track("Slayer", "Raining Blood"),
                Track("Judas Priest", "You've Got Another Thing Comin'"),
                Track("David Lee Roth", "Yankee Rose"),
                Track("Accept", "Balls to the Wall"),
                Track("Autograph", "Turn Up the Radio"),
                Track("Megadeth", "Peace Sells"),
                Track("Anthrax", "Madhouse"),
                Track("Iron Maiden", "Run to the Hills")
            )
        ),
        Station(
            id = "wildstyle",
            name = "Wildstyle",
            game = Game.VICE_CITY,
            audioUrl = "https://archive.org/download/gtavcrs/Wildstyle.mp3",
            genre = "Old School Hip Hop / Electro", host = "Mr. Magic",
            fileAliases = listOf("wildstyle", "WILD", "Wildstyle"),
            tracklist = listOf(
                Track("Trouble Funk", "Pump Me Up"),
                Track("Herbie Hancock", "Rockit"),
                Track("Afrika Bambaataa", "Looking for the Perfect Beat"),
                Track("Rockwell", "Somebody's Watching Me"),
                Track("Kurtis Blow", "The Breaks"),
                Track("Whodini", "Magic's Wand"),
                Track("Grandmaster Flash & The Furious Five", "The Message"),
                Track("Zapp", "More Bounce to the Ounce"),
                Track("Hashim", "Al-Naafiysh (The Soul)"),
                Track("Man Parrish", "Hip Hop Be Bop (Don't Stop)")
            )
        ),
        Station(
            id = "emotion_983",
            name = "Emotion 98.3",
            game = Game.VICE_CITY,
            audioUrl = "https://archive.org/download/gtavcrs/Emotion%2098.3.mp3",
            genre = "Power Ballads / Soft Rock", host = "Fernando Martinez",
            fileAliases = listOf("emotion_983", "EMOTION", "Emotion 98.3"),
            tracklist = listOf(
                Track("Toto", "Africa"),
                Track("Jan Hammer", "Crockett's Theme"),
                Track("John Waite", "Missing You"),
                Track("Cutting Crew", "(I Just) Died in Your Arms"),
                Track("Foreigner", "Waiting for a Girl Like You"),
                Track("Mr. Mister", "Broken Wings"),
                Track("Roxy Music", "More Than This"),
                Track("Squeeze", "Tempted"),
                Track("Night Ranger", "Sister Christian"),
                Track("Luther Vandross", "Never Too Much"),
                Track("Kate Bush", "Wow")
            )
        ),
        Station(
            id = "fever_105",
            name = "Fever 105",
            game = Game.VICE_CITY,
            audioUrl = "https://archive.org/download/gtavcrs/Fever%20105.mp3",
            genre = "Soul / Disco / R&B", host = "Oliver 'Ladykiller' Biscuit",
            fileAliases = listOf("fever_105", "FEVER", "Fever 105"),
            tracklist = listOf(
                Track("Anita Ward", "Ring My Bell"),
                Track("Gloria Gaynor", "I Will Survive"),
                Track("Thelma Houston", "Don't Leave Me This Way"),
                Track("Amii Stewart", "Knock on Wood"),
                Track("Diana Ross", "I'm Coming Out"),
                Track("Sylvester", "Do You Wanna Funk"),
                Track("Sister Sledge", "He's the Greatest Dancer"),
                Track("Chic", "Good Times"),
                Track("KC and the Sunshine Band", "That's the Way (I Like It)"),
                Track("The Trammps", "Disco Inferno")
            )
        ),
        Station(
            id = "radio_espantoso",
            name = "Radio Espantoso",
            game = Game.VICE_CITY,
            audioUrl = "https://archive.org/download/gtavcrs/Radio%20Espantoso.mp3",
            genre = "Latin Jazz / Salsa", host = "Pepe",
            fileAliases = listOf("radio_espantoso", "ESPANTOSO", "Radio Espantoso"),
            tracklist = listOf(
                Track("Deodato", "Super Strut"),
                Track("Cachao", "A Gozar Con Mi Combo"),
                Track("Mongo Santamaria", "Me And You Baby"),
                Track("Machito and his Afro-Cuban Orchestra", "Mambo Mucho Mambo"),
                Track("Lonnie Liston Smith", "Expansions"),
                Track("Irakere", "Anache O"),
                Track("Beny Moré", "Miami"),
                Track("Tito Puente", "Mambo Gozon")
            )
        ),
        Station(
            id = "kchat",
            name = "K-Chat",
            game = Game.VICE_CITY,
            audioUrl = "https://archive.org/download/gtavcrs/K-Chat.mp3",
            genre = "Celebrity Talk Radio", host = "Amy Sheckenhausen",
            fileAliases = listOf("kchat", "KCHAT", "K-Chat"),
            tracklist = emptyList() // Talk radio – sin tracklist de canciones
        ),
        Station(
            id = "vcpr",
            name = "VCPR",
            game = Game.VICE_CITY,
            audioUrl = "https://archive.org/download/gtavcrs/VCPR.mp3",
            genre = "Vice City Public Radio / Talk", host = "Maurice Chavez",
            fileAliases = listOf("vcpr", "VCPR", "Vice City Public Radio"),
            tracklist = emptyList() // Talk radio – sin tracklist de canciones
        )
    )
}
