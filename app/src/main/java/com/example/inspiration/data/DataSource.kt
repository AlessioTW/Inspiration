package com.example.inspiration.data

import com.example.inspiration.R
import com.example.inspiration.model.Item

class Datasource {
    fun loadPlaces(citta: String): List<Item> {
        if (citta == "Trento") {
            return listOf(
                Item(R.string.place1, R.drawable.torre_aquila, R.string.desc_place1),
                Item(R.string.place2, R.drawable.palazzo_albere_1_1024x684, R.string.desc_place2),
                Item(R.string.place3, R.drawable.palazzo_pretorio, R.string.desc_place3),
                Item(R.string.place4, R.drawable.muse, R.string.desc_place4),
                Item(R.string.place5, R.drawable.maria_maggiore, R.string.desc_place5),
                Item(R.string.place6, R.drawable.fontana_nettuno, R.string.desc_place6),
                Item(R.string.place7, R.drawable.piazza_venezia, R.string.desc_place7),
                Item(R.string.place8, R.drawable.parco_gocciadoro, R.string.desc_place8),
                Item(R.string.place9, R.drawable.piazza_fiera, R.string.desc_place9),
                Item(R.string.place10, R.drawable.castello_buonconsiglio, R.string.desc_place10),
                Item(R.string.place11, R.drawable.piazza_del_duomo, R.string.desc_place11))
        }else if (citta == "Verona") {
            return listOf(
                Item(R.string.Veronaplace1, R.drawable.arena_di_verona, R.string.desc_Veronaplace1),
                Item(R.string.Veronaplace2, R.drawable.piazza_delle_erbe, R.string.desc_Veronaplace2),
                Item(R.string.Veronaplace3, R.drawable.casa_di_giulietta, R.string.desc_Veronaplace3),
                Item(R.string.Veronaplace4, R.drawable.torre_dei_lamberti, R.string.desc_Veronaplace4),
                Item(R.string.Veronaplace5, R.drawable.castelvecchio, R.string.desc_Veronaplace5),
                Item(R.string.Veronaplace6, R.drawable.piazza_dei_signori, R.string.desc_Veronaplace6),
                Item(R.string.Veronaplace7, R.drawable.casa_di_romeo, R.string.desc_Veronaplace7),
                Item(R.string.Veronaplace8, R.drawable.ponte_scaligero, R.string.desc_Veronaplace8),
                Item(R.string.Veronaplace9, R.drawable.piazza_del_duomo, R.string.desc_Veronaplace9),
                Item(R.string.Veronaplace10, R.drawable.basilica_di_san_zeno_maggiore, R.string.desc_Veronaplace10),
                Item(R.string.Veronaplace11, R.drawable.giardino_giusti, R.string.desc_Veronaplace11),
            )
        } else return listOf()

    }

