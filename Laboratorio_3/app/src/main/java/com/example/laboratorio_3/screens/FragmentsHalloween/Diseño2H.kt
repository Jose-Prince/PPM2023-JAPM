package com.example.laboratorio_3.screens.FragmentsHalloween

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio_3.R

@Composable
fun Diseño2() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.halloween2),
            contentDescription = null
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField2Message()
        }
    }
}

@Preview
@Composable
fun Diseño2Preview() {
    Diseño2()
}

@Composable
fun TextField2Message() {
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

