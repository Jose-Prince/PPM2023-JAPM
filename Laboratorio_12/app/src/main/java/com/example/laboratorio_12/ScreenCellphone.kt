package com.example.laboratorio_12

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun screenCellphone(countries: List<Country>) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Planes de viaje",
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.size(60.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Añadir plan",
                    fontSize = 40.sp)
            }
        }
        Spacer(modifier = Modifier.size(60.dp))
        LazyColumn{
            items(countries) { item ->
                Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(id = item.image), contentDescription = null, modifier = Modifier.size(150.dp))
                    Text(text = item.name,
                        textAlign = TextAlign.Center,
                        fontSize = 35.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun prevphone() {
    //screenTablet(countries = listOf("Argentina", "Alemania","Estados Unidos","Emiratos Árabes", "España", "Chile"))
}