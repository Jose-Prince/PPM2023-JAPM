package com.example.laboratorio_3

sealed class Items_menu(
    val icon: Int,
    val title: String,
    val ruta: String
){
    object Principal: Items_menu(R.drawable.baseline_filter_1_24,
        "Principal", "Principal")
    object Pantalla1: Items_menu(R.drawable.baseline_filter_1_24,
        "Diseño1", "pantalla1")
    object Pantalla2: Items_menu(R.drawable.baseline_filter_2_24,
        "Diseño2", "pantalla2")
    object Pantalla3: Items_menu(R.drawable.baseline_filter_3_24,
        "Diseño3", "pantalla3")
    object Pantalla4: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño4", "pantalla4")

    object Pantalla5: Items_menu(R.drawable.baseline_filter_1_24,
        "Diseño5", "pantalla5")
    object Pantalla6: Items_menu(R.drawable.baseline_filter_2_24,
        "Diseño6", "pantalla6")
    object Pantalla7: Items_menu(R.drawable.baseline_filter_3_24,
        "Diseño7", "pantalla7")
    object Pantalla8: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño8", "pantalla8")

    object Pantalla9: Items_menu(R.drawable.baseline_filter_1_24,
        "Diseño9", "pantalla9")
    object Pantalla10: Items_menu(R.drawable.baseline_filter_2_24,
        "Diseño10", "pantalla10")
    object Pantalla11: Items_menu(R.drawable.baseline_filter_3_24,
        "Diseño11", "pantalla11")
    object Pantalla12: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño12", "pantalla12")

    object Pantalla18: Items_menu(R.drawable.baseline_filter_1_24,
        "Diseño18", "pantalla18")
    object Pantalla19: Items_menu(R.drawable.baseline_filter_2_24,
        "Diseño19", "pantalla19")
    object Pantalla20: Items_menu(R.drawable.baseline_filter_3_24,
        "Diseño20", "pantalla20")
    object Pantalla21: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño21", "pantalla21")


    object Pantalla22: Items_menu(R.drawable.baseline_filter_1_24,
        "Diseño22", "pantalla22")
    object Pantalla23: Items_menu(R.drawable.baseline_filter_2_24,
        "Diseño23", "pantalla23")
    object Pantalla24: Items_menu(R.drawable.baseline_filter_3_24,
        "Diseño24", "pantalla24")
    object Pantalla25: Items_menu(R.drawable.baseline_filter_4_24,
        "Diseño25", "pantalla25")

}
