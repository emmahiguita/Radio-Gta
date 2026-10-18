package com.gtaradio.nativeapp.data.catalog

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.model.Track

/**
 * Catálogo Oficial de Emisoras de Grand Theft Auto V (Los Santos & Blaine County, 2013).
 * Principio SOLID: Responsabilidad Única (SRP) - Provee los metadatos y fuentes reales de GTA V.
 */
object Gta5Catalog {
    val stations = listOf(
        Station(
            id = "los_santos_rock",
            name = "Los Santos Rock Radio",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/los_santos_rock_radio.mp3",
            genre = "Classic Rock / Pop Rock",
            host = "Kenny Loggins",
            fileAliases = listOf("los_santos_rock", "LSRR", "Los Santos Rock Radio"),
            tracklist = listOf(
                Track("Kenny Loggins", "I'm Free (Heaven Helps the Man)"),
                Track("Queen", "Radio Ga Ga"),
                Track("Phil Collins", "I Don't Care Anymore"),
                Track("Boston", "Peace of Mind"),
                Track("Elton John", "Saturday Night's Alright for Fighting"),
                Track("Foreigner", "Dirty White Boy"),
                Track("Gerry Rafferty", "Baker Street"),
                Track("Def Leppard", "Photograph"),
                Track("Simple Minds", "All the Things She Said"),
                Track("Starship", "We Built This City"),
                Track("Yes", "Roundabout")
            )
        ),
        Station(
            id = "non_stop_pop",
            name = "Non-Stop-Pop FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/non-stop-pop_fm.mp3",
            genre = "Pop / Dance 80s-2010s",
            host = "Cara Delevingne",
            fileAliases = listOf("non_stop_pop", "NSP", "Non-Stop-Pop FM"),
            tracklist = listOf(
                Track("Modjo", "Lady (Hear Me Tonight)"),
                Track("Corona", "The Rhythm of the Night"),
                Track("Stardust", "Music Sounds Better With You"),
                Track("Rihanna", "Only Girl (In the World)"),
                Track("Lady Gaga", "Applause"),
                Track("Gorillaz", "Feel Good Inc."),
                Track("Backstreet Boys", "I Want It That Way"),
                Track("Britney Spears", "Gimme More"),
                Track("Pet Shop Boys", "West End Girls"),
                Track("Bronski Beat", "Smalltown Boy"),
                Track("Lorde", "Tennis Court")
            )
        ),
        Station(
            id = "radio_los_santos_v",
            name = "Radio Los Santos",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/radio_los_santos.mp3",
            genre = "Modern Hip-Hop / Trap",
            host = "Big Boy",
            fileAliases = listOf("radio_los_santos_v", "RLSV", "Radio Los Santos"),
            tracklist = listOf(
                Track("Kendrick Lamar", "A.D.H.D"),
                Track("Jay Rock feat. Kendrick Lamar", "Hood Gone Love It"),
                Track("The Game feat. 2 Chainz & Rick Ross", "Ali Bomaye"),
                Track("A\$AP Rocky", "R-Cali"),
                Track("YG", "I'm A Real 1"),
                Track("Future", "How It Was"),
                Track("Travis Scott feat. 2 Chainz & T.I.", "Upper Echelon"),
                Track("ScHoolboy Q feat. Kendrick Lamar", "Collard Greens")
            )
        ),
        Station(
            id = "west_coast_classics",
            name = "West Coast Classics",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/west_coast_classics.mp3",
            genre = "90s West Coast Rap",
            host = "DJ Pooh",
            fileAliases = listOf("west_coast_classics", "WCC", "West Coast Classics"),
            tracklist = listOf(
                Track("2Pac", "Ambitionz Az a Ridah"),
                Track("Dr. Dre feat. Snoop Dogg", "Still D.R.E."),
                Track("Dr. Dre feat. Snoop Dogg, Kurupt & Nate Dogg", "The Next Episode"),
                Track("Ice Cube", "You Know How We Do It"),
                Track("Snoop Dogg", "Gin and Juice"),
                Track("N.W.A", "Straight Outta Compton"),
                Track("Warren G", "This D.J."),
                Track("Bone Thugs-N-Harmony", "1st of tha Month"),
                Track("Luniz", "I Got 5 on It")
            )
        ),
        Station(
            id = "rebel_radio",
            name = "Rebel Radio",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/rebel_radio.mp3",
            genre = "Outlaw Country / Rockabilly",
            host = "Jesco White",
            fileAliases = listOf("rebel_radio", "REBEL", "Rebel Radio"),
            tracklist = listOf(
                Track("Johnny Cash", "The General Lee"),
                Track("Waylon Jennings", "Are You Sure Hank Done It This Way"),
                Track("Willie Nelson", "Whiskey River"),
                Track("Jerry Reed", "You Took All the Ramblin' Out of Me"),
                Track("C.W. McCall", "Convoy"),
                Track("Hank Thompson", "It Don't Hurt Anymore"),
                Track("The Highwaymen", "Highwayman")
            )
        ),
        Station(
            id = "channel_x",
            name = "Channel X",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/channel_x.mp3",
            genre = "Punk Rock / Hardcore",
            host = "Keith Morris",
            fileAliases = listOf("channel_x", "CHANNELX", "Channel X"),
            tracklist = listOf(
                Track("Black Flag", "My War"),
                Track("Suicidal Tendencies", "Subliminal"),
                Track("Circle Jerks", "Rock House"),
                Track("Off!", "What's Next"),
                Track("Adolescents", "Amoeba"),
                Track("Descendents", "Pervert"),
                Track("The Germs", "Lexicon Devil")
            )
        ),
        Station(
            id = "flylo_fm",
            name = "FlyLo FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/flylo_fm.mp3",
            genre = "Experimental / Electronic",
            host = "Flying Lotus",
            fileAliases = listOf("flylo_fm", "FLYLO", "FlyLo FM"),
            tracklist = listOf(
                Track("Flying Lotus feat. Niki Randa", "Getting There"),
                Track("Clams Casino", "Crystals"),
                Track("Tyler, The Creator", "Garbage"),
                Track("Captain Murphy", "Evil Grin"),
                Track("Aphex Twin", "Windowlicker"),
                Track("Hudson Mohawke", "100hm"),
                Track("Thundercat", "Oh Sheit It's X")
            )
        ),
        Station(
            id = "space_1032",
            name = "Space 103.2",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/space_1032.mp3",
            genre = "Funk / Post-Disco",
            host = "Bootsy Collins",
            fileAliases = listOf("space_1032", "SPACE", "Space 103.2"),
            tracklist = listOf(
                Track("Bootsy's Rubber Band", "I'd Rather Be With You"),
                Track("Evelyn 'Champagne' King", "I'm in Love"),
                Track("Rick James", "Give It to Me Baby"),
                Track("Eddie Murphy", "Party All the Time"),
                Track("Stevie Wonder", "Skeletons"),
                Track("Zapp", "Heartbreaker"),
                Track("Cameo", "Back and Forth")
            )
        ),
        Station(
            id = "the_lowdown",
            name = "The Lowdown 91.1",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/the_lowdown_911.mp3",
            genre = "Classic Soul / R&B",
            host = "Pam Grier",
            fileAliases = listOf("the_lowdown", "LOWDOWN", "The Lowdown 91.1"),
            tracklist = listOf(
                Track("War", "The Cisco Kid"),
                Track("Smokey Robinson", "Cruisin'"),
                Track("Aaron Neville", "Hercules"),
                Track("The Delfonics", "Ready or Not Here I Come"),
                Track("The Five Stairsteps", "O-o-h Child"),
                Track("Johnny 'Guitar' Watson", "Superman Lover")
            )
        ),
        Station(
            id = "soulwax_fm",
            name = "Soulwax FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/soulwax_fm.mp3",
            genre = "Techno / Electro House",
            host = "Soulwax",
            fileAliases = listOf("soulwax_fm", "SOULWAX", "Soulwax FM"),
            tracklist = listOf(
                Track("Palmbomen", "Stock (Soulwax Remix)"),
                Track("Fatal Error", "Fatal Error"),
                Track("Supersempfft", "Let's Beam Him Up"),
                Track("Pulp", "After You (Soulwax Remix)"),
                Track("Joe Goddard feat. Valentina", "Gabriel (Soulwax Remix)"),
                Track("Green Velvet & Harvard Bass", "Lazer Beams")
            )
        ),
        Station(
            id = "vinewood_boulevard",
            name = "Vinewood Boulevard Radio",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/vinewood_boulevard_radio.mp3",
            genre = "Alternative / Garage Rock",
            host = "Nate Williams & Stephen Pope",
            fileAliases = listOf("vinewood_boulevard", "VBR", "Vinewood Boulevard Radio"),
            tracklist = listOf(
                Track("Wavves", "Nine Is God"),
                Track("FIDLAR", "Cocaine"),
                Track("Bass Drum of Death", "Crawling After You"),
                Track("Ty Segall Band", "Diddy Wah Diddy"),
                Track("The Black Angels", "Black Grease"),
                Track("Thee Oh Sees", "The Dream")
            )
        ),
        Station(
            id = "blue_ark",
            name = "Blue Ark",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/blue_ark.mp3",
            genre = "Reggae / Dancehall / Dub",
            host = "Lee 'Scratch' Perry",
            fileAliases = listOf("blue_ark", "BLUEARK", "Blue Ark"),
            tracklist = listOf(
                Track("Chronixx", "Odd Ras"),
                Track("Dennis Brown", "Money in My Pocket"),
                Track("Gregory Isaacs", "Night Nurse"),
                Track("Half Pint", "Crazy Girl"),
                Track("Junior Delgado", "Sons of Slaves"),
                Track("Lee 'Scratch' Perry", "I Am a Madman"),
                Track("Vybz Kartel feat. Popcaan", "We Never Fear Dem")
            )
        ),
        Station(
            id = "worldwide_fm",
            name = "Worldwide FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/worldwide_fm.mp3",
            genre = "Jazz / Ambient / World",
            host = "Gilles Peterson",
            fileAliases = listOf("worldwide_fm", "WORLDWIDE", "Worldwide FM"),
            tracklist = listOf(
                Track("Cashmere Cat", "Mirror Maru"),
                Track("Django Django", "Waveforms"),
                Track("Donald Byrd", "You and the Music"),
                Track("Toro y Moi", "Harm in Change"),
                Track("Little Dragon", "Crystalfilm"),
                Track("Kamasi Washington", "The Magnificent 7")
            )
        ),
        Station(
            id = "radio_mirror_park",
            name = "Radio Mirror Park",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/radio_mirror_park.mp3",
            genre = "Indie Pop / Synthwave",
            host = "Twin Shadow",
            fileAliases = listOf("radio_mirror_park", "RMP", "Radio Mirror Park"),
            tracklist = listOf(
                Track("The Chain Gang of 1974", "Sleepwalking"),
                Track("Twin Shadow", "Shooting Holes"),
                Track("Twin Shadow", "Old Love / New Love"),
                Track("M83", "Midnight City"),
                Track("Jai Paul", "Jasmine (Demo)"),
                Track("Miami Horror", "Sometimes"),
                Track("Toro y Moi", "So Many Details"),
                Track("Favored Nations", "The Set Up")
            )
        ),
        Station(
            id = "east_los_fm",
            name = "East Los FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/east_los_fm.mp3",
            genre = "Mexican Electronic / Corrido",
            host = "Don Cheto & Camilo Lara",
            fileAliases = listOf("east_los_fm", "EASTLOS", "East Los FM"),
            tracklist = listOf(
                Track("Los Buitres de Culiacán", "El Cocaino"),
                Track("Mexican Institute of Sound", "Es-Toy"),
                Track("Los Ángeles Negros", "El Rey Y Yo"),
                Track("Hechizeros Band", "El Sonidito"),
                Track("Don Cheto", "El Tatuado"),
                Track("La Vida Bohème", "Radio Capital"),
                Track("Maldita Vecindad", "Pachuco")
            )
        ),
        Station(
            id = "the_lab",
            name = "The Lab",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/the_lab.mp3",
            genre = "Hip-Hop / Synth Funk",
            host = "The Alchemist & Oh No",
            fileAliases = listOf("the_lab", "THELAB", "The Lab"),
            tracklist = listOf(
                Track("Gangrene feat. Samuel T. Herring & Earl Sweatshirt", "Play It Cool"),
                Track("Ab-Soul feat. Aloe Blacc", "Trouble"),
                Track("Phantogram", "K.Y.S.A"),
                Track("Little Dragon", "Wanderer"),
                Track("Freddie Gibbs & Mike Dean", "Sellin' Dope"),
                Track("E-40 feat. Dam-Funk & Ariel Pink", "California")
            )
        ),
        Station(
            id = "blonded",
            name = "blonded Los Santos 97.8 FM",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/GTAVRadioStations/GTA%20V%20Radio%20Stations/Blonded%20Radio.mp3",
            genre = "Eclectic / Rap / Soul",
            host = "Frank Ocean, Vegyn, Roof Access & Fed",
            fileAliases = listOf("blonded", "BLONDED", "blonded Los Santos"),
            tracklist = listOf(
                Track("Frank Ocean", "Nights"),
                Track("Frank Ocean", "Chanel"),
                Track("Frank Ocean", "Provider"),
                Track("Frank Ocean", "Ivy"),
                Track("Future", "Codeine Crazy"),
                Track("Migos", "First 48"),
                Track("Marvin Gaye", "When Did You Stop Loving Me"),
                Track("Curtis Mayfield", "So in Love")
            )
        ),
        Station(
            id = "lsur",
            name = "Los Santos Underground Radio",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/GTAVRadioStations/GTA%20V%20Radio%20Stations/Los%20Santos%20Underground%20Radio.mp3",
            genre = "House / Techno / Club",
            host = "Solomun, Tale Of Us, Dixon & The Black Madonna",
            fileAliases = listOf("lsur", "LSUR", "Los Santos Underground Radio", "motomami"),
            tracklist = listOf(
                Track("Solomun", "Customer Is King"),
                Track("Amotik", "Vika"),
                Track("Tale Of Us", "Nova"),
                Track("Dixon", "Transmoderna Mix"),
                Track("The Black Madonna", "We Still Believe")
            )
        ),
        Station(
            id = "wctr_v",
            name = "West Coast Talk Radio",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/west_coast_talk_radio.mp3",
            genre = "Talk Radio (Chakra Attack / Fernando Show)",
            host = "Dr. Ray De Angelo Harris & Lazlow",
            fileAliases = listOf("wctr_v", "WCTRV", "West Coast Talk Radio")
        ),
        Station(
            id = "bcr",
            name = "Blaine County Radio",
            game = Game.GTA_V,
            audioUrl = "https://archive.org/download/gtaradio-audio-collection/blaine_county_radio.mp3",
            genre = "Rural Talk Radio (Bless Your Heart / Beyond Insemination)",
            host = "Ron Jakowski, Bobby June & Duane Earl",
            fileAliases = listOf("bcr", "BCR", "Blaine County Radio")
        )
    )
}

