package com.example.inspiration.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.inspiration.Logo2
import com.example.inspiration.MainColumn
import com.example.inspiration.NavigationButtonsRow
import com.example.inspiration.SpazioPubblicitarioBox2
import com.example.inspiration.data.Datasource
import com.example.inspiration.data.InspirationUiState

@Composable
fun EventsScreen(
    inspirationUiState: InspirationUiState,
    onPreviousButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onItemClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo2()
        SpazioPubblicitarioBox2()
        MainColumn(
            "Eventi di " + inspirationUiState.città,
            Datasource().loadEvents(),
            itemClicked = {onItemClicked}
        )
        NavigationButtonsRow(
            text1 = "Indietro",
            onPreviousButtonCliked = onPreviousButtonClicked,
            onNextButtonClicked = onNextButtonClicked,
            text2 = "Avanti")
    }

}

