package com.example.inspiration.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import com.example.inspiration.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inspiration.InspirationScreen
import com.example.inspiration.Logo2
import com.example.inspiration.NavigationButton
import com.example.inspiration.SpazioPubblicitarioBox2
import com.example.inspiration.data.InspirationUiState

@Composable
fun DetailsScreen(
    inspirationUiState: InspirationUiState,
    onPreviousButtonClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo2()
        SpazioPubblicitarioBox2()
        DetailsColumn(
            titolo = LocalContext.current.getString(inspirationUiState.selectedItem!!.stringResourceId),
            imageId = inspirationUiState.selectedItem.imageId,
            imageDescription = inspirationUiState.selectedItem.description,
            )
        NavigationButton(
            text = "Indietro",
            backgroundColor = Color.White,
            mainColor = Color.Black,
            onClick = onPreviousButtonClicked
        )

    }
}


@Composable
fun DetailsColumn (titolo: String, @DrawableRes imageId:Int, imageDescription: String) {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RectangleShape
            )
            .width(321.dp)
            .height(570.dp),
    ) {
        Text(
            text = titolo,
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(20.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
        Surface (
            modifier = Modifier.height(470.dp),
        ){
            Column {
                Box (modifier = Modifier
                    .height(250.dp)
                    .width(400.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image (
                        painter = painterResource(imageId),
                        contentDescription = imageDescription,
                        modifier = Modifier.padding(vertical = 15.dp),
                        contentScale = ContentScale.Fit
                    )
                }
                Column (
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = imageDescription,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                    )
                }
            }
        }
    }
}