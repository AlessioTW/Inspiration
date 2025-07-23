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
import androidx.compose.material.icons.outlined.CheckCircle
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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

enum class InspirationScreen {
    Start,
    Places,
    Events,
    Experiences,
    Details,
    Summary
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
                    viewModel.setCitta(it)
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
                infoClicked = {
                    viewModel.setSelectedItem(it)
                    navController.navigate(InspirationScreen.Details.name)
                },
                onItemCheckedChange = { item, _ ->
                    viewModel.toggleItem(item, "Luoghi")
                }
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
                infoClicked = {
                    viewModel.setSelectedItem(it)
                    navController.navigate(InspirationScreen.Details.name)
                },
                onItemCheckedChange = { item, _ ->
                    viewModel.toggleItem(item, "Eventi")
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
                infoClicked = {
                    viewModel.setSelectedItem(it)
                    navController.navigate(InspirationScreen.Details.name)
                },
                onItemCheckedChange = { item, _ ->
                    viewModel.toggleItem(item, "Esperienze")
                }
            )
        }
        composable (route = InspirationScreen.Details.name) {
            DetailsScreen(
                inspirationUiState = uiState,
                onPreviousButtonClicked = {
                    navController.popBackStack()
                },
            )
        }
        composable(route = InspirationScreen.Summary.name) {
            SummaryScreen(
                inspirationUiState = uiState,
                onPreviousButtonClicked = {navController.popBackStack()},
                onNextButtonClicked = {viewModel.resetOrder()
                    navController.popBackStack(InspirationScreen.Start.name, inclusive = false)})
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
    città: String,
    listItem: List<Item>,
    infoClicked: (Item) -> Unit,
    selectedItems: List<Item>,
    onItemCheckedChange: (Item, String) -> Unit,
    category: String
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
        Row (modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(vertical = 10.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text (
                text = città,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text (
                text = category,
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 16.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Row {
                Icon (
                    imageVector = Icons.Outlined.CheckCircle,
                    contentDescription = "null",
                    modifier = Modifier
                        .padding(vertical = 15.dp, horizontal =10.dp))
                Text (
                    text = selectedItems.size.toString(),
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 18.dp),
                    fontSize = 25.sp
                )
            }
        }

        Surface(
            modifier = Modifier.height(450.dp),
        ) {
            ListItems(
                listItems = listItem,
                selectedItems,
                onItemToggle = onItemCheckedChange,
                onItemInfoClicked = infoClicked,
                category
            )
        }
    }
}

@Composable
fun ListItems (
    listItems: List<Item>,
    selectedItems: List<Item>,
    onItemToggle: (Item, String) -> Unit,
    onItemInfoClicked: (Item) -> Unit,
    category: String
) {
    LazyColumn {
        items (listItems) { singleItem ->
            PlaceElemCheckBox (
                item = singleItem,
                isChecked = selectedItems.contains(singleItem),
                onCheckedChange = { onItemToggle(singleItem, category) },
                onClickInfo = { onItemInfoClicked(singleItem) }
            )
        }
    }
}

@Composable
fun NavigationButtonsRow(
    text1: String,
    onPreviousButtonClicked: () -> Unit,
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
            onClick = onPreviousButtonClicked
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
    item: Item,
    isChecked: Boolean,
    onCheckedChange: () -> Unit,
    onClickInfo: () -> Unit
) {
    Row {
        Text (
            text = LocalContext.current.getString(item.titolo),
            modifier = Modifier.padding(16.dp),
            fontSize = 17.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        if (item.vip) {
            Text(
                text = "⭐️",
                fontSize = 22.sp,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
        IconButton(onClick = onClickInfo) {
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
            checked = isChecked,
            onCheckedChange = {onCheckedChange()}
        )
    }
}
