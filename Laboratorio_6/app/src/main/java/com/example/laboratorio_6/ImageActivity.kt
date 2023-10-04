package com.example.laboratorio_6

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.laboratorio_6.ui.theme.Laboratorio_6Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var nombreCiudad : String? = null
            val intent = intent
            if (intent.hasExtra("Nombre")) {
                nombreCiudad = intent.getStringExtra("Nombre")
            }



            Laboratorio_6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (nombreCiudad != null) {
                        imageView(nombreCiudad)
                    }
                }
            }
        }
    }
}

@Composable
fun imageView(nombreCiudad : String) {
    var isLoading by remember { mutableStateOf(true) }
    var link by remember { mutableStateOf("") }

    LaunchedEffect(key1 = Unit) {
        link = fetchImage(nombreCiudad)
        isLoading = false
    }

    val context = LocalContext.current

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        IconButton(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Regresar",
                modifier = Modifier.size(50.dp),
                tint = Color.Black
            )
        }
        Text(text = nombreCiudad, modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.size(15.dp))

        if (!isLoading) {
            ImageFromUrl(url = link)
        }
    }
}

suspend fun fetchImage(cityName: String?) : String {
    return withContext(Dispatchers.IO) {
        val urlObj = URL("https://api.teleport.org/api/urban_areas/slug:${cityName?.lowercase()}/images/")
        val conexion = urlObj.openConnection() as HttpURLConnection

        try {
            conexion.requestMethod = "GET"

            val respuesta = StringBuilder()
            val reader = BufferedReader(InputStreamReader(conexion.inputStream))
            var linea : String?
            while (reader.readLine().also { linea = it } != null) {
                respuesta.append(linea).append("\n")
            }

            var link = respuesta.toString()
            link = link.substringAfter("web\":\"")
            link = link.substringBefore("\"}}]}")
            reader.close()

            return@withContext link
        } finally {
            conexion.disconnect()
        }
    }
}

@Composable
fun ImageFromUrl(url: String, modifier: Modifier = Modifier.fillMaxSize()) {
    val painter = rememberImagePainter(
        data = url,
        builder = {
            crossfade(true)
            placeholder(R.drawable.baseline_downloading_24)
            error(R.drawable.baseline_cancel_24)
        }
    )
    Image(painter = painter
        , contentDescription = null,
        modifier = modifier)
}