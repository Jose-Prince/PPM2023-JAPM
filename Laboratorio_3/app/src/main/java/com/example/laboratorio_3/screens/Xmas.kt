package com.example.laboratorio_3.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio_3.Items_menu
import com.example.laboratorio_3.MainActivity
import com.example.laboratorio_3.NavigationHost
import com.example.laboratorio_3.R

class Xmas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                RunChristmass()
            }
        }
    }
}

@Preview
@Composable
fun MesssageXyPreview(showBackground: Boolean = true) {
    RunChristmass()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaPrincipalXmas() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navigation_item = listOf(
        Items_menu.Pantalla22,
        Items_menu.Pantalla23,
        Items_menu.Pantalla24,
        Items_menu.Pantalla25
    )

    Scaffold(
        bottomBar = { NavegacionInferiorChristmass(navController = navController, menu_items = navigation_item)}
    ) {
        NavigationHost(navController)
    }


}
@Composable
fun NavegacionInferiorChristmass(
    navController : NavHostController,
    menu_items : List<Items_menu>
){
    BottomAppBar {
        BottomNavigation {
            val currentRoute = currentRouteXmas(navController = navController)
            menu_items.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.ruta,
                    onClick = { navController.navigate(item.ruta) },
                    icon = { Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title) })
            }
        }
    }
}

@Composable
fun RunChristmass(){
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        PantallaPrincipalXmas()

        Box(){
            IconButton(onClick = {val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)},
                modifier = Modifier.size(60.dp)) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "",
                    modifier = Modifier.size(60.dp))
            }
        }
    }
}

@Composable
fun currentRouteXmas(navController: NavHostController): String? {
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}


