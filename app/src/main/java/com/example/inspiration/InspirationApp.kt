package com.example.inspiration

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inspiration.model.Item
import com.example.inspiration.ui.DetailsScreen
import com.example.inspiration.ui.EventsScreen
import com.example.inspiration.ui.ExperiencesScreen
import com.example.inspiration.ui.InspirationViewModel
import com.example.inspiration.ui.PlacesScreen
import com.example.inspiration.ui.StartScreen
import com.example.inspiration.ui.SummaryScreen

enum class InspirationScreen () {
    Start(),
    Places(),
    Events(),
    Experiences(),
    Details(),
    Summary()
}

@Composable
fun InspirationApp (
    viewModel: InspirationViewModel = viewModel(),
    navController: NavHostController = rememberNavController()){

    val uiState by viewModel.uiState.collectAsState()

    NavHost (
        navController = navController,
        startDestination = InspirationScreen.Start.name,
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        composable (route = InspirationScreen.Start.name) {
            StartScreen(
                onButtonClicked = {
                    viewModel.setCitta(it.toString())
                    navController.navigate(InspirationScreen.Places.name)
                }
            )
        }
        composable (route = InspirationScreen.Places.name) {
            PlacesScreen(
                inspirationUiState = uiState,
                onPreviousButtonClicked = {
                    navController.navigate(InspirationScreen.Start.name)
                },
                onNextButtonClicked = {
                    navController.navigate(InspirationScreen.Events.name)
                },
                onItemClicked = {
                    viewModel.setSelectedItem(it)
                    navController.navigate(InspirationScreen.Details.name)
                },
            )
        }
        composable (route = InspirationScreen.Events.name) {
            EventsScreen(
                inspirationUiState = uiState,
                onPreviousButtonClicked = {
                    navController.navigate(InspirationScreen.Places.name)
                },
                onNextButtonClicked = {
                    navController.navigate(InspirationScreen.Experiences.name)
                },
                onItemClicked = {
                    navController.navigate(InspirationScreen.Details.name)
                }

            )
        }
        composable (route = InspirationScreen.Experiences.name) {
            ExperiencesScreen(
                inspirationUiState = uiState,
                onPreviousButtonClicked = {
                    navController.navigate(InspirationScreen.Events.name)
                },
                onNextButtonClicked = {
                    navController.navigate(InspirationScreen.Summary.name)
                },
                onItemClicked = {
                    navController.navigate(InspirationScreen.Details.name)
                }
            )
        }
        composable (route = InspirationScreen.Details.name) {
            DetailsScreen(inspirationUiState = uiState)
        }
        composable(route = InspirationScreen.Summary.name) {
            SummaryScreen()
        }
    }
}


@Preview
@Composable
fun Logo2 () {
    val image = painterResource(R.drawable.logo)

    Image (
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .size(170.dp)
            .padding(top = 65.dp)
        ,
        alignment = Alignment.Center
    )
}


@Composable
fun SpazioPubblicitarioBox2() {
    Box(
        modifier = Modifier
            .width(500.dp)
            .height(85.dp)
            .padding(top = 5.dp, bottom = 5.dp)
            .padding(horizontal = 45.dp)
            .border(1.dp, Color.Black)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Spazio pubblicitario",
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}


@Composable
fun NavigationButton(
    text: String,
    backgroundColor: Color,
    mainColor: Color,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.padding(top = 20.dp)) {
        OutlinedButton(
            onClick,
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


@Composable
fun MainColumn (
    text: String,
    listItem: List<Item>,
    itemClicked: (Item) -> Unit
) {
    Column (
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RectangleShape
            )
            .width(321.dp)
    ) {
        Text (
            text = text,
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(20.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
        Surface(
            modifier = Modifier.height(450.dp),
        ) {
            PlaceList(
                placeList = listItem,
                itemClicked
            )
        }
    }
}

@Composable
fun PlaceList (
    placeList: List<Item>,
    itemClicked: (Item) -> Unit
) {
    LazyColumn {
        items (placeList) { singlePlace ->
            PlaceElemCheckBox (
                place = singlePlace,
                onClick = {itemClicked(singlePlace)}
            )
        }
    }
}

@Composable
fun NavigationButtonsRow(
    text1: String,
    onPreviousButtonCliked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    text2: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NavigationButton(
            text = text1,
            backgroundColor = Color.White,
            mainColor = Color.Black,
            onClick = onPreviousButtonCliked
        )
        NavigationButton(
            text = text2,
            backgroundColor = Color.Black,
            mainColor = Color.White,
            onClick = onNextButtonClicked
        )
    }
}

@Composable
fun PlaceElemCheckBox (
    place: Item,
    onClick: () -> Unit
) {
    var checked by rememberSaveable { mutableStateOf(false) }

    Row {
        Text (
            text = LocalContext.current.getString(place.stringResourceId),
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "info",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.White)
            )
        }
        Checkbox (
            checked = checked,
            onCheckedChange = {checked = it}
        )
    }
}
