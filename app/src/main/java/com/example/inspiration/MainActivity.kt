package com.example.inspiration

import android.annotation.SuppressLint
import android.graphics.Rect
import android.graphics.drawable.Icon
import android.graphics.pdf.models.ListItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inspiration.data.Datasource
import com.example.inspiration.model.Item
import com.example.inspiration.ui.theme.InspirationTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InspirationTheme {
                InspirationApp()

                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)) {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally){
                        /*Impostazioni()
                        Logo()
                        DropdownMenuCittà("Seleziona città")
                        SpazioPubblicitarioBox()*/

                        // 2,3,4 pagina


                        Logo2()
                        //SpazioPubblicitarioBox2()
                        Map()
                        SelectedItems("Hai selezionato", Datasource().loadExperiences())
                        NavigationButtonsRow(text1 = "Avvia percorso", text2 = "Condividi")
                        //MainColumn("Luoghi", Datasource().loadPlaces())
                        //MainColumn("Eventi", Datasource().loadEvents())
                        // MainColumn("Esperienze", Datasource().loadExperiences())
                        // NavigationButtonsRow()


                        // 3 pagina

                        /*

                        Logo2()
                        SpazioPubblicitarioBox2()
                        DetailsColumn(titolo = "Orrido Ponte Alto", R.drawable.oip_if8yfsuwmzl_j4cnm63_lqhajq, "L’Orrido di Ponte Alto è una spettacolare gola scavata nei secoli dalle impetuose acque del torrente Fersina, situata a pochi chilometri dal centro di Trento. Questo canyon naturale, profondo e suggestivo, offre uno dei paesaggi più affascinanti della regione, dove natura e ingegneria storica si incontrano in un connubio unico.")
                        NavigationButton(text = "Indietro", backgroundColor = Color.White, mainColor = Color.Black)

                        */

                    }
                }
            }
        }
    }
}

// prima pagina
/*

@Preview
@Composable
fun Logo () {
    val image = painterResource(R.drawable.logo_nitido_senza_cambiamenti__2__removebg_preview)

    Image (
        painter = image,
        contentDescription = null,
        modifier = Modifier.size(250.dp),
        alignment = Alignment.Center
    )
}

@Composable
fun DropdownMenuCittà(message: String) {
    var expanded by remember { mutableStateOf(false) }
    var buttonWidth by remember { mutableIntStateOf(0) }
    // Placeholder list of 100 strings for demonstration
    val menuItemData = listOf("Trento")

    Box(
        modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
    ) {
        OutlinedButton (
            onClick = { expanded = !expanded },
            modifier = Modifier
                .wrapContentWidth()
                .height(48.dp)
                .onGloballyPositioned { coordinates ->
                    buttonWidth = coordinates.size.width
                }
            ,
            shape = RectangleShape,
            border = BorderStroke(1.dp, Color.Black),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Seleziona città", fontSize = 18.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                offset = DpOffset(x = (-23).dp, y = 8.dp),
                modifier = Modifier
                    .width(with(LocalDensity.current){ buttonWidth.toDp()})
                    .border(width = 1.dp, color = Color.Black, shape = RectangleShape)
                    .background(color = Color.White),
            ) {
                menuItemData.forEach { option ->
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                            .padding(start = 20.dp, top = 8.dp, bottom = 8.dp)
                    ) {
                        Text(option, fontSize = 18.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun SpazioPubblicitarioBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(3f / 4f)
            .padding(vertical = 45.dp, horizontal = 45.dp)
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
fun Impostazioni() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, end = 10.dp),
        horizontalArrangement = Arrangement.End,
    ) {
        IconButton(onClick = {
            println("Ciao")
        }) {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "Impostazioni")
        }


    }
}*/

@Preview
@Composable
fun Logo2 () {
    val image = painterResource(R.drawable.logo_nitido_senza_cambiamenti__2__removebg_preview)

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
fun NavigationButton(text: String, backgroundColor: Color, mainColor: Color) {
    Box(modifier = Modifier.padding(top = 20.dp)) {
        OutlinedButton(
            onClick = { },
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
// seconda pagina
/*

@Composable
fun MainColumn (text: String, listItem: List<Item>) {
    Column (
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RectangleShape
            )
            .width(310.dp)
    ) {
        Text (
            text = text,
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(20.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )
        Surface(
            modifier = Modifier.height(450.dp),
        ) {
            PlaceList(
                placeList = listItem
            )
        }
    }
}

@Composable
fun PlaceList (placeList: List<Item>) {
    LazyColumn {
        items (placeList) { singlePlace ->
            PlaceElem(
                place = singlePlace,
            )
        }
    }
}

@Composable
fun PlaceElem(place: Item) {

    var checked by rememberSaveable { mutableStateOf(false) }

    Row{
        Text (
            text = LocalContext.current.getString(place.stringResourceId),
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Checkbox (
            checked = checked,
            onCheckedChange = {checked = it}
        )
    }
}

// pagina dettagli

@Composable
fun DetailsColumn (titolo: String, @DrawableRes imageId:Int, imageDescription: String) {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RectangleShape
            )
            .width(310.dp)
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
                        modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                    )
                }
            }
        }
    }
}


 */

@Composable
fun NavigationButtonsRow(text1: String, text2: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NavigationButton(
            text = text1,
            backgroundColor = Color.White,
            mainColor = Color.Black
        )
        NavigationButton(
            text = text2,
            backgroundColor = Color.Black,
            mainColor = Color.White
        )
    }
}

@Composable
fun Map() {
    Image (
        modifier = Modifier.padding(25.dp),
        painter = painterResource(R.drawable.giro2024_piemonte_venaria_torino_mappa_completa),
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
            fontSize = 15.sp,
        )
        Surface(
            modifier = Modifier.height(200.dp),
        ) {
            PlaceList(
                placeList = listItem
            )
        }
    }
}

@Composable
fun PlaceList (placeList: List<Item>) {
    LazyColumn {
        items (placeList) { singlePlace ->
            PlaceElem(
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