package com.example.laboratorio_6

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.laboratorio_6.ui.theme.Laboratorio_6Theme
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.Dispatchers



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var ciudades by remember { mutableStateOf(emptyList<String>())}
            Laboratorio_6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LaunchedEffect(key1 = Unit) {
                        val cities = fetchCities("https://api.teleport.org/api/urban_areas/")
                        ciudades = cities
                    }
                    Cities(ciudades)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CitiesPreview() {
    var ciudades by remember { mutableStateOf(emptyList<String>())}
    LaunchedEffect(key1 = Unit) {
        val cities = fetchCities("https://api.teleport.org/api/urban_areas/")
        ciudades = cities
    }
    Laboratorio_6Theme {
        Cities(ciudades)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cities(cities: List<String>){
    var text by remember { mutableStateOf("")}
    val context = LocalContext.current
    val state = rememberScrollState()
    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(state),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Cities", textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp), style = TextStyle(fontSize = 24.sp))
        Spacer(modifier = Modifier.size(20.dp))
        TextField(value = text, onValueChange = {text = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "City searcher")},
            placeholder = { Text(text = "Insert a name (Ex: Cairo)")})
        if (text.isNotBlank()){
            cities.forEach { city ->
                if (city.contains(text, ignoreCase = true)) {
                    Button(onClick = { val intent = Intent(context, ImageActivity::class.java)
                        intent.putExtra("Nombre", city)
                        context.startActivity(intent)},
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = city)
                    }
                }
            }
        } else {
            cities.forEach { city ->
                Button(onClick = { val intent = Intent(context, ImageActivity::class.java)
                    intent.putExtra("Nombre", city)
                    context.startActivity(intent)},
                    modifier = Modifier.fillMaxWidth()) {
                    Text(text = city)
                }
            }
        }
    }
}

suspend fun fetchCities(url: String): List<String> {
    return withContext(Dispatchers.IO) {
        val urlObject = URL(url)
        val conexion = urlObject.openConnection() as HttpURLConnection

        try {
            conexion.requestMethod = "GET"

            val respuesta = StringBuilder()
            val reader = BufferedReader(InputStreamReader(conexion.inputStream))
            var linea: String?
            while (reader.readLine().also { linea = it } != null) {
                respuesta.append(linea).append("\n")
            }
            reader.close()

            val lista = respuesta.toString().split("{")
            val ciudades = mutableListOf<String>()

            val newList = lista.subList(16, lista.size)

            for (i in newList) {
                val nombre = i.substringAfter("name\":\"")
                val ciudad = nombre.substringBefore("\"}")
                ciudades.add(ciudad)
            }

            return@withContext ciudades
        } finally {
            conexion.disconnect()
        }
    }
}