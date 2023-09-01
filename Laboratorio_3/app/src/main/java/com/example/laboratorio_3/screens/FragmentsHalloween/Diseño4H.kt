package com.example.laboratorio_3.screens.FragmentsHalloween

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio_3.R

@Composable
fun Diseño4() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.halloween4),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun Diseño4Preview() {
    Diseño4()
}