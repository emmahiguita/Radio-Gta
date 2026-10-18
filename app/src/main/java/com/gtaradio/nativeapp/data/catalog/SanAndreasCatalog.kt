package com.gtaradio.nativeapp.data.catalog

import com.gtaradio.nativeapp.domain.model.Game
import com.gtaradio.nativeapp.domain.model.Station
import com.gtaradio.nativeapp.domain.model.Track

/**
 * Catálogo de San Andreas con tracklists reales extraídas de GTA Wiki.
 * Fuente: gta.fandom.com — todas las pistas y emisiones son del juego original (1992).
 */
object SanAndreasCatalog {
    val stations = listOf(
        Station(
            id = "kdst",
            name = "K-DST",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gtasars/K-DST.mp3",
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
            audioUrl = "https://archive.org/download/gtasars/Bounce%20FM.mp3",
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
            audioUrl = "https://archive.org/download/gtasars/Radio%20Los%20Santos.mp3",
            genre = "West Coast Hip-Hop / Gangsta Rap", host = "Julio G",
            fileAliases = listOf("radio_los_santos", "RLS", "Radio Los Santos"),
            tracklist = listOf(
                Track("2Pac", "I Don't Give a Fuck"),
                Track("Compton's Most Wanted", "Hood Took Me Under"),
                Track("Dr. Dre feat. Snoop Dogg", "Nuthin' but a G Thang"),
                Track("Ice Cube", "It Was a Good Day"),
                Track("NWA", "Appetite for Destruction"),
                Track("Cypress Hill", "How I Could Just Kill a Man"),
                Track("Mack 10", "Foe Life"),
                Track("WC", "The Streets"),
                Track("Snoop Doggy Dogg", "Murder Was the Case"),
                Track("Ice T", "O.G. Original Gangster"),
                Track("DJ Quik", "Jus Lyke Compton"),
                Track("Above the Law", "Murder Rap")
            )
        ),
        Station(
            id = "sf_ur",
            name = "SF-UR",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gtasars/SF-UR.mp3",
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
            audioUrl = "https://archive.org/download/gtasars/Radio%20X.mp3",
            genre = "Alternative Rock / Grunge", host = "Sage",
            fileAliases = listOf("radio_x", "RADIOX", "Radio X"),
            tracklist = listOf(
                Track("Rage Against the Machine", "Killing in the Name"),
                Track("Soundgarden", "Rusty Cage"),
                Track("Alice in Chains", "Them Bones"),
                Track("Stone Temple Pilots", "Plush"),
                Track("Helmet", "Unsung"),
                Track("White Zombie", "Thunderkiss '65"),
                Track("Danzig", "Mother"),
                Track("Ozzy Osbourne", "Hellraiser"),
                Track("L7", "Pretend We're Dead"),
                Track("Faith No More", "Midlife Crisis")
            )
        ),
        Station(
            id = "k_rose",
            name = "K-Rose",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gtasars/K-Rose.mp3",
            genre = "Classic Country", host = "Mary-Beth Maybell",
            fileAliases = listOf("k_rose", "KROSE", "K-Rose"),
            tracklist = listOf(
                Track("Jerry Reed", "Amos Moses"),
                Track("Conway Twitty & Loretta Lynn", "Louisiana Woman, Mississippi Man"),
                Track("Hank Williams", "Hey Good Lookin'"),
                Track("Juice Newton", "Queen of Hearts"),
                Track("Statler Brothers", "New York City"),
                Track("Asleep at the Wheel", "The Letter That Johnny Walker Read"),
                Track("The Desert Rose Band", "One Step Forward"),
                Track("Willie Nelson", "Crazy"),
                Track("Patsy Cline", "Three Cigarettes in an Ashtray"),
                Track("Statler Brothers", "Bed of Rose's"),
                Track("Mickey Gilley", "Make the World Go Away"),
                Track("Ed Bruce", "Mammas Don't Let Your Babies Grow Up to Be Cowboys"),
                Track("Merle Haggard", "Always Wanting You"),
                Track("Whitey Shafer", "All My Ex's Live in Texas"),
                Track("Eddie Rabbitt", "I Love a Rainy Night")
            )
        ),
        Station(
            id = "playback_fm",
            name = "Playback FM",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gtasars/Playback%20FM.mp3",
            genre = "Classic Hip-Hop / Golden Age", host = "Forth Right MC",
            fileAliases = listOf("playback_fm", "PLAYBACK", "Playback FM"),
            tracklist = listOf(
                Track("Kool G Rap & DJ Polo", "Road to the Riches"),
                Track("Big Daddy Kane", "Warm It Up, Kane"),
                Track("Spoonie Gee", "The Godfather"),
                Track("Masta Ace", "Me & the Biz"),
                Track("Slick Rick", "Children's Story"),
                Track("Public Enemy", "Rebel Without a Pause"),
                Track("Eric B. & Rakim", "I Know You Got Soul"),
                Track("Rob Base & DJ E-Z Rock", "It Takes Two"),
                Track("Gang Starr", "B.Y.S."),
                Track("Biz Markie", "The Vapors"),
                Track("Brand Nubian", "Brand Nubian"),
                Track("Ultramagnetic MCs", "Critical Beatdown")
            )
        ),
        Station(
            id = "csr_1039",
            name = "CSR 103.9",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gtasars/CSR%20103.9.mp3",
            genre = "New Jack Swing / 90s R&B", host = "Phillip 'PM' Michaels",
            fileAliases = listOf("csr_1039", "CSR", "CSR 103.9"),
            tracklist = listOf(
                Track("SWV", "I'm So Into You"),
                Track("Soul II Soul", "Keep On Movin'"),
                Track("Samuelle", "So You Like What You See"),
                Track("En Vogue", "My Lovin' (You're Never Gonna Get It)"),
                Track("Johnny Gill", "Rub You the Right Way"),
                Track("Ralph Tresvant", "Sensitivity"),
                Track("Guy", "Groove Me"),
                Track("Aaron Hall", "Don't Be Afraid"),
                Track("Boyz II Men", "Motownphilly"),
                Track("Bell Biv DeVoe", "Poison"),
                Track("Today", "I Got the Feeling"),
                Track("Wreckx-n-Effect", "New Jack Swing"),
                Track("Bobby Brown", "On Our Own")
            )
        ),
        Station(
            id = "mastersounds",
            name = "Master Sounds 98.3",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gtasars/Master%20Sounds%2098.3.mp3",
            genre = "Rare Groove / Classic Soul", host = "Johnny 'The Love Giant' Parkinson",
            fileAliases = listOf("mastersounds", "MASTERS", "Master Sounds 98.3"),
            tracklist = listOf(
                Track("Charles Wright & the Watts 103rd Street Rhythm Band", "Express Yourself"),
                Track("Maceo & The Macks", "Cross the Tracks (We Better Go Back)"),
                Track("Harlem Underground Band", "Smokin' Cheeba-Cheeba"),
                Track("The Chakachas", "Jungle Fever"),
                Track("Bob James", "Nautilus"),
                Track("Booker T. & the M.G.'s", "Green Onions"),
                Track("The Blackbyrds", "Rock Creek Park"),
                Track("Bobby Byrd", "Hot Pants - I'm Coming, I'm Coming, I'm Coming"),
                Track("James Brown", "Funky President (People It's Bad)"),
                Track("Lyn Collins", "Think (About It)"),
                Track("Maceo & The Macks", "Soul Power '74"),
                Track("James Brown", "The Payback"),
                Track("The JB's", "The Grunt"),
                Track("War", "Low Rider"),
                Track("Gloria Jones", "Tainted Love"),
                Track("Sir Joe Quarterman & Free Soul", "(I Got) So Much Trouble in My Mind")
            )
        ),
        Station(
            id = "kjah_west",
            name = "K-JAH West",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gtasars/K-JAH%20West.mp3",
            genre = "Dub / Roots Reggae", host = "Marshall Peters & Johnny Lawton",
            fileAliases = listOf("kjah_west", "KJAHWEST", "K-JAH West"),
            tracklist = listOf(
                Track("Black Harmony", "Don't Let It Go to Your Head"),
                Track("Blood Sisters", "Ring My Bell"),
                Track("Shabba Ranks", "Wicked Inna Bed"),
                Track("Buju Banton", "Batty Rider"),
                Track("Augustus Pablo", "King Tubby Meets the Rockers Uptown"),
                Track("Dennis Brown", "Revolution"),
                Track("Willi Williams", "Armagideon Time"),
                Track("I-Roy", "Sidewalk Killer"),
                Track("Toots & The Maytals", "Funky Kingston"),
                Track("Dillinger", "Cocaine in My Brain"),
                Track("The Maytals", "Pressure Drop"),
                Track("Pliers", "Bam Bam"),
                Track("Barrington Levy", "Here I Come"),
                Track("Reggie Stepper", "Drum Pan Sound"),
                Track("Black Uhuru", "Great Train Robbery"),
                Track("Max Romeo & The Upsetters", "Chase the Devil")
            )
        ),
        Station(
            id = "wctr_sa",
            name = "WCTR",
            game = Game.SAN_ANDREAS,
            audioUrl = "https://archive.org/download/gtasars/West%20Coast%20Talk%20Radio.mp3",
            genre = "West Coast Talk Radio", host = "Lazlow, Maurice, Derrick & Hosts",
            fileAliases = listOf("wctr_sa", "WCTR", "WCTR Radio", "West Coast Talk Radio"),
            tracklist = emptyList()
        )
    )
}

