package database

class Estructura {
    var lista: ArrayList<Entretenimiento> = ArrayList<Entretenimiento>(1)

    fun addEntretenimiento(
        nombre: String, tipoEntretenimiento: String, autor: String,
        genero: String, duracion: Int?, estado: String, caps: Int?,
        estudio: String?, pags: Int?, editorial: String? ) {
        if (tipoEntretenimiento.equals("pelicula")) {
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

    fun printEntretenimiento() {

    }

    fun modEntretenimiento() {

    }
}