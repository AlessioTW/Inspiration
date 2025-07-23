package com.example.inspiration.ui

import androidx.lifecycle.ViewModel
import com.example.inspiration.data.InspirationUiState
import com.example.inspiration.model.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InspirationViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(InspirationUiState())
    val uiState: StateFlow<InspirationUiState> = _uiState.asStateFlow()

    fun setCitta(citta: String) {
        _uiState.update { currentState ->
            currentState.copy (
                citta = citta
            )
        }
    }

    fun toggleItem (item: Item, category: String) {
        _uiState.update { currentState ->
            when (category) {
                "Luoghi" -> {
                    val updatedList = if (currentState.placeList.contains(item)) {
                        currentState.placeList - item
                    } else {
                        currentState.placeList + item
                    }
                    currentState.copy(placeList = updatedList)
                }
                "Eventi" -> {
                    val updatedList = if (currentState.eventList.contains(item)) {
                        currentState.eventList - item
                    } else {
                        currentState.eventList + item
                    }
                    currentState.copy(eventList = updatedList)
                }
                "Esperienze" -> {
                    val updatedList = if (currentState.experienceList.contains(item)) {
                        currentState.experienceList - item
                    } else {
                        currentState.experienceList + item
                    }
                    currentState.copy(experienceList = updatedList)
                }
                else -> currentState
            }
        }
    }

    fun setSelectedItem(item: Item) {
        _uiState.update { currentState ->
            currentState.copy (
                selectedItem = item
            )
        }
    }

    fun resetOrder() {
        _uiState.value = InspirationUiState()
    }

}