    fun loadEvents(citta: String): List<Item> {
        if (citta=="Trento") {
            return listOf(
                Item(R.string.events1, R.drawable.oip_vdi4oihosfjl9atbc0dp1qhafj, R.string.desc_events1),
                Item(R.string.events2, R.drawable.oip_3r4rqynpdhnxnxahjuwu9ghaha, R.string.desc_events2),
                Item(R.string.events3, R.drawable.festa_alle_albere, R.string.desc_events3, true),
                Item(R.string.events4, R.drawable.serata_erasmus, R.string.desc_events4, true),
                Item(R.string.events5, R.drawable.aperitivo_duomo, R.string.desc_events5),
                Item(R.string.events6, R.drawable.mostra_muse, R.string.desc_events6, true),
                Item(R.string.events7, R.drawable.citt__sotterranea, R.string.desc_events7),
                Item(R.string.events8, R.drawable.tutto_a_un_euro, R.string.desc_events8),
                Item(R.string.events9, R.drawable.cinema_multisala, R.string.desc_events9),
                Item(R.string.events10, R.drawable.apericena, R.string.desc_events10),
                Item(R.string.events11, R.drawable.colazione_gourmet, R.string.desc_events11))
        }else if (citta=="Verona") {
            return listOf(
                Item(R.string.Veronaevents1, R.drawable.festival_areniano, R.string.desc_Veronaevents1),
                Item(R.string.Veronaevents2, R.drawable.vinitaly, R.string.desc_Veronaevents2, true),
                Item(R.string.Veronaevents3, R.drawable.straverona, R.string.desc_Veronaevents3),
                Item(R.string.Veronaevents4, R.drawable.tocati, R.string.desc_Veronaevents4),
                Item(R.string.Veronaevents5, R.drawable.carnevale, R.string.desc_Veronaevents5),
                Item(R.string.Veronaevents6, R.drawable.piazza_dei_signori, R.string.desc_Veronaevents6),
                Item(R.string.Veronaevents7, R.drawable.verona_tessile, R.string.desc_Veronaevents7),
                Item(R.string.Veronaevents8, R.drawable.estate_teatrale_veronese, R.string.desc_Veronaevents8),
                Item(R.string.Veronaevents9, R.drawable.fieracavalli_verona, R.string.desc_Veronaevents9, true),
                Item(R.string.Veronaevents10, R.drawable.mostre, R.string.desc_Veronaevents10),
                Item(R.string.Veronaevents11, R.drawable.tramonti_unesco, R.string.desc_Veronaevents11, true),
            )
        } else return listOf()

    }


    fun loadExperiences(citta: String): List<Item> {
        if (citta=="Trento") {
            return listOf(
                Item(R.string.experience1, R.drawable.orrido, R.string.desc_experience1),
                Item(R.string.experience2, R.drawable.gita_a_cavallo, R.string.desc_experience2, true),
                Item(R.string.experience3, R.drawable.trekking_con_guida, R.string.desc_experience3, true),
                Item(R.string.experience4, R.drawable.guida_ai_musei, R.string.desc_experience4),
                Item(R.string.experience5, R.drawable.rafting, R.string.desc_experience5),
                Item(R.string.experience6, R.drawable.enogastronomia, R.string.desc_experience6),
                Item(R.string.experience7, R.drawable.esperienza_culinaria, R.string.desc_experience7),
                Item(R.string.experience8, R.drawable.degustazione_vini, R.string.desc_experience8, true),
                Item(R.string.experience9, R.drawable.degustazione_grappe, R.string.desc_experience9),
                Item(R.string.experience10, R.drawable.corso_di_cucina, R.string.desc_experience10),
                Item(R.string.experience11, R.drawable.walking_tour, R.string.desc_experience11))
        }else if (citta == "Verona") {
            return listOf(
                Item(R.string.Veronaexperience1, R.drawable.tour_in_bici, R.string.desc_Veronaexperience1, true),
                Item(R.string.Veronaexperience2, R.drawable.degustazione_vini, R.string.desc_Veronaexperience2, true),
                Item(R.string.Veronaexperience3, R.drawable.corso_di_cucina, R.string.desc_Veronaexperience3, true),
                Item(R.string.Veronaexperience4, R.drawable.corso_di_cucina, R.string.desc_Veronaexperience4),
                Item(R.string.Veronaexperience5, R.drawable.caccia_al_tesoro, R.string.desc_Veronaexperience5),
                Item(R.string.Veronaexperience6, R.drawable.visita_musei, R.string.desc_Veronaexperience6, true),
                Item(R.string.Veronaexperience7, R.drawable.giro_in_barca, R.string.desc_Veronaexperience7),
                Item(R.string.Veronaexperience8, R.drawable.passaggiata_giusti, R.string.desc_Veronaexperience8, true),
                Item(R.string.Veronaexperience9, R.drawable.tour_shakespeare, R.string.desc_Veronaexperience9),
                Item(R.string.Veronaexperience10, R.drawable.tour_mura_verona, R.string.desc_Veronaexperience10),
            )
        }else return listOf()


    }


}