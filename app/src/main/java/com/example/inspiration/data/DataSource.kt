package com.example.inspiration.data

import com.example.inspiration.R
import com.example.inspiration.model.Item

class Datasource() {
    fun loadPlaces(): List<Item> {
        return listOf<Item>(
            Item(R.string.place1, R.drawable.torre_aquila, "Torre Acquila"),
            Item(R.string.place2, R.drawable.palazzo_albere_1_1024x684, "Palazzo Albere"),
            Item(R.string.place3, R.drawable.palazzo_pretorio, "Palazzo Pretorio"),
            Item(R.string.place4, R.drawable.muse, "Muse"),
            Item(R.string.place5, R.drawable.maria_maggiore, "Maria Maggiore"),
            Item(R.string.place6, R.drawable.fontana_nettuno, "Fontana Nettuno"),
            Item(R.string.place7, R.drawable.piazza_venezia, "Piazza Venezia"),
            Item(R.string.place8, R.drawable.parco_gocciadoro, "Parco Gocciadoro"),
            Item(R.string.place9, R.drawable.piazza_fiera, "Piazza Fiera"),
            Item(R.string.place10, R.drawable.castello_buonconsiglio, "Castello Buonconsiglio"),
            Item(R.string.place11, R.drawable.piazza_del_duomo, "Piazza Duomo"))
    }

    fun loadEvents(): List<Item> {
        return listOf<Item>(
            Item(R.string.events1, R.drawable.oip_vdi4oihosfjl9atbc0dp1qhafj, "C. Jazz"),
            Item(R.string.events2, R.drawable.oip_3r4rqynpdhnxnxahjuwu9ghaha, "Sushetto"),
            Item(R.string.events3, R.drawable.festa_alle_albere, "Festa alle Albere"),
            Item(R.string.events4, R.drawable.serata_erasmus, "Serata Erasmus"),
            Item(R.string.events5, R.drawable.aperitivo_duomo, "Aperitivo Duomo"),
            Item(R.string.events6, R.drawable.mostra_muse, "Visita Muse"),
            Item(R.string.events7, R.drawable.citt__sotterranea, "Città sotterranea"),
            Item(R.string.events8, R.drawable.tutto_a_un_euro, "Tutto a un euro"),
            Item(R.string.events9, R.drawable.cinema_multisala, "Cinema multisala"),
            Item(R.string.events10, R.drawable.apericena, "Apericena"),
            Item(R.string.events11, R.drawable.colazione_gourmet, "Colazione gourmet"))
    }


    fun loadExperiences(): List<Item> {
        return listOf<Item>(
            Item(R.string.experience1, R.drawable.orrido, "Orrido Ponte Alto"),
            Item(R.string.experience2, R.drawable.gita_a_cavallo, "Gita a cavallo"),
            Item(R.string.experience3, R.drawable.trekking_con_guida, "Trekking con guida"),
            Item(R.string.experience4, R.drawable.guida_ai_musei, "Guida ai musei"),
            Item(R.string.experience5, R.drawable.rafting, "Rafting"),
            Item(R.string.experience6, R.drawable.enogastronomia, "Enogastronomia"),
            Item(R.string.experience7, R.drawable.esperienza_culinaria, "Esperienza culinaria"),
            Item(R.string.experience8, R.drawable.degustazione_vini, "Degustazione vini"),
            Item(R.string.experience9, R.drawable.degustazione_grappe, "Degustazione grappe"),
            Item(R.string.experience10, R.drawable.corso_di_cucina, "Corso di cucina"),
            Item(R.string.experience11, R.drawable.walking_tour, "Walking tour"))
    }


}