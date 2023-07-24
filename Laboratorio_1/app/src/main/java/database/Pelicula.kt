package database

class Pelicula(
    override var nombre: String,
    override var autor: String,
    override var genre: String,
    override var estado: String,
    var duracion: Int?
    ) : Entretenimiento() {

}