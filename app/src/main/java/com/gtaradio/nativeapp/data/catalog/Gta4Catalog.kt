package com.gtaradio.nativeapp.data.catalog

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.model.Track

/**
 * Catálogo Oficial de Emisoras de Grand Theft Auto IV (Liberty City, 2008).
 * Principio SOLID: Responsabilidad Única (SRP) - Provee los metadatos y fuentes reales de GTA IV.
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
            fileAliases = listOf("vladivostok", "VLAD", "Vladivostok FM"),
            tracklist = listOf(
                Track("Glukoza", "Schweine"),
                Track("Ruslana", "Wild Dances"),
                Track("Kino", "Gruppa Krovi"),
                Track("Seryoga", "King Ring"),
                Track("Basta", "Mama"),
                Track("Leningrad", "Nikogo Ne Zhalko"),
                Track("Ranetki Girls", "O Tebe"),
                Track("Zveri", "Kvartira"),
                Track("Oleg Kvasha", "Zelenoglazoe Taksi")
            )
        ),
        Station(
            id = "liberty_rock",
            name = "Liberty Rock Radio",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Liberty%20Rock%20Radio.mp3",
            genre = "Classic Rock",
            host = "Iggy Pop",
            fileAliases = listOf("liberty_rock", "LRR", "Liberty Rock Radio"),
            tracklist = listOf(
                Track("The Smashing Pumpkins", "1979"),
                Track("Queen", "One Vision"),
                Track("Black Sabbath", "Heaven and Hell"),
                Track("Electric Light Orchestra", "Evil Woman"),
                Track("David Bowie", "Fascination"),
                Track("Heart", "Straight On"),
                Track("Iggy Pop", "The Passenger"),
                Track("R.E.M.", "Turn You Inside-Out"),
                Track("ZZ Top", "Thug"),
                Track("Genesis", "Mama"),
                Track("The Who", "The Seeker")
            )
        ),
        Station(
            id = "electro_choc",
            name = "Electro-Choc",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Electro-Choc.mp3",
            genre = "Electro House / Club",
            host = "François K",
            fileAliases = listOf("electro_choc", "ELECTRO", "Electro-Choc"),
            tracklist = listOf(
                Track("Justice", "Waters of Nazareth"),
                Track("Boys Noize", "& Down"),
                Track("Kavinsky", "Testarossa Autodrive (SebastiAn Remix)"),
                Track("Simian Mobile Disco", "Tits & Acid"),
                Track("Alex Gopher", "Brain Leech (Bugged Mind Remix)"),
                Track("Padded Cell", "Signal Failure"),
                Track("K.I.M.", "B.T.T.T.T.R.Y. (Bag Raiders Remix)")
            )
        ),
        Station(
            id = "san_juan",
            name = "San Juan Sounds",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/San%20Juan%20Sounds.mp3",
            genre = "Latin / Reggaeton",
            host = "Daddy Yankee & Henry Santos",
            fileAliases = listOf("san_juan", "SANJUAN", "San Juan Sounds"),
            tracklist = listOf(
                Track("Daddy Yankee", "Impacto"),
                Track(" Calle 13", "Atrévete-te-te"),
                Track("Don Omar", "Salió El Sol"),
                Track("Wisin & Yandel", "Sexy Movimiento"),
                Track("Tito El Bambino", "Siente El Boom (Remix)"),
                Track("Aventura", "El Desprecio"),
                Track("Voltio feat. Jowell & Randy", "Pónmela"),
                Track("Hector El Father", "Maldades")
            )
        ),
        Station(
            id = "massive_b",
            name = "Massive B Soundsystem 96.9",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Massive%20B%20Soundsystem%2096.9.mp3",
            genre = "Dancehall / Reggae",
            host = "Bobby Konders",
            fileAliases = listOf("massive_b", "MASSIVEB", "Massive B Soundsystem", "Massive B Soundsystem 96.9"),
            tracklist = listOf(
                Track("Burro Banton", "Badder Den Dem"),
                Track("Choppa Chop", "Set It Off"),
                Track("Mavado", "Real McKoy"),
                Track("Jabba", "Raise It Up"),
                Track("Buju Banton", "Driver"),
                Track("Bounty Killer", "Bullet Proof Skin"),
                Track("Shaggy", "Church Heathen"),
                Track("Chezidek", "Call Pon Dem")
            )
        ),
        Station(
            id = "the_beat",
            name = "The Beat 102.7",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/The%20Beat%20102.7.mp3",
            genre = "Contemporary Hip-Hop",
            host = "Mister Cee & DJ Green Lantern",
            fileAliases = listOf("the_beat", "THEBEAT", "The Beat 102.7"),
            tracklist = listOf(
                Track("Nas", "War Is Necessary"),
                Track("Kanye West", "Flashing Lights"),
                Track(" Fat Joe feat. Lil Wayne", "Crackhouse"),
                Track("Mobb Deep", "Dirty New Yorker"),
                Track("Ghostface Killah feat. Kid Capri", "We Celebrate"),
                Track("Styles P", "What's the Problem"),
                Track("Busta Rhymes", "Where's My Money"),
                Track("Maino", "Getaway Driver")
            )
        ),
        Station(
            id = "the_vibe",
            name = "The Vibe 98.8",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/The%20Vibe%2098.8.mp3",
            genre = "Soul / R&B",
            host = "Vaughn Harper",
            fileAliases = listOf("the_vibe", "THEVIBE", "The Vibe 98.8"),
            tracklist = listOf(
                Track("Ne-Yo", "Because of You"),
                Track("R. Kelly", "Bump N' Grind"),
                Track("Mtume", "C.O.D. (I'll Deliver)"),
                Track("Alexander O'Neal", "Criticize"),
                Track("RAMP", "Daylight"),
                Track("The Isley Brothers", "Footsteps in the Dark"),
                Track("Jodeci", "Freek'n You"),
                Track("Lloyd", "Get It Shawty"),
                Track("Ginuwine", "Pony"),
                Track("Barry White", "It's Only Love Doing Its Thing")
            )
        ),
        Station(
            id = "jazz_nation",
            name = "Jazz Nation Radio 108.5",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Jazz%20Nation%20Radio%20108.5.mp3",
            genre = "Jazz / Bebop",
            host = "Roy Haynes",
            fileAliases = listOf("jazz_nation", "JNR", "Jazz Nation Radio", "Jazz Nation Radio 108.5"),
            tracklist = listOf(
                Track("Count Basie", "April in Paris"),
                Track("John Coltrane", "Giant Steps"),
                Track("Chet Baker", "Let's Get Lost"),
                Track("Art Blakey and the Jazz Messengers", "Moanin'"),
                Track("Miles Davis", "Move"),
                Track("Charlie Parker", "Night and Day"),
                Track("Roy Haynes", "Snap Crackle"),
                Track("Sonny Rollins", "St. Thomas"),
                Track("Duke Ellington", "Take the 'A' Train"),
                Track("Dizzy Gillespie", "Whisper Not")
            )
        ),
        Station(
            id = "the_journey",
            name = "The Journey",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/The%20Journey.mp3",
            genre = "Ambient / Chillout / Minimal",
            host = "Computer Voice",
            fileAliases = listOf("the_journey", "JOURNEY", "The Journey", "fusion_fm"),
            tracklist = listOf(
                Track("Global Communication", "5:23"),
                Track("Terry Riley", "A Rainbow in Curved Air"),
                Track("Steve Roach", "Arrival"),
                Track("Michael Shrieve", "Communiqué: 'Approach Spiral'"),
                Track("Jean Michel Jarre", "Oxygène (Part IV)"),
                Track("Philip Glass", "Pruit Igoe"),
                Track("Tangerine Dream", "Remote Viewing"),
                Track("Aphex Twin", "Selected Ambient Works Vol. II CD2 TRK5")
            )
        ),
        Station(
            id = "radio_broker",
            name = "Radio Broker",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Radio%20Broker.mp3",
            genre = "Indie Rock / Alternative",
            host = "Juliette Lewis",
            fileAliases = listOf("radio_broker", "BROKER", "Radio Broker"),
            tracklist = listOf(
                Track("The Boggs", "Arm in Arm (Shy Child Mix)"),
                Track("LCD Soundsystem", "Get Innocuous!"),
                Track("Juliette and the Licks", "Inside the Cage (David Gilmour Girls Remix)"),
                Track("Unkle feat. Ian Brown", "Mayday"),
                Track("Les Savy Fav", "Raging in the Plague Age"),
                Track("White Light Parade", "Riot in the City"),
                Track("The Prairie Cartel", "Homicide"),
                Track("Yeah Yeah Yeahs", "Kiss Kiss")
            )
        ),
        Station(
            id = "the_classics",
            name = "The Classics 104.1",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/The%20Classics%20104.1.mp3",
            genre = "Golden Age Hip-Hop",
            host = "DJ Premier",
            fileAliases = listOf("the_classics", "CLASSICS", "The Classics 104.1"),
            tracklist = listOf(
                Track("Group Home", "Supa Star"),
                Track("Brand Nubian", "All for One"),
                Track("Special Ed", "I Got It Made"),
                Track("Jeru the Damaja", "D. Original"),
                Track("Audio Two", "Top Billin'"),
                Track("Gang Starr", "Who's Gonna Take the Weight?"),
                Track("MC Lyte", "Cha Cha Cha")
            )
        ),
        Station(
            id = "k109_studio",
            name = "K109 The Studio",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/K109%20The%20Studio.mp3",
            genre = "Disco / Space Disco",
            host = "Karl Lagerfeld",
            fileAliases = listOf("k109", "K109", "K109 The Studio"),
            tracklist = listOf(
                Track("Cerrone", "Supernature"),
                Track("Don Ray", "Standing in the Rain"),
                Track("Gino Soccio", "Dancer"),
                Track("Giorgio Moroder", "The Chase"),
                Track("Change", "A Lover's Holiday"),
                Track("Tamiko Jones", "Can't Live Without Your Love")
            )
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
            host = "Lazlow & Various Hosts",
            fileAliases = listOf("plr", "PLR", "Public Liberty Radio")
        ),
        Station(
            id = "integrity_20",
            name = "Integrity 2.0",
            game = Game.GTA_IV,
            audioUrl = "https://archive.org/download/gta-iv-radio/Integrity%202.0.mp3",
            genre = "Talk Radio",
            host = "Lazlow",
            fileAliases = listOf("integrity_20", "INTEGRITY", "Integrity 2.0")
        )
    )
}

