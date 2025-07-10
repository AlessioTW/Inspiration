package com.example.inspiration.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inspiration.Logo2
import com.example.inspiration.NavigationButtonsRow
import com.example.inspiration.R
import com.example.inspiration.data.Datasource
import com.example.inspiration.model.Item

@Composable
fun SummaryScreen() {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Logo2()
        SelectedItems("Hai selezionato", Datasource().loadExperiences())
        Map()
        NavigationButtonsRow(
            text1 = "Avvia percorso",
            text2 = "Condividi",
            onNextButtonClicked = {},
            onPreviousButtonCliked = {},
        )
    }
}

@Composable
fun Map() {
    Image (
        modifier = Modifier.padding(25.dp),
        painter = painterResource(R.drawable.mappa),
        contentDescription = "Mappa",
        contentScale = ContentScale.Fit
    )
}

@Composable
fun SelectedItems (text: String, listItem: List<Item>) {
    Column (
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RectangleShape
            )
            .width(310.dp),
    ) {
        Text (
            text = text,
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(10.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )
        Surface(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
        ) {
            PlaceListDetails(
                placeList = listItem
            )
        }
    }
}

@Composable
fun PlaceListDetails (placeList: List<Item>) {
    LazyColumn{
        items (placeList) { singlePlace ->
            PlaceElem (
                place = singlePlace,
            )
        }
    }
}

@Composable
fun PlaceElem(place: Item) {

    Row{
        Text (
            text = LocalContext.current.getString(place.stringResourceId),
            modifier = Modifier.padding(10.dp)
        )
    }
}