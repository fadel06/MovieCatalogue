package com.belajar.moviecatalogue.utils

import com.belajar.moviecatalogue.R
import com.belajar.moviecatalogue.data.CrewEntity
import com.belajar.moviecatalogue.data.MovieEntity
import com.belajar.moviecatalogue.data.TvShowEntity

object Data {
    fun generateMovies(): List<MovieEntity> {
        val movies: ArrayList<MovieEntity> = arrayListOf()
        movies.add(
            MovieEntity(
                1,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                R.drawable.movie_a_start_is_born,
                "October 3, 2018",
                "75",
                "https://youtu.be/nSbzyEJ8X9E",

                listOf(
                    CrewEntity(
                        "Bradley Cooper",
                        "Director, Screenplay",
                        R.drawable.a_start_is_born_bradley_cooper
                    ),
                    CrewEntity(
                        "Will Fetters",
                        "Screenplay",
                        R.drawable.ic_person
                    ),
                    CrewEntity(
                        "Eric Roth",
                        "Screenplay",
                        R.drawable.a_start_is_born_eric_roth
                    ),
                    CrewEntity(
                        "Robert Carson",
                        "Story",
                        R.drawable.ic_person
                    ),
                    CrewEntity(
                        "William A. Wellman",
                        "Story",
                        R.drawable.a_start_is_born_will_a_wellman
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                R.drawable.movie_alita,
                "January 31, 2019",
                "72",
                "https://youtu.be/U3D2vmWD88w",
                listOf(
                    CrewEntity(
                        "Robert Rodriguez",
                        "Director",
                        R.drawable.battle_angel_robert_rodriguez

                    ), CrewEntity(
                        "Laeta Kalogridis",
                        "Screenplay",
                        R.drawable.battle_angel_laeta_kalogridis
                    ),
                    CrewEntity(
                        "James Cameron",
                        "Screenplay",
                        R.drawable.battle_angel_james_cameron
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                3,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                R.drawable.movie_aquaman,
                "December 7, 2018",
                "69",
                "https://youtu.be/WDkg3h8PCVU",
                listOf(
                    CrewEntity(
                        "James Wan",
                        "Director,Story",
                        R.drawable.aquaman_james_wan
                    ),
                    CrewEntity(
                        "Will Beall",
                        "Screenplay, Story",
                        R.drawable.ic_person
                    ),
                    CrewEntity(
                        "Paul Norris",
                        "Characters",
                        R.drawable.ic_person
                    ),
                    CrewEntity(
                        "Mort Weisinger",
                        "Characters",
                        R.drawable.aquaman_mort_weisinger
                    ),
                    CrewEntity(
                        "David Leslie Johnson-McGoldrick",
                        "Screenplay",
                        R.drawable.aquaman_david_leslie
                    ),
                    CrewEntity(
                        "Geoff Johns",
                        "Story",
                        R.drawable.aquaman_geoff_johns
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                4,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                R.drawable.movie_bohemian,
                "October 24, 2018",
                "80",
                "https://youtu.be/27zlBpzdOZg",
                listOf(
                    CrewEntity(
                        "Anthony McCarten",
                        "Screenplay, Story",
                        R.drawable.bohemian_rhapsody_anthony
                    ),
                    CrewEntity(
                        "Bryan Singer",
                        "Director",
                        R.drawable.bohemian_rhapsody_bryan
                    ),
                    CrewEntity(
                        "Dexter Fletcher",
                        "Director",
                        R.drawable.bohemian_rhapsody_dexter
                    ),
                    CrewEntity(
                        "Peter Morgan",
                        "Story",
                        R.drawable.ic_person
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                5,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                R.drawable.movie_cold_persuit,
                "February 7, 2019",
                "57",
                "https://youtu.be/0phuNQQ_gHI",
                listOf(
                    CrewEntity(
                        "Hans Petter Moland",
                        "Director",
                        R.drawable.cold_pursuit_hans_petter

                    ),
                    CrewEntity(
                        "Frank Baldwin",
                        "Screenplay",
                        R.drawable.ic_person
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                6,
                "Creed",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                R.drawable.movie_creed,
                "November 25, 2015",
                "74",
                "https://youtu.be/JQ9OhBYjTds",
                listOf(
                    CrewEntity(
                        "Ryan Coogler",
                        "Director, Screenplay, Story",
                        R.drawable.creed_ryan
                    ),
                    CrewEntity(
                        "Sylvester Stallone",
                        "Characters",
                        R.drawable.creed_sylvester
                    ),
                    CrewEntity(
                        "Aaron Covington",
                        "Screenplay",
                        R.drawable.ic_person
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                7,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                R.drawable.movie_crimes,
                "November 14, 2018",
                "69",
                "https://youtu.be/vvFybpmyB9E",
                listOf(
                    CrewEntity(
                        "David Yates",
                        "Director",
                        R.drawable.fantastic_beasts_david
                    ),
                    CrewEntity(
                        "J.K. Rowling",
                        "Screenplay",
                        R.drawable.fantastic_beasts_j_k_rowling
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                8,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                R.drawable.movie_glass,
                "January 16, 2019",
                "67",
                "https://youtu.be/Q7ztHi9ejp4",
                listOf(
                    CrewEntity(
                        "M. Night Shyamalan",
                        "Director, Screenplay",
                        R.drawable.glass_shyamalan
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                9,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                R.drawable.movie_how_to_train,
                "January 3, 2019",
                "78",
                "https://youtu.be/qNGLuCijKZ0",
                listOf(
                    CrewEntity(
                        "Dean DeBlois",
                        "Director, Screenplay, Story",
                        R.drawable.htyd_dean
                    ),
                    CrewEntity(
                        "Cressida Cowell",
                        "Novel",
                        R.drawable.htyd_cressida
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                10,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                R.drawable.movie_infinity_war,
                "April 25, 2018",
                "83",
                "https://youtu.be/6ZfuNTqbHE8",
                listOf(
                    CrewEntity(
                        "Joe Russo",
                        "Director",
                        R.drawable.avengers_joe
                    ),
                    CrewEntity(
                        "Anthony Russo",
                        "Director",
                        R.drawable.avengers_anthony
                    ),
                    CrewEntity(
                        "Stephen McFeely",
                        "Screenplay",
                        R.drawable.avengers_stephen
                    ),
                    CrewEntity(
                        "Christopher Markus",
                        "Screenplay",
                        R.drawable.avengers_christopher
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                11,
                "Mary Queen of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                R.drawable.movie_marry_queen,
                "December 7, 2018",
                "66",
                "https://youtu.be/wnqjSgMU36U",
                listOf(
                    CrewEntity(
                        "Josie Rourke",
                        "Director",
                        R.drawable.mqos_josie

                    ),
                    CrewEntity(
                        "Beau Willimon",
                        "Screenplay",
                        R.drawable.ic_person
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                12,
                "Master Z: Ip Man Legacy",
                "After being defeated by Ip Man, Cheung Tin Chi is attempting to keep a low profile. While going about his business, he gets into a fight with a foreigner by the name of Davidson, who is a big boss behind the bar district. Tin Chi fights hard with Wing Chun and earns respect.",
                R.drawable.movie_master_z,
                "December 20, 2018",
                "60",
                "https://youtu.be/KZau4zsOtyM",
                listOf(
                    CrewEntity(
                        "Yuen Woo-ping",
                        "Director",
                        R.drawable.ip_man_yuen
                    ),
                    CrewEntity(
                        "Chan Tai-Li",
                        "Screenplay",
                        R.drawable.ic_person
                    ),
                    CrewEntity(
                        "Edmond Wong",
                        "Screenplay",
                        R.drawable.ic_person
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                13,
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                R.drawable.movie_mortal_engines,
                "November 27, 2018",
                "60",
                "https://youtu.be/IRsFc2gguEg",
                listOf(
                    CrewEntity(
                        "Christian Rivers",
                        "Director",
                        R.drawable.mortal_christian
                    ),
                    CrewEntity(
                        "Philip Reeve",
                        "Novel",
                        R.drawable.ic_person
                    ),
                    CrewEntity(
                        "Philippa Boyens",
                        "Screenplay",
                        R.drawable.ic_person
                    ),
                    CrewEntity(
                        "Fran Walsh",
                        "Screenplay",
                        R.drawable.mortal_fran_walsh
                    ),
                    CrewEntity(
                        "Peter Jackson",
                        "Screenplay",
                        R.drawable.mortal_peter
                    )
                )
            )
        )


        movies.add(
            MovieEntity(
                14,
                "Overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                R.drawable.movie_overlord,
                "November 1, 2018",
                "67",
                "https://youtu.be/USPd0vX2sdc",
                listOf(
                    CrewEntity(
                        "Billy Ray",
                        "Screenplay, Story",
                        R.drawable.overlord_bill
                    ),
                    CrewEntity(
                        "Julius Avery",
                        "Director",
                        R.drawable.overlord_julius
                    ),
                    CrewEntity(
                        "Mark L. Smith",
                        "Screenplay",
                        R.drawable.overlord_mark
                    )

                )
            )
        )

        movies.add(
            MovieEntity(
                15,
                "Ralph Breaks the Internet",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over their heads, Ralph and Vanellope rely on the citizens of the internet -- the netizens -- to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.\n",
                R.drawable.movie_ralph,
                "November 20, 2018",
                "72",
                "https://youtu.be/T73h5bmD8Dc",
                listOf(
                    CrewEntity(
                        "Phil Johnston",
                        "Director, Story, Writer",
                        R.drawable.ralph_phil
                    ),
                    CrewEntity(
                        "Rich Moore",
                        "Director, Story",
                        R.drawable.ralph_rich
                    ),
                    CrewEntity(
                        "Pamela Ribon",
                        "Story, Writer",
                        R.drawable.ralph_pamela
                    ),
                    CrewEntity(
                        "Josie Trinidad",
                        "Story",
                        R.drawable.ralph_josie
                    ),
                    CrewEntity(
                        "Jim Reardon",
                        "Story",
                        R.drawable.ralph_jim
                    )
                )
            )
        )

        movies.add(
            MovieEntity(
                16,
                "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                R.drawable.movie_robin_hood,
                "November 21, 2018",
                "59",
                "https://youtu.be/ne7eStct3Fc",
                listOf(
                    CrewEntity(
                        "Ben Chandler",
                        "Screenplay, Story",
                        R.drawable.ic_person
                    ),
                    CrewEntity(
                        "Otto Bathurst",
                        "Director",
                        R.drawable.robin_hood_otto
                    ),
                    CrewEntity(
                        "David James Kelly",
                        "Screenplay",
                        R.drawable.ic_person
                    )
                )
            )
        )
        return movies
    }

    fun generateTvShows(): List<TvShowEntity> {
        val tvShows: ArrayList<TvShowEntity> = arrayListOf()
        tvShows.add(
            TvShowEntity(
                1,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                R.drawable.tvshow_arrow,
                "October 10, 2012",
                "66",
                "https://youtu.be/hTv13EjlLNg",
                listOf(
                    CrewEntity(
                        "Greg Berlanti",
                        "Creator",
                        R.drawable.arrow_greg
                    ),
                    CrewEntity(
                        "Marc Guggenheim",
                        "Creator",
                        R.drawable.arrow_marc
                    ),
                    CrewEntity(
                        "Andrew Kreisberg",
                        "Creator",
                        R.drawable.arrow_andrew
                    )
                )
            )
        )


        tvShows.add(
            TvShowEntity(
                2,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                R.drawable.tvshow_doom_patrol,
                "February 15, 2019",
                "76",
                "https://youtu.be/6wtGnnLfTqA",
                listOf(
                    CrewEntity(
                        "Jeremy Carver",
                        "Creator",
                        R.drawable.doom_jeremy
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                3,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure that would change Goku's life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin, Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball GT.\n",
                R.drawable.tvshow_dragon_ball,
                "February 26, 1986",
                "81",
                "https://youtu.be/y_0APzy4BcU",
                listOf(
                    CrewEntity(
                        "Akira Toriyama",
                        "Creator",
                        R.drawable.dragon_akira
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                4,
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                R.drawable.tvshow_fairytail,
                "October 12, 2009",
                "78",
                "https://youtu.be/29jsKEZN1ag",
                listOf(
                    CrewEntity(
                        "Shinji",
                        "Ishihira",
                        R.drawable.ic_person
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                5,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                R.drawable.tvshow_family_guy,
                "January 31, 1999",
                "70",
                "https://youtu.be/t3VtKdoPIYE",
                listOf(
                    CrewEntity(
                        "Seth MacFarlane",
                        "Creator",
                        R.drawable.family_guy_seth
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                6,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                R.drawable.tvshow_flash,
                "October 7, 2014",
                "77",
                "https://youtu.be/Yj0l7iGKh8g",
                listOf(
                    CrewEntity(
                        "Geoff Johns",
                        "Creator",
                        R.drawable.flash_geoff
                    ),
                    CrewEntity(
                        "Andrew Kreisberg",
                        "Creator",
                        R.drawable.flash_andrew
                    ),
                    CrewEntity(
                        "Greg Berlanti",
                        "Creator",
                        R.drawable.flash_greg
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                7,
                "Game of Thrones",
                "leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                R.drawable.tvshow_god,
                "April 17, 2011",
                "84",
                "https://youtu.be/BpJYNVhGf1s",
                listOf(
                    CrewEntity(
                        "David Benioff",
                        "Creator",
                        R.drawable.got_david
                    ),
                    CrewEntity(
                        "D. B. Weiss",
                        "Creator",
                        R.drawable.got_weiss
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
                R.drawable.tvshow_gotham,
                "September 22, 2014",
                "75",
                "https://youtu.be/0d1zpt6k5OI",
                listOf(
                    CrewEntity(
                        "Bruno Heller",
                        "Creator",
                        R.drawable.gotham_bruno
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                9,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                R.drawable.tvshow_grey_anatomy,
                "March 27, 2005",
                "82",
                "https://youtu.be/q1pcpgREQ5c",
                listOf(
                    CrewEntity(
                        "Shonda Rhimes",
                        "Creator",
                        R.drawable.greys_shonda
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                10,
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                R.drawable.tvshow_hanna,
                "March 28, 2019",
                "75",
                "https://youtu.be/wp6myRLnhAs",
                listOf(
                    CrewEntity(
                        "David Farr",
                        "Creator",
                        R.drawable.hanna_david
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                11,
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                R.drawable.tvshow_iron_fist,
                "March 17, 2017",
                "66",
                "https://youtu.be/QCSPda7xQ3s",
                listOf(
                    CrewEntity(
                        "Scott Buck",
                        "Creator",
                        R.drawable.ic_person
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                12,
                "Naruto Shippūden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                R.drawable.tvshow_naruto_shipudden,
                "February 15, 2007",
                "86",
                "https://youtu.be/1WLO0Owi5-A",
                listOf(
                    CrewEntity(
                        "Katsuhiko Chiba",
                        "Writer",
                        R.drawable.naruto_katsuhiko

                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                13,
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                R.drawable.tvshow_ncis,
                "September 23, 2003",
                "74",
                "https://youtu.be/VzSsxINwIVE",
                listOf(
                    CrewEntity(
                        "Don McGill",
                        "Creator",
                        R.drawable.ic_person
                    ),
                    CrewEntity(
                        "Donald P. Bellisario",
                        "Creator",
                        R.drawable.ic_person
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                14,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                R.drawable.tvshow_riverdale,
                "January 26, 2017",
                "86",
                "https://youtu.be/9XmFTADupMc",
                listOf(
                    CrewEntity(
                        "Roberto Aguirre-Sacasa",
                        "Creator",
                        R.drawable.riverdale_roberto
                    )
                )
            )
        )

        tvShows.add(
            TvShowEntity(
                15,
                "Shameless",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                R.drawable.tvshow_shameless,
                "January 9, 2011",
                "80",
                "https://youtu.be/CHstRRD_8LE",
                listOf(
                    CrewEntity(
                        "Paul Abbott",
                        "Creator",
                        R.drawable.ic_person

                        ),
                    CrewEntity(
                        "John Wells",
                        "Creator",
                        R.drawable.shameless_john
                        )
                )
            )
        )
        return tvShows
    }

    fun movieDetail(id: Int): MovieEntity? {
        return generateMovies()[id - 1]
    }

    fun tvShowDetail(id: Int): TvShowEntity? {
        return generateTvShows()[id - 1]
    }
}