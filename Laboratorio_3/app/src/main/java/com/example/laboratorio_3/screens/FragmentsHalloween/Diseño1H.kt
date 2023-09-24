package com.example.laboratorio_3.screens.FragmentsHalloween

import android.content.res.Resources
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio_3.R

@Composable
fun Diseño1() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.halloween1),
            contentDescription = null
        )
        Box (modifier = Modifier.fillMaxSize()) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextFieldName()
                TextFieldMessage()
                Text(text = "Hola Mundo")
            }
        }
    }
}

@Preview
@Composable
fun DiseñoPreviewH() {
    Diseño1()
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextFieldName() {
    var text by remember { mutableStateOf("") }
    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter){
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
                    Text(text = "Nombre del destinatario",
                        fontSize = 35.sp)
                innerTextField.invoke()
            }
        )
    }
}

@Composable
fun TextFieldMessage() {
    var text by remember { mutableStateOf("") }
    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter){
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

