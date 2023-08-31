package com.example.laboratorio_3

sealed class Items_menu(
    val icon: Int,
    val title: String,
    val ruta: String
){
    object Pantalla1: Items_menu(R.drawable.baseline_filter_1_24,
        "Diseño1", "pantalla1")
    object Pantalla2: Items_menu(R.drawable.baseline_filter_2_24,
        "Diseño2", "pantalla2")
    object Pantalla3: Items_menu(R.drawable.baseline_filter_3_24,
        "Diseño3", "pantalla3")
    object Pantalla4: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño4", "pantalla4")
}
