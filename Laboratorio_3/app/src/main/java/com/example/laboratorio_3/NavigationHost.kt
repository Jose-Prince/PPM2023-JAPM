package com.example.laboratorio_3

import Diseño22
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.laboratorio_3.Items_menu.*
import com.example.laboratorio_3.screens.FragmentsAniversary.Diseño5
import com.example.laboratorio_3.screens.FragmentsAniversary.Diseño6
import com.example.laboratorio_3.screens.FragmentsAniversary.Diseño7
import com.example.laboratorio_3.screens.FragmentsAniversary.Diseño8
import com.example.laboratorio_3.screens.FragmentsBirthday.Diseño10
import com.example.laboratorio_3.screens.FragmentsBirthday.Diseño11
import com.example.laboratorio_3.screens.FragmentsBirthday.Diseño12
import com.example.laboratorio_3.screens.FragmentsBirthday.Diseño9
import com.example.laboratorio_3.screens.FragmentsHalloween.Diseño1
import com.example.laboratorio_3.screens.FragmentsHalloween.Diseño2
import com.example.laboratorio_3.screens.FragmentsHalloween.Diseño3
import com.example.laboratorio_3.screens.FragmentsHalloween.Diseño4
import com.example.laboratorio_3.screens.FragmentsMother.Diseño18
import com.example.laboratorio_3.screens.FragmentsMother.Diseño19
import com.example.laboratorio_3.screens.FragmentsMother.Diseño20
import com.example.laboratorio_3.screens.FragmentsMother.Diseño21
import com.example.laboratorio_3.screens.FragmentsXmas.Diseño23
import com.example.laboratorio_3.screens.FragmentsXmas.Diseño24
import com.example.laboratorio_3.screens.FragmentsXmas.Diseño25

@Composable
fun NavigationHost(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Principal.ruta,
        ){
        composable (Principal.ruta){
            Principal
        }
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

        composable (Pantalla5.ruta){
            Diseño5()
        }
        composable (Pantalla6.ruta){
            Diseño6()
        }
        composable (Pantalla7.ruta){
            Diseño7()
        }
        composable (Pantalla8.ruta){
            Diseño8()
        }

        composable (Pantalla9.ruta){
            Diseño9()
        }
        composable (Pantalla10.ruta){
            Diseño10()
        }
        composable (Pantalla11.ruta){
            Diseño11()
        }
        composable (Pantalla12.ruta){
            Diseño12()
        }

        composable (Pantalla18.ruta){
            Diseño18()
        }
        composable (Pantalla19.ruta){
            Diseño19()
        }
        composable (Pantalla20.ruta){
            Diseño20()
        }
        composable (Pantalla21.ruta){
            Diseño21()
        }

        composable (Pantalla22.ruta){
            Diseño22()
        }
        composable (Pantalla23.ruta){
            Diseño23()
        }
        composable (Pantalla24.ruta){
            Diseño24()
        }
        composable (Pantalla25.ruta){
            Diseño25()
        }


    }
}