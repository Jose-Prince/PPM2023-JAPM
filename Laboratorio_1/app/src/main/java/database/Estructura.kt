package database

class Estructura {
    var lista: ArrayList<Entretenimiento> = ArrayList<Entretenimiento>(1)

    fun addEntretenimiento(
        nombre: String, tipoEntretenimiento: String, autor: String,
        genero: String, duracion: Int?, estado: String, caps: Int?,
        estudio: String?, pags: Int?, editorial: String? ) {
        if (tipoEntretenimiento.equals("Pelicula")) {
            var newPeli: Entretenimiento = Pelicula(nombre, autor, genero, estado, duracion)
            lista.add(newPeli)
        } else if (tipoEntretenimiento.equals("manga")) {
            var newManga: Entretenimiento = Manga(nombre, autor, genero, estado, caps)
            lista.add(newManga)
        } else if (tipoEntretenimiento.equals("anime")) {
            var newAnime: Entretenimiento = Anime(nombre, autor, genero, estado, caps, estudio)
            lista.add(newAnime)
        } else if (tipoEntretenimiento.equals("libro")) {
            var newLibro: Entretenimiento = Libro(nombre, autor, genero, estado, pags, editorial)
            lista.add(newLibro)
        }
    }

    fun printEntretenimiento() : String {
        var display1 : String? = null
        var display2 : String? = null
        var display3 : String? = null
        var display4 : String? = null
        var pelis : String = "\nPeliculas: "
        for (elemento in lista){
            if (elemento is Pelicula) {
                display1 = "\n\nNombre: ${elemento.nombre} \nAutor: ${elemento.autor} " +
                        "\nGénero: ${elemento.genre} \nEstado: ${elemento.estado} \nDuración: ${elemento.duracion} min"
            }
        }
        var mangas : String = "\n\nMangas: "
        for (elemento in lista){
            if (elemento is Manga){
                display2 = "\n\nNombre: ${elemento.nombre} \nAutor: ${elemento.autor}" +
                        "\nGénero: ${elemento.genre} \nEstado: ${elemento.estado} \nCapítulos: ${elemento.caps}"
            }
        }
        var animes : String = "\n\nAnimes: "
        for (elemento in lista){
            if (elemento is Anime){
                display3 = "\n\nNombre: ${elemento.nombre} \nAutor: ${elemento.autor}" +
                        "\nGénero: ${elemento.genre} \nEstado: ${elemento.estado} " +
                        "\nCapítulos: ${elemento.caps} \nEstudio: ${elemento.estudio}"
            }
        }
        var libros : String = "\n\nLibros: "
        for (elemento in lista){
            if (elemento is Libro){
                display4 = "\n\nNombre: ${elemento.nombre} \nAutor: ${elemento.autor}" +
                        "\nGénero: ${elemento.genre} \nEstado: ${elemento.estado} " +
                        "\nPáginas: ${elemento.pags} \nEditorial: ${elemento.editorial}"
            }
        }
        return pelis + display1 + mangas + display2 + animes + display3 + libros + display4
    }

    fun modEstado() {

    }
}