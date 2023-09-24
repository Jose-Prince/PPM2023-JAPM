package com.example.laboratorio_3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio_3.screens.Aniversary
import com.example.laboratorio_3.screens.Birthday
import com.example.laboratorio_3.screens.Halloween
import com.example.laboratorio_3.screens.Mother
import com.example.laboratorio_3.screens.Xmas
import com.example.laboratorio_3.ui.theme.Laboratorio_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Laboratorio_3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Process()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProgramPreview() {
    Laboratorio_3Theme {
        Process()
    }
}

@Composable
fun Process(modifier: Modifier = Modifier) {
    val options = listOf("Aniversario de bodas","Cumpleaños","Dia de las madres","Halloween","Navidad")
    var selectedItem by remember { mutableStateOf(options[0]) }
    val context = LocalContext.current
    Column (modifier = modifier) {
        Text(
            text = "Tarjetas de Felicitación",
            fontSize = 50.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = "Seleccione la actividad:",
            fontSize = 25.sp,
            lineHeight = 80.sp,
        )
        Spinner(options,"Seleccionar actividad"){
            selectedItem = it
        }

        Button(onClick = {
            if (selectedItem == "Aniversario de bodas"){
                val intent = Intent(context, Aniversary::class.java)
                context.startActivity(intent)
            } else if(selectedItem == "Cumpleaños") {
                val intent = Intent(context, Birthday::class.java)
                context.startActivity(intent)
            } else if(selectedItem == "Dia de las madres") {
                val intent = Intent(context, Mother::class.java)
                context.startActivity(intent)
            } else if(selectedItem == "Halloween") {
                val intent = Intent(context, Halloween::class.java)
                context.startActivity(intent)
            } else if(selectedItem == "Navidad") {
                val intent = Intent(context, Xmas::class.java)
                context.startActivity(intent)
            } else {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
        }) {
            Text(text = "Generar")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Spinner(list : List<String>,
             preselected : String,
             onSelectionChanged : (selection : String) -> Unit) {
    var selected by remember { mutableStateOf(preselected) }
    var expanded by remember { mutableStateOf(false) }

    Box {
        Column {
            OutlinedTextField(value = selected
                , onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = { Icon(Icons.Outlined.ArrowDropDown,null)},
                readOnly = true)
            DropdownMenu(modifier = Modifier.fillMaxWidth(),
                expanded = expanded,
                onDismissRequest = { expanded = false },) {
                list.forEach {
                    entry -> DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                    text = { Text(text = entry, modifier = Modifier
                        .wrapContentWidth()
                        .align(Alignment.Start)) },
                    onClick = {
                        selected = entry
                        expanded = false
                        onSelectionChanged(entry)})}
            }
        }

        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .padding(10.dp)
                .clickable(onClick = { expanded = !expanded })
        )
    }
}