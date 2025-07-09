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
                città = citta
            )
        }
    }

    fun setPlace(listPlace: List<Item>) {
        _uiState.update { currentState ->
            currentState.copy (
                placeList = listPlace
            )
        }
    }

    fun setExperience(listExperience: List<Item>) {
        _uiState.update { currentState ->
            currentState.copy (
                experienceList = listExperience
            )
        }
    }

    fun setEvent(listEvent: List<Item>) {
        _uiState.update { currentState ->
            currentState.copy (
                eventList = listEvent
            )
        }
    }

    fun setSelectedItem(item: Item) {
        _uiState.update { currentState ->
            currentState.copy (
                selectedItem = item
            )
        }
    }


}

