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

    object Pantalla18: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño18", "pantalla18")
    object Pantalla19: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño19", "pantalla19")
    object Pantalla20: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño20", "pantalla20")
    object Pantalla21: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño21", "pantalla21")


    object Pantalla22: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño18", "pantalla18")
    object Pantalla23: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño19", "pantalla19")
    object Pantalla24: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño20", "pantalla20")
    object Pantalla25: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño21", "pantalla21")

}
