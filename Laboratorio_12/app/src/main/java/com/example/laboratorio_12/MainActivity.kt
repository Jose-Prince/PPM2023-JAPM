package com.example.laboratorio_12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio_12.ui.theme.Laboratorio_12Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio_12Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AdaptativeLayout()
                }
            }
        }
    }
}
//Función que adapta el layout
@Composable
fun AdaptativeLayout() {
    val listCountries = listOf(Country("Argentina", R.drawable.argentina), Country("Venezuela", R.drawable.venezuela), Country("Guatemala", R.drawable.guatemala),
        Country("Alemania", R.drawable.alemania), Country("Japón", R.drawable.jap_n), Country("Estados Unidos", R.drawable.estados_unidos),
        Country("Emiratos Árabes", R.drawable.emiratos__rabes), Country("España", R.drawable.espa_a), Country("Chile", R.drawable.chile))
    val screenSize = LocalConfiguration.current.screenWidthDp

    if (screenSize < 600) {
        screenCellphone(listCountries)
    } else {
        screenTablet(listCountries)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio_12Theme {
        AdaptativeLayout()
    }
}