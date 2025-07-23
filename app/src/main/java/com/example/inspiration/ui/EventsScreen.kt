package com.example.inspiration.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inspiration.Logo2
import com.example.inspiration.MainColumn
import com.example.inspiration.NavigationButtonsRow
import com.example.inspiration.SpazioPubblicitarioBox2
import com.example.inspiration.data.Datasource
import com.example.inspiration.data.InspirationUiState
import com.example.inspiration.model.Item

@Composable
fun EventsScreen(
    inspirationUiState: InspirationUiState,
    onPreviousButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    infoClicked: (Item) -> Unit,
    onItemCheckedChange: (Item, String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo2()
        SpazioPubblicitarioBox2()
        MainColumn(
            città = inspirationUiState.citta,
            listItem = Datasource().loadEvents(inspirationUiState.citta),
            infoClicked = infoClicked,
            selectedItems = inspirationUiState.eventList,
            onItemCheckedChange,
            category = "Eventi"

        )
        NavigationButtonsRow(
            text1 = "Indietro",
            onPreviousButtonClicked = onPreviousButtonClicked,
            onNextButtonClicked = onNextButtonClicked,
            text2 = "Avanti")
    }


}

