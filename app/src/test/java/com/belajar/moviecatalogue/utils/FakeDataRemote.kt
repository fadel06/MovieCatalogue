package com.belajar.moviecatalogue.utils

import com.belajar.moviecatalogue.data.source.local.entity.*

object FakeDataRemote {
    fun generateRemoteDummyMovies(): List<MovieEntity> {
        val movies: ArrayList<MovieEntity> = arrayListOf()
        movies.add(
            MovieEntity(
                1,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "movie_a_start_is_born",
                "October 3, 2018",
                "75",
                "https://youtu.be/nSbzyEJ8X9E",
                listOf(
                    CrewEntity(
                        "Bradley Cooper",
                        "Director, Screenplay",
                        "a_start_is_born_bradley_cooper"
                    ),
                    CrewEntity(
                        "Will Fetters",
                        "Screenplay",
                        "ic_person"
                    ),
                    CrewEntity(
                        "Eric Roth",
                        "Screenplay",
                        "a_start_is_born_eric_roth"
                    ),
                    CrewEntity(
                        "Robert Carson",
                        "Story",
                        "ic_person"
                    ),
                    CrewEntity(
                        "William A. Wellman",
                        "Story",
                        "a_start_is_born_will_a_wellman"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "movie_alita",
                "January 31, 2019",
                "72",
                "https://youtu.be/U3D2vmWD88w",
                listOf(
                    CrewEntity(
                        "Robert Rodriguez",
                        "Director",
                        "battle_angel_robert_rodriguez"

                    ), CrewEntity(
                        "Laeta Kalogridis",
                        "Screenplay",
                        "battle_angel_laeta_kalogridis"
                    ),
                    CrewEntity(
                        "James Cameron",
                        "Screenplay",
                        "battle_angel_james_cameron"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                3,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "movie_aquaman",
                "December 7, 2018",
                "69",
                "https://youtu.be/WDkg3h8PCVU",
                listOf(
                    CrewEntity(
                        "James Wan",
                        "Director,Story",
                        "aquaman_james_wan"
                    ),
                    CrewEntity(
                        "Will Beall",
                        "Screenplay, Story",
                        "ic_person"
                    ),
                    CrewEntity(
                        "Paul Norris",
                        "Characters",
                        "ic_person"
                    ),
                    CrewEntity(
                        "Mort Weisinger",
                        "Characters",
                        "aquaman_mort_weisinger"
                    ),
                    CrewEntity(
                        "David Leslie Johnson-McGoldrick",
                        "Screenplay",
                        "aquaman_david_leslie"
                    ),
                    CrewEntity(
                        "Geoff Johns",
                        "Story",
                        "aquaman_geoff_johns"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                4,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "movie_bohemian",
                "October 24, 2018",
                "80",
                "https://youtu.be/27zlBpzdOZg",
                listOf(
                    CrewEntity(
                        "Anthony McCarten",
                        "Screenplay, Story",
                        "bohemian_rhapsody_anthony"
                    ),
                    CrewEntity(
                        "Bryan Singer",
                        "Director",
                        "bohemian_rhapsody_bryan"
                    ),
                    CrewEntity(
                        "Dexter Fletcher",
                        "Director",
                        "bohemian_rhapsody_dexter"
                    ),
                    CrewEntity(
                        "Peter Morgan",
                        "Story",
                        "ic_person"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                5,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "movie_cold_persuit",
                "February 7, 2019",
                "57",
                "https://youtu.be/0phuNQQ_gHI",
                listOf(
                    CrewEntity(
                        "Hans Petter Moland",
                        "Director",
                        "cold_pursuit_hans_petter"

                    ),
                    CrewEntity(
                        "Frank Baldwin",
                        "Screenplay",
                        "ic_person"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                6,
                "Creed",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "movie_creed",
                "November 25, 2015",
                "74",
                "https://youtu.be/JQ9OhBYjTds",
                listOf(
                    CrewEntity(
                        "Ryan Coogler",
                        "Director, Screenplay, Story",
                        "creed_ryan"
                    ),
                    CrewEntity(
                        "Sylvester Stallone",
                        "Characters",
                        "creed_sylvester"
                    ),
                    CrewEntity(
                        "Aaron Covington",
                        "Screenplay",
                        "ic_person"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                7,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "movie_crimes",
                "November 14, 2018",
                "69",
                "https://youtu.be/vvFybpmyB9E",
                listOf(
                    CrewEntity(
                        "David Yates",
                        "Director",
                        "fantastic_beasts_david"
                    ),
                    CrewEntity(
                        "J.K. Rowling",
                        "Screenplay",
                        "fantastic_beasts_j_k_rowling"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                8,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "movie_glass",
                "January 16, 2019",
                "67",
                "https://youtu.be/Q7ztHi9ejp4",
                listOf(
                    CrewEntity(
                        "M. Night Shyamalan",
                        "Director, Screenplay",
                        "glass_shyamalan"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                9,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "movie_how_to_train",
                "January 3, 2019",
                "78",
                "https://youtu.be/qNGLuCijKZ0",
                listOf(
                    CrewEntity(
                        "Dean DeBlois",
                        "Director, Screenplay, Story",
                        "htyd_dean"
                    ),
                    CrewEntity(
                        "Cressida Cowell",
                        "Novel",
                        "htyd_cressida"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                10,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "movie_infinity_war",
                "April 25, 2018",
                "83",
                "https://youtu.be/6ZfuNTqbHE8",
                listOf(
                    CrewEntity(
                        "Joe Russo",
                        "Director",
                        "avengers_joe"
                    ),
                    CrewEntity(
                        "Anthony Russo",
                        "Director",
                        "avengers_anthony"
                    ),
                    CrewEntity(
                        "Stephen McFeely",
                        "Screenplay",
                        "avengers_stephen"
                    ),
                    CrewEntity(
                        "Christopher Markus",
                        "Screenplay",
                        "avengers_christopher"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                11,
                "Mary Queen of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "movie_marry_queen",
                "December 7, 2018",
                "66",
                "https://youtu.be/wnqjSgMU36U",
                listOf(
                    CrewEntity(
                        "Josie Rourke",
                        "Director",
                        "mqos_josie"

                    ),
                    CrewEntity(
                        "Beau Willimon",
                        "Screenplay",
                        "ic_person"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                12,
                "Master Z: Ip Man Legacy",
                "After being defeated by Ip Man, Cheung Tin Chi is attempting to keep a low profile. While going about his business, he gets into a fight with a foreigner by the name of Davidson, who is a big boss behind the bar district. Tin Chi fights hard with Wing Chun and earns respect.",
                "movie_master_z",
                "December 20, 2018",
                "60",
                "https://youtu.be/KZau4zsOtyM",
                listOf(
                    CrewEntity(
                        "Yuen Woo-ping",
                        "Director",
                        "ip_man_yuen"
                    ),
                    CrewEntity(
                        "Chan Tai-Li",
                        "Screenplay",
                        "ic_person"
                    ),
                    CrewEntity(
                        "Edmond Wong",
                        "Screenplay",
                        "ic_person"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                13,
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "movie_mortal_engines",
                "November 27, 2018",
                "60",
                "https://youtu.be/IRsFc2gguEg",
                listOf(
                    CrewEntity(
                        "Christian Rivers",
                        "Director",
                        "mortal_christian"
                    ),
                    CrewEntity(
                        "Philip Reeve",
                        "Novel",
                        "ic_person"
                    ),
                    CrewEntity(
                        "Philippa Boyens",
                        "Screenplay",
                        "ic_person"
                    ),
                    CrewEntity(
                        "Fran Walsh",
                        "Screenplay",
                        "mortal_fran_walsh"
                    ),
                    CrewEntity(
                        "Peter Jackson",
                        "Screenplay",
                        "mortal_peter"
                    )
                )
            )
        )


        movies.add(
            MovieEntity(
                14,
                "Overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "movie_overlord",
                "November 1, 2018",
                "67",
                "https://youtu.be/USPd0vX2sdc",
                listOf(
                    CrewEntity(
                        "Billy Ray",
                        "Screenplay, Story",
                        "overlord_bill"
                    ),
                    CrewEntity(
                        "Julius Avery",
                        "Director",
                        "overlord_julius"
                    ),
                    CrewEntity(
                        "Mark L. Smith",
                        "Screenplay",
                        "overlord_mark"
                    )

                )
            )
        )

        movies.add(
            MovieEntity(
                15,
                "Ralph Breaks the Internet",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over their heads, Ralph and Vanellope rely on the citizens of the internet -- the netizens -- to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.\n",
                "movie_ralph",
                "November 20, 2018",
                "72",
                "https://youtu.be/T73h5bmD8Dc",
                listOf(
                    CrewEntity(
                        "Phil Johnston",
                        "Director, Story, Writer",
                        "ralph_phil"
                    ),
                    CrewEntity(
                        "Rich Moore",
                        "Director, Story",
                        "ralph_rich"
                    ),
                    CrewEntity(
                        "Pamela Ribon",
                        "Story, Writer",
                        "ralph_pamela"
                    ),
                    CrewEntity(
                        "Josie Trinidad",
                        "Story",
                        "ralph_josie"
                    ),
                    CrewEntity(
                        "Jim Reardon",
                        "Story",
                        "ralph_jim"
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                16,
                "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "movie_robin_hood",
                "November 21, 2018",
                "59",
                "https://youtu.be/ne7eStct3Fc",
                listOf(
                    CrewEntity(
                        "Ben Chandler",
                        "Screenplay, Story",
                        "ic_person"
                    ),
                    CrewEntity(
                        "Otto Bathurst",
                        "Director",
                        "robin_hood_otto"
                    ),
                    CrewEntity(
                        "David James Kelly",
                        "Screenplay",
                        "ic_person"
                    )
                )
            )
        )
        return movies
    }

    fun generateRemoteDummyTvShows(): List<TvShowEntity> {
        val tvShows: ArrayList<TvShowEntity> = arrayListOf()
        tvShows.add(
            TvShowEntity(
                1,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "tvshow_arrow",
                "October 10, 2012",
                "66",
                "https://youtu.be/hTv13EjlLNg",
                listOf(
                    CrewEntity(
                        "Greg Berlanti",
                        "Creator",
                        "arrow_greg"
                    ),
                    CrewEntity(
                        "Marc Guggenheim",
                        "Creator",
                        "arrow_marc"
                    ),
                    CrewEntity(
                        "Andrew Kreisberg",
                        "Creator",
                        "arrow_andrew"
                    )
                )
            )
        )


        tvShows.add(
            TvShowEntity(
                2,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "tvshow_doom_patrol",
                "February 15, 2019",
                "76",
                "https://youtu.be/6wtGnnLfTqA",
                listOf(
                    CrewEntity(
                        "Jeremy Carver",
                        "Creator",
                        "doom_jeremy"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                3,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure that would change Goku's life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin, Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball GT.\n",
                "tvshow_dragon_ball",
                "February 26, 1986",
                "81",
                "https://youtu.be/y_0APzy4BcU",
                listOf(
                    CrewEntity(
                        "Akira Toriyama",
                        "Creator",
                        "dragon_akira"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                4,
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "tvshow_fairytail",
                "October 12, 2009",
                "78",
                "https://youtu.be/29jsKEZN1ag",
                listOf(
                    CrewEntity(
                        "Shinji",
                        "Director",
                        "ic_person"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                5,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "tvshow_family_guy",
                "January 31, 1999",
                "70",
                "https://youtu.be/t3VtKdoPIYE",
                listOf(
                    CrewEntity(
                        "Seth MacFarlane",
                        "Creator",
                        "family_guy_seth"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                6,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "tvshow_flash",
                "October 7, 2014",
                "77",
                "https://youtu.be/Yj0l7iGKh8g",
                listOf(
                    CrewEntity(
                        "Geoff Johns",
                        "Creator",
                        "flash_geoff"
                    ),
                    CrewEntity(
                        "Andrew Kreisberg",
                        "Creator",
                        "flash_andrew"
                    ),
                    CrewEntity(
                        "Greg Berlanti",
                        "Creator",
                        "flash_greg"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                7,
                "Game of Thrones",
                "leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "tvshow_god",
                "April 17, 2011",
                "84",
                "https://youtu.be/BpJYNVhGf1s",
                listOf(
                    CrewEntity(
                        "David Benioff",
                        "Creator",
                        "got_david"
                    ),
                    CrewEntity(
                        "D. B. Weiss",
                        "Creator",
                        "got_weiss"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                8,
                "Gotham",
                "Before there was Batman, there was GOTHAM.\n" +
                        "\n" +
                        "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "tvshow_gotham",
                "September 22, 2014",
                "75",
                "https://youtu.be/0d1zpt6k5OI",
                listOf(
                    CrewEntity(
                        "Bruno Heller",
                        "Creator",
                        "gotham_bruno"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                9,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "tvshow_grey_anatomy",
                "March 27, 2005",
                "82",
                "https://youtu.be/q1pcpgREQ5c",
                listOf(
                    CrewEntity(
                        "Shonda Rhimes",
                        "Creator",
                        "greys_shonda"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                10,
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "tvshow_hanna",
                "March 28, 2019",
                "75",
                "https://youtu.be/wp6myRLnhAs",
                listOf(
                    CrewEntity(
                        "David Farr",
                        "Creator",
                        "hanna_david"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                11,
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "tvshow_iron_fist",
                "March 17, 2017",
                "66",
                "https://youtu.be/QCSPda7xQ3s",
                listOf(
                    CrewEntity(
                        "Scott Buck",
                        "Creator",
                        "ic_person"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                12,
                "Naruto Shippūden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "tvshow_naruto_shipudden",
                "February 15, 2007",
                "86",
                "https://youtu.be/1WLO0Owi5-A",
                listOf(
                    CrewEntity(
                        "Katsuhiko Chiba",
                        "Writer",
                        "naruto_katsuhiko"

                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                13,
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "tvshow_ncis",
                "September 23, 2003",
                "74",
                "https://youtu.be/VzSsxINwIVE",
                listOf(
                    CrewEntity(
                        "Don McGill",
                        "Creator",
                        "ic_person"
                    ),
                    CrewEntity(
                        "Donald P. Bellisario",
                        "Creator",
                        "ic_person"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                14,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "tvshow_riverdale",
                "January 26, 2017",
                "86",
                "https://youtu.be/9XmFTADupMc",
                listOf(
                    CrewEntity(
                        "Roberto Aguirre-Sacasa",
                        "Creator",
                        "riverdale_roberto"
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                15,
                "Shameless",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "tvshow_shameless",
                "January 9, 2011",
                "80",
                "https://youtu.be/CHstRRD_8LE",
                listOf(
                    CrewEntity(
                        "Paul Abbott",
                        "Creator",
                        "ic_person"

                    ),
                    CrewEntity(
                        "John Wells",
                        "Creator",
                        "shameless_john"
                    )
                )
            )
        )
        return tvShows
    }

    fun movieDetail(id: Int): MovieEntity {
        return generateRemoteDummyMovies()[id - 1]
    }

    fun tvShowDetail(id: Int): TvShowEntity {
        return generateRemoteDummyTvShows()[id - 1]
    }
}