package com.gtaradio.nativeapp.data.catalog

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.model.Track

/**
 * Catálogo de San Andreas con tracklists reales extraídas de GTA Wiki.
 * Fuente: gta.fandom.com — todas las pistas son del juego original (1992).
 */
object SanAndreasCatalog {
    val stations = listOf(
        Station(
            id = "kdst",
            name = "K-DST",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/radio-k-dst-gta-san-andreas-no-ads-all-tracks-mp-3-320-k/%F0%9F%8E%B6%20Radio%20K%20DST%20(GTA%20San%20Andreas)%20(NO%20ADS)%20(All%20Tracks)(MP3_320K).mp3",
            genre = "Classic Rock", host = "Tommy 'The Nightmare' Smith (Axl Rose)",
            fileAliases = listOf("kdst", "KDST", "K-DST"),
            tracklist = listOf(
                Track("Foghat", "Slow Ride"),
                Track("Creedence Clearwater Revival", "Green River"),
                Track("Heart", "Barracuda"),
                Track("Kiss", "Strutter"),
                Track("Toto", "Hold the Line"),
                Track("Rod Stewart", "Young Turks"),
                Track("Humble Pie", "Get Down to It"),
                Track("Grand Funk Railroad", "Some Kind of Wonderful"),
                Track("Lynyrd Skynyrd", "Free Bird"),
                Track("America", "A Horse with No Name"),
                Track("The Who", "Eminence Front"),
                Track("Boston", "Smokin'"),
                Track("David Bowie", "Somebody Up There Likes Me"),
                Track("Eddie Money", "Two Tickets to Paradise"),
                Track("Billy Idol", "White Wedding")
            )
        ),
        Station(
            id = "bounce_fm",
            name = "Bounce FM",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gta-sa-radio-full/Bounce%20FM.mp3",
            genre = "Funk / Disco", host = "The Funktipus (George Clinton)",
            fileAliases = listOf("bounce_fm", "BOUNCE", "Bounce FM"),
            tracklist = listOf(
                Track("Dazz Band", "Let It Whip"),
                Track("Kool & the Gang", "Hollywood Swinging"),
                Track("Cameo", "Candy"),
                Track("MFSB feat. The Three Degrees", "Love Is the Message"),
                Track("Johnny Harris", "Odyssey"),
                Track("Ohio Players", "Love Rollercoaster"),
                Track("The Isley Brothers", "Between the Sheets"),
                Track("Zapp", "I Can Make You Dance"),
                Track("Rick James", "Cold Blooded"),
                Track("Ronnie Hudson", "West Coast Poplock"),
                Track("George Clinton", "Loopzilla"),
                Track("Ohio Players", "Funky Worm"),
                Track("Maze", "Twilight"),
                Track("Lakeside", "Fantastic Voyage")
            )
        ),
        Station(
            id = "radio_los_santos",
            name = "Radio Los Santos",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/radio-los-santos-gta-san-andreas-no-ads-all-tracks/Radio%20Los%20Santos%20(GTA%20San%20Andreas)%20(NO%20ADS)%20(All%20Tracks).mp3",
            genre = "West Coast Hip-Hop / Gangsta Rap", host = "Julio G",
            fileAliases = listOf("radio_los_santos", "RLS", "Radio Los Santos"),
            tracklist = listOf(
                Track("2Pac", "I Don't Give a Fuck"),
                Track("Compton's Most Wanted", "Hood Took Me Under"),
                Track("Dr. Dre feat. Snoop Dogg", "Nuthin' but a G Thang"),
                Track("Ice Cube", "It Was a Good Day"),
                Track("NWA", "Appetite for Destruction"),
                Track("Rage Against the Machine", "Killing in the Name"),
                Track("Mack 10", "Foe Life"),
                Track("Cypress Hill", "How I Could Just Kill a Man"),
                Track("WC", "The Streets"),
                Track("Snoop Doggy Dogg", "Murder Was the Case"),
                Track("Ice T", "O.G. Original Gangster"),
                Track("DJ Quik", "Jus Lyke Compton")
            )
        ),
        Station(
            id = "sf_ur",
            name = "SF-UR",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gta-sa-radio-full/SF-UR.mp3",
            genre = "House / Acid House", host = "Hans Oberlander",
            fileAliases = listOf("sf_ur", "SFUR", "SF-UR"),
            tracklist = listOf(
                Track("Ralph Tresvant", "Sensitivity"),
                Track("Shanice", "I Love Your Smile"),
                Track("Larry Heard", "Can You Feel It"),
                Track("Joey Beltram", "Energy Flash"),
                Track("Kevin Saunderson", "Big Fun"),
                Track("Ten City", "Whatever Makes You Happy"),
                Track("Inner City", "Good Life"),
                Track("Marshall Jefferson", "Move Your Body")
            )
        ),
        Station(
            id = "radio_x",
            name = "Radio X",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gta-sa-radio-full/Radio%20X.mp3",
            genre = "Alternative Rock / Grunge", host = "Sage",
            fileAliases = listOf("radio_x", "RADIOX", "Radio X"),
            tracklist = listOf(
                Track("Rage Against the Machine", "Killing in the Name"),
                Track("Soundgarden", "Black Hole Sun"),
                Track("Alice in Chains", "Would?"),
                Track("Stone Temple Pilots", "Creep"),
                Track("Screaming Trees", "Nearly Lost You"),
                Track("White Zombie", "Thunderkiss '65"),
                Track("Slayer", "South of Heaven"),
                Track("Ozzy Osbourne", "War Pigs"),
                Track("Primus", "My Name Is Mud"),
                Track("Faith No More", "Midlife Crisis")
            )
        ),
        Station(
            id = "k_rose",
            name = "K-Rose",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gta-sa-radio-full/K-Rose.mp3",
            genre = "Classic Country", host = "Mary-Beth Maybell",
            fileAliases = listOf("k_rose", "KROSE", "K-Rose"),
            tracklist = listOf(
                Track("Merle Haggard", "The Fightin' Side of Me"),
                Track("Charley Pride", "Is Anybody Goin' to San Antone"),
                Track("Willie Nelson", "Whiskey River"),
                Track("Johnny Cash", "Get Rhythm"),
                Track("Tammy Wynette", "Stand by Your Man"),
                Track("Charlie Rich", "The Most Beautiful Girl"),
                Track("Lynn Anderson", "Rose Garden"),
                Track("Loretta Lynn", "Coal Miner's Daughter")
            )
        ),
        Station(
            id = "playback_fm",
            name = "Playback FM",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gta-sa-radio-full/Playback%20FM.mp3",
            genre = "Classic Hip-Hop / Golden Age", host = "Forth Right MC",
            fileAliases = listOf("playback_fm", "PLAYBACK", "Playback FM"),
            tracklist = listOf(
                Track("Public Enemy", "Rebel Without a Pause"),
                Track("Slick Rick", "Children's Story"),
                Track("Kool G Rap", "Streets of New York"),
                Track("MC Ren", "Final Frontier"),
                Track("Eric B. & Rakim", "Paid in Full"),
                Track("Grandmaster Flash", "White Lines"),
                Track("LL Cool J", "Mama Said Knock You Out"),
                Track("Digital Underground", "The Humpty Dance"),
                Track("EPMD", "So Whatcha Sayin'"),
                Track("Boogie Down Productions", "South Bronx")
            )
        ),
        Station(
            id = "csr_1039",
            name = "CSR 103.9",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gta-sa-radio-full/CSR%20103.9.mp3",
            genre = "New Jack Swing / 90s R&B", host = "Phillip 'PM' Michaels",
            fileAliases = listOf("csr_1039", "CSR", "CSR 103.9"),
            tracklist = listOf(
                Track("Al Green", "Love and Happiness"),
                Track("Anita Baker", "Sweet Love"),
                Track("Teddy Pendergrass", "Love TKO"),
                Track("Patti LaBelle", "If You Don't Know Me by Now"),
                Track("Smokey Robinson", "Cruisin'"),
                Track("Luther Vandross", "A House Is Not a Home"),
                Track("Roberta Flack", "Feel Like Makin' Love"),
                Track("Peabo Bryson", "Tonight I Celebrate My Love")
            )
        ),
        Station(
            id = "mastersounds",
            name = "Master Sounds 98.3",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gta-sa-radio-full/Master%20Sounds%2098.3.mp3",
            genre = "Rare Groove / Classic Soul", host = "Johnny 'The Love Giant' Parkinson",
            fileAliases = listOf("mastersounds", "MASTERS", "Master Sounds 98.3"),
            tracklist = listOf(
                Track("James Brown", "The Payback"),
                Track("Sly & the Family Stone", "Thank You"),
                Track("Parliament", "Flash Light"),
                Track("Earth Wind & Fire", "Let's Groove"),
                Track("Isaac Hayes", "Shaft"),
                Track("Marvin Gaye", "I Want You"),
                Track("Stevie Wonder", "Superstition"),
                Track("Funkadelic", "One Nation Under a Groove")
            )
        ),
        Station(
            id = "kjah_west",
            name = "K-JAH West",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gta-sa-radio-full/K-JAH%20West.mp3",
            genre = "Dub / Roots Reggae", host = "Marshall Peters",
            fileAliases = listOf("kjah_west", "KJAHWEST", "K-JAH West"),
            tracklist = listOf(
                Track("Toots and the Maytals", "Pressure Drop"),
                Track("Desmond Dekker", "Israelites"),
                Track("Jimmy Cliff", "The Harder They Come"),
                Track("Bob Marley", "Roots Rock Reggae"),
                Track("Burning Spear", "Jah No Dead"),
                Track("Culture", "Two Sevens Clash"),
                Track("Peter Tosh", "Legalize It")
            )
        ),
        Station(
            id = "wctr_sa",
            name = "WCTR",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gta-sa-radio-full/WCTR.mp3",
            genre = "West Coast Talk Radio", host = "Various Hosts",
            fileAliases = listOf("wctr_sa", "WCTR", "WCTR Radio"),
            tracklist = emptyList()
        )
    )
}
