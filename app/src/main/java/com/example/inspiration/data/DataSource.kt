package com.example.inspiration.data

import com.example.inspiration.R
import com.example.inspiration.model.Item

class Datasource() {
    fun loadPlaces(): List<Item> {
        return listOf<Item>(
            Item(R.string.place1),
            Item(R.string.place2),
            Item(R.string.place3),
            Item(R.string.place4),
            Item(R.string.place5),
            Item(R.string.place6),
            Item(R.string.place7),
            Item(R.string.place8),
            Item(R.string.place9),
            Item(R.string.place10),
            Item(R.string.place11))
    }
}