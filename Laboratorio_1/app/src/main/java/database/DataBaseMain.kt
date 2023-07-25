package database

import java.util.Scanner

fun main() {

    val reader = Scanner(System.`in`)
    var opcion: Int


    var structure = Estructura()
    var ejecucion : Boolean = true
    var prueba : Boolean = true
    var duration : Int? = null
    var chapter : Int? = null
    var studio : String? = null
    var pages : Int? = null
    var editorial : String? = null

    println("Bienvenido al programa: ")

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
                print("\nNombre: ")
                var name = reader.nextLine()

                print("Autor: ")
                var author = reader.nextLine()

                print("Generos: ")
                var genre = reader.nextLine()

                print("Estado: ")
                var state = reader.nextLine()

                print("Tipo (Pelicula,Manga,etc): ")
                var type = reader.nextLine()

                if (type.equals("Pelicula")){

                    prueba = true
                    while (prueba) {
                        print("Duración: ")
                        try {
                            duration = reader.nextInt()
                            reader.nextLine()
                            prueba = false
                        } catch (e: Exception){
                            println("DURACIÓN INVÁLIDA")
                            reader.nextLine()
                        }
                    }

                } else if (type.equals("Manga")){
                    prueba = true
                    while (prueba) {
                        print("Número de capítulos: ")
                        try {
                            chapter = reader.nextInt()
                            reader.nextLine()
                            prueba = false
                        } catch (e: Exception) {
                            println("CAPITULOS INVÁLIDOS")
                            reader.nextLine()
                        }
                    }
                } else if (type.equals("Anime")){
                    prueba = true
                    while (prueba) {
                        print("Número de capítulos: ")
                        try {
                            chapter = reader.nextInt()
                            reader.nextLine()
                            prueba = false
                        } catch (e: Exception) {
                            println("CAPITULOS INVÁLIDOS")
                            reader.nextLine()
                        }
                    }
                    print("Estudio: ")
                    studio = reader.nextLine()
                } else if (type.equals("Libro")){
                    print("Número de páginas: ")
                    prueba = true
                    while (prueba) {
                        try {
                            pages = reader.nextInt()
                            reader.nextLine()
                            prueba = false
                        } catch (e: Exception) {
                            println("DURACION INVALIDA")
                            reader.nextLine()
                        }
                    }
                    print("Editorial: ")
                    editorial = reader.nextLine()
                }

                structure.addEntretenimiento(name,type,author,genre,duration,state,chapter,studio,pages,editorial)
            } else if (opcion == 2) {
                println(structure.showEntretenimiento());
            } else if (opcion == 3) {
                print("\nNombre: ")
                var name: String = reader.nextLine()
                print("Nuevo Estado: ")
                var newEstado : String = reader.nextLine()
                structure.modEstado(name,newEstado)
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