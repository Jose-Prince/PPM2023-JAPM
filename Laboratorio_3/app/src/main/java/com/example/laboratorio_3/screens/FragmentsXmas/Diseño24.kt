package com.example.laboratorio_3.screens.FragmentsXmas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio_3.R

@Composable
fun Diseño24() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.navidad3),
            contentDescription = null
        )
        Box (modifier = Modifier.fillMaxSize()) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextFieldNameX7()
                TextFieldMessageX7()
                Text(text = "Hola Mundo")
            }
        }
    }
}
@Preview
@Composable
fun PreviewDiseño24() {
    Column {
        Diseño24()
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextFieldNameX7() {
    var text by remember { mutableStateOf("") }
    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart){
        BasicTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            modifier = Modifier
                .background(Color.White),
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontSize = 35.sp),
            decorationBox = {innerTextField ->
                if (text.isEmpty())
                    Text(text = "Nombre y su descripcion ",
                        fontSize = 35.sp)
                innerTextField.invoke()
            }
        )
    }
}

@Composable
fun TextFieldMessageX7() {
    var text by remember { mutableStateOf("") }
    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterStart){
        BasicTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            modifier = Modifier
                .background(Color.White),
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontSize = 25.sp),
            decorationBox = {innerTextField ->
                if (text.isEmpty())
                    Text(text = "Mensaje",
                        fontSize = 25.sp)
                innerTextField.invoke()
            }
        )
    }
}