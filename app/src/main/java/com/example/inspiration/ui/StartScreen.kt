package com.example.inspiration.ui

import com.example.inspiration.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StartScreen(
    onButtonClicked: (String) -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, end = 10.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                IconButton (onClick = {
                    println("Ciao")
                }) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "Impostazioni")
                }
            }
            Image (
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(250.dp),
                alignment = Alignment.Center
            )
            DropdownMenuCittà("Seleziona città", onButtonClicked)
            SpazioPubblicitarioBox()
    }
}


@Composable
fun DropdownMenuCittà(message: String, onButtonClicked: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var buttonWidth by remember { mutableIntStateOf(0) }
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

            DropdownMenu (
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
                        Button (onClick = {onButtonClicked(option)}, modifier = Modifier.background(color = Color.White, shape = RectangleShape)) {
                            Text(option, fontSize = 18.sp)
                        }
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

}
