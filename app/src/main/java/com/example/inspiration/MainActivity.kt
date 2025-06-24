package com.example.inspiration

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.speech.ModelDownloadListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inspiration.ui.theme.InspirationTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InspirationTheme {
                Scaffold(modifier = Modifier.fillMaxSize().background(Color.White)) {
                    Column {
                        Logo()
                        DropdownMenuCittà("Seleziona città")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Logo () {
    val image = painterResource(R.drawable.logo_nitido_senza_cambiamenti)

    Image (
        painter = image,
        contentDescription = null
    )
}

@Composable
fun DropdownMenuCittà(message: String) {
    var expanded by remember { mutableStateOf(false) }
    var buttonWidth by remember { mutableIntStateOf(0) }
    // Placeholder list of 100 strings for demonstration
    val menuItemData = listOf("Trento", "Verona")

    Box(
        modifier = Modifier
            .padding(16.dp)
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
                modifier = Modifier.width(with(LocalDensity.current){ buttonWidth.toDp()}),
            ) {
                menuItemData.forEach { option ->
                    DropdownMenuItem(
                        modifier = Modifier
                            //.border(width = 1.dp, color = Color.Black, shape = RectangleShape)
                            .background(Color.White),
                        text = { Text(option, fontSize = 18.sp) },
                        onClick = { /* Do something... */ }
                    )
                }
            }
        }
    }
}