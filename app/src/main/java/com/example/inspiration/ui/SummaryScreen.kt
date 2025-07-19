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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.inspiration.data.InspirationUiState
import com.example.inspiration.model.Item
import org.burnoutcrew.reorderable.*
import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

@Composable
fun SummaryScreen(
    inspirationUiState: InspirationUiState,
    onPreviousButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Logo2()
        SelectedItems(
            text = "Hai selezionato " +
                    (inspirationUiState.placeList.size +
                inspirationUiState.eventList.size +
                inspirationUiState.experienceList.size) + " Ispirazioni:",
            listItem = inspirationUiState.placeList +
                    inspirationUiState.eventList +
                    inspirationUiState.experienceList
        )
        Map()

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            val context = LocalContext.current
            ButtonButton(
                text = "Condividi",
                onclick = {
                    val sendIntent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "maps.google.milano....")
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent, null)
                    context.startActivity(shareIntent)
                },
                backgroundColor = Color.White,
                mainColor = Color.Black
            )
            ButtonButton(
                text = "Avvia Percorso",
                onclick = {},
                backgroundColor = Color.Black,
                mainColor = Color.White
            )
        }

        NavigationButtonsRow(
            text1 = "Indietro",
            text2 = "Nuova ricerca",
            onPreviousButtonClicked = onPreviousButtonClicked,
            onNextButtonClicked = onNextButtonClicked,
        )
    }
}

@Composable
fun Map() {
    Image (
        modifier = Modifier.padding(top = 10.dp),
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
            ListDetails(
                list = listItem
            )
        }
    }
}

@Composable
fun ListDetails (list: List<Item>) {
    var items by remember { mutableStateOf(list.toMutableList()) }
    val reorderState = rememberReorderableLazyListState(onMove = { from, to ->
        items = items.toMutableList().apply {
            add(to.index, removeAt(from.index))
        }
    })
    LazyColumn(
        state = reorderState.listState,
        modifier = Modifier
            .reorderable(reorderState)
            .detectReorderAfterLongPress(reorderState)
    ) {
        items(items, key = { it.titolo }) { singleElem ->
            ReorderableItem(reorderState, key = singleElem.titolo) { isDragging ->
                val bgColor = if (isDragging) Color(0xFFE0E0E0) else Color.Transparent
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(bgColor)
                ) {
                    Elem (
                        elem = singleElem,
                    )
                }
            }
        }
    }
}

@Composable
fun Elem (elem: Item) {
    Row {
        Text (
            text = LocalContext.current.getString(elem.titolo),
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun ButtonButton(
    text: String,
    backgroundColor: Color,
    mainColor: Color,
    onclick: () -> Unit,
) {
    Box(modifier = Modifier.padding(top = 20.dp)) {
        Button(
            onClick = onclick,
            modifier = Modifier
                .size(width = 150.dp, height = 50.dp)
                .background(backgroundColor),
            shape = RectangleShape,
            border = BorderStroke(1.dp, mainColor),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
        ) {
            Text(
                text = text,
                fontSize = 15.sp,
                color = mainColor,
            )
        }
    }
}