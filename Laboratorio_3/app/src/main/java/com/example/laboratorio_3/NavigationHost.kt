package com.example.laboratorio_3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.laboratorio_3.Items_menu.*
import com.example.laboratorio_3.screens.FragmentsHalloween.Diseño1
import com.example.laboratorio_3.screens.FragmentsHalloween.Diseño2
import com.example.laboratorio_3.screens.FragmentsHalloween.Diseño3
import com.example.laboratorio_3.screens.FragmentsHalloween.Diseño4

@Composable
fun NavigationHost(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Pantalla1.ruta,
        ){
        composable (Pantalla1.ruta){
            Diseño1()
        }
        composable (Pantalla2.ruta){
            Diseño2()
        }
        composable (Pantalla3.ruta){
            Diseño3()
        }
        composable (Pantalla4.ruta){
            Diseño4()
        }
    }
}