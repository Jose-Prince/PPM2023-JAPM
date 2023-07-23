package database

import java.util.Scanner

fun main() {

    val reader = Scanner(System.`in`)
    var opcion: Int

    var ejecucion : Boolean = true

    while(ejecucion){
        println("\n1: Añadir Película/Anime/Manga/Libro" +
                "\n2: Mostrar la base de datos" +
                "\n3: Modificar Película/Anime/Manga/Libro" +
                "\n4: Salir del programa")

        print("\nOpción: ")

        try {
            opcion = reader.nextInt()
            reader.nextLine()

            if (opcion == 1){

            } else if (opcion == 2) {

            } else if (opcion == 3) {

            } else if (opcion == 4) {
                println("\nSaliendo del programa...")
                ejecucion = false
            } else {
                println("\nINGRESE NÚMEROS DEL 1-4")
            }

        } catch (e: Exception){
            reader.nextLine()
            println("\nOpción Inválida")
        }

    }





}