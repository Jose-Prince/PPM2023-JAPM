package com.example.laboratorio_3.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import com.example.laboratorio_3.Items_menu.*
import com.example.laboratorio_3.MainActivity
import com.example.laboratorio_3.NavigationHost
import com.example.laboratorio_3.R

class Halloween : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Run()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PantallaPrincipal() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val navigation_item = listOf(
        Pantalla1,
        Pantalla2,
        Pantalla3,
        Pantalla4
    )

    Scaffold(
        bottomBar = { NavegacionInferior(navController = navController, menu_items = navigation_item)}
    ) {
        NavigationHost(navController)
    }

}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}

@Composable
fun NavegacionInferior(
    navController : NavHostController,
    menu_items : List<Items_menu>
){
    BottomAppBar {
        BottomNavigation {
            val currentRoute = currentRoute(navController = navController)
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

@Preview
@Composable
fun MesssageHPreview(showBackground: Boolean = true) {
    Run()
}

@Composable
fun Run(){
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        PantallaPrincipal()

        Box(){
            IconButton(onClick = {val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)},
                modifier = Modifier.size(60.dp)) {
                androidx.compose.material3.Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "",
                    modifier = Modifier.size(60.dp))
            }
        }
    }
}


