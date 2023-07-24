package database

class Estructura : IEstructura{
    var lista: ArrayList<Entretenimiento> = ArrayList<Entretenimiento>()

    override fun addEntretenimiento(nombre: String, tipoEntretenimiento: String, autor: String,
                                    genero: String, duracion: Int?, estado: String, caps: Int?,
                                    estudio: String?, pags: Int?, editorial: String?) {
        if (tipoEntretenimiento.lowercase().equals("pelicula")) {
            var newPeli: Entretenimiento = Pelicula(nombre, autor, genero, estado, duracion)
            lista.add(newPeli)
        } else if (tipoEntretenimiento.lowercase().equals("manga")) {
            var newManga: Entretenimiento = Manga(nombre, autor, genero, estado, caps)
            lista.add(newManga)
        } else if (tipoEntretenimiento.lowercase().equals("anime")) {
            var newAnime: Entretenimiento = Anime(nombre, autor, genero, estado, caps, estudio)
            lista.add(newAnime)
        } else if (tipoEntretenimiento.lowercase().equals("libro")) {
            var newLibro: Entretenimiento = Libro(nombre, autor, genero, estado, pags, editorial)
            lista.add(newLibro)
        }
    }

    override fun showEntretenimiento() : String {
        var display1 : String? = ""
        var display2 : String? = ""
        var display3 : String? = ""
        var display4 : String? = ""
        var pelis : String = "\nPeliculas: "
        for (elemento in lista){
            if (elemento is Pelicula) {
                display1 = "$display1 \n\nNombre: ${elemento.nombre} \nAutor: ${elemento.autor} " +
                        "\nGénero: ${elemento.genre} \nEstado: ${elemento.estado} \nDuración: ${elemento.duracion} min"
            }
        }
        var mangas : String = "\n\nMangas: "
        for (elemento in lista){
            if (elemento is Manga){
                display2 = "$display2 \n\nNombre: ${elemento.nombre} \nAutor: ${elemento.autor}" +
                        "\nGénero: ${elemento.genre} \nEstado: ${elemento.estado} \nCapítulos: ${elemento.caps}"
            }
        }
        var animes : String = "\n\nAnimes: "
        for (elemento in lista){
            if (elemento is Anime){
                display3 = "$display3 \n\nNombre: ${elemento.nombre} \nAutor: ${elemento.autor}" +
                        "\nGénero: ${elemento.genre} \nEstado: ${elemento.estado} " +
                        "\nCapítulos: ${elemento.caps} \nEstudio: ${elemento.estudio}"
            }
        }
        var libros : String = "\n\nLibros: "
        for (elemento in lista){
            if (elemento is Libro){
                display4 = "$display4 \n\nNombre: ${elemento.nombre} \nAutor: ${elemento.autor}" +
                        "\nGénero: ${elemento.genre} \nEstado: ${elemento.estado} " +
                        "\nPáginas: ${elemento.pags} \nEditorial: ${elemento.editorial}"
            }
        }
        return pelis + display1 + mangas + display2 + animes + display3 + libros + display4
    }

    override fun modEstado(nombre: String, estado: String) {
        for (elemento in lista){
            var nombreC : String = elemento.nombre
            if (nombre.lowercase().trim().equals(nombreC)){
                elemento.estado = estado
            }
        }
    }
}