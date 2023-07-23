package com.example.anylist

fun main() {
    val lista: List<Any?> = listOf("Hola",5,null,"apartamento",true)

    processList(lista)
}

fun processList(lista: List<Any?>) {
    for (elemento in lista){
        if (elemento is String){
            println(elemento)
            println("type=cadena")
            var size: Int = elemento.length
            println("info=L$size\n")
        } else if (elemento is Int){
            println(elemento)
            println("type=entero")
            if (elemento % 10 == 0){
                println("info=M10\n")
            } else if (elemento % 5 == 0){
                println("info=M5\n")
            } else if (elemento % 2 == 0) {
                println("info=M2\n")
            } else {
                println("info=null\n")
            }
        } else if (elemento is Boolean){
            println(elemento)
            println("type=booleano")
            if (elemento == true){
                println("info=Verdadero\n")
            } else {
                println("info=Falso\n")
            }
        }else if(elemento == null) {

        }else {
            println(elemento)
            println("type=null")
            println("info=null\n")

        }
    }
}