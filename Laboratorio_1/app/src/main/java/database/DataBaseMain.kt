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

                print("\nAutor: ")
                var author = reader.nextLine()

                print("\nGenero: ")
                var genre = reader.nextLine()

                print("\nEstado: ")
                var state = reader.nextLine()

                print("\nTipo (Pelicula,Manga,etc): ")
                var type = reader.nextLine()

                if (type.equals("Pelicula")){
                    print("\nDuracion: ")

                    prueba = true
                    while (prueba) {
                        try {
                            var duration = reader.nextInt()
                            reader.nextLine()
                            prueba = false
                        } catch (e: Exception){
                            println("DURACION INVALIDA")
                            reader.nextLine()
                        }
                    }

                } else if (type.equals("Manga")){
                    print("\nNúmero de capítulos: ")
                    prueba = true
                    while (prueba) {
                        try {
                            var chapter = reader.nextInt()
                            reader.nextLine()
                            prueba = false
                        } catch (e: Exception) {
                            println("DURACION INVALIDA")
                            reader.nextLine()
                        }
                    }
                } else if (type.equals("Anime")){
                    print("\nNúmero de capítulos: ")
                    prueba = true
                    while (prueba) {
                        try {
                            var chapter = reader.nextInt()
                            reader.nextLine()
                            prueba = false
                        } catch (e: Exception) {
                            println("DURACION INVALIDA")
                            reader.nextLine()
                        }
                    }
                    print("\nEstudio: ")
                    studio = reader.nextLine()
                } else if (type.equals("Libro")){
                    print("\nNúmero de páginas: ")
                    prueba = true
                    while (prueba) {
                        try {
                            var pages = reader.nextInt()
                            reader.nextLine()
                            prueba = false
                        } catch (e: Exception) {
                            println("DURACION INVALIDA")
                            reader.nextLine()
                        }
                    }
                    print("\nEditorial: ")
                    editorial = reader.nextLine()
                }

                structure.addEntretenimiento(name,type,author,genre,duration,state,chapter,studio,pages,editorial)
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