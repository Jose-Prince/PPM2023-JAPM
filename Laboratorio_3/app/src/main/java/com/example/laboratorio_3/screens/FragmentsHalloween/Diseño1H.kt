package com.example.laboratorio_3.screens.FragmentsHalloween

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio_3.R

@Preview
@Composable
fun Visualizacion() {
    Diseño1()
}

@Composable
fun Diseño1() {

    Box {
        Image(painter = painterResource(
            id = R.drawable.halloween1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize())

        Box (modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter){
            var inputvalue = remember { mutableStateOf(TextFieldValue) }
            Column {
                Spacer(modifier = Modifier.height(80.dp))
                TextFieldNombre()
                Spacer(modifier = Modifier.height(520.dp))
                TextFieldMessage()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldNombre() {
    var inputvalue by remember { mutableStateOf("") }

    TextField(
        value = inputvalue,
        onValueChange = {inputvalue = it},
        placeholder = { Text(text = "Nombre del destinatario",
            color = Color.White,
            textAlign = TextAlign.Right,
            fontSize = 30.sp)},
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(R.color.white),
            textColor = Color.White)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldMessage() {
    var inputvalue by remember { mutableStateOf("") }

    TextField(
        value = inputvalue,
        onValueChange = {inputvalue = it},
        placeholder = { Text(text = "Mensaje",
            color = Color.White,
            textAlign = TextAlign.Center)},
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(R.color.white),
            textColor = Color.White)
    )
}