package database

class Libro(
    override var nombre: String,
    override var autor: String,
    override var genre: String,
    var pags: Int,
    var editorial: String
    ) : Entretenimiento() {
}