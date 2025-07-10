package com.example.inspiration.data

import com.example.inspiration.R
import com.example.inspiration.model.Item

class Datasource() {
    fun loadPlaces(): List<Item> {
        return listOf<Item>(
            Item(R.string.place1, R.drawable.torre_aquila, "Torre Acquila dkfjk"),
            Item(R.string.place2, R.drawable.palazzo_albere_1_1024x684, "Palazzo Albere hdjfdhckc"),
            /*Item(R.string.place3),
            Item(R.string.place4),
            Item(R.string.place5),
            Item(R.string.place6),
            Item(R.string.place7),
            Item(R.string.place8),
            Item(R.string.place9),
            Item(R.string.place10),
            Item(R.string.place11)*/)
    }

    fun loadEvents(): List<Item> {
        return listOf<Item>(
            Item(R.string.events1, R.drawable.oip_vdi4oihosfjl9atbc0dp1qhafj, "C. Jazz"),
            Item(R.string.events2, R.drawable.oip_3r4rqynpdhnxnxahjuwu9ghaha, "Sushetto"),
            /*Item(R.string.events3),
            Item(R.string.events4),
            Item(R.string.events5),
            Item(R.string.events6),
            Item(R.string.events7),
            Item(R.string.events8),
            Item(R.string.events9),
            Item(R.string.events10),
            Item(R.string.events11)*/)
    }


    fun loadExperiences(): List<Item> {
        return listOf<Item>(
            /*Item(R.string.experience1),
            Item(R.string.experience2),
            Item(R.string.experience3),
            Item(R.string.experience4),
            Item(R.string.experience5),
            Item(R.string.experience6),
            Item(R.string.experience7),
            Item(R.string.experience8),
            Item(R.string.experience9),
            Item(R.string.experience10),
            Item(R.string.experience11)*/)
    }


}