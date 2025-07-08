package com.example.inspiration.data

import com.example.inspiration.model.Item

data class InspirationUiState(
    val città: String = "",
    val placeList: List<Item> = listOf(),
    val eventList: List<Item> = listOf(),
    val experienceList: List<Item> = listOf(),
    val selectedItem: Item
)