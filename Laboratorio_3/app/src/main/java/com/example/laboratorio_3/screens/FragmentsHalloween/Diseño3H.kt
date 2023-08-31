package com.example.laboratorio_3.screens.FragmentsHalloween

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.laboratorio_3.R

@Composable
fun Diseño3() {
    Image(painter = painterResource(
        id = R.drawable.halloween3),
        contentDescription = null,
        modifier = Modifier.fillMaxSize())
}