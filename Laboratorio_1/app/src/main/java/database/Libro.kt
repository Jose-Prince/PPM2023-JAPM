package database

class Libro(
    override var nombre: String,
    override var autor: String,
    override var genre: String,
    override var estado: String,
    var pags: Int?,
    var editorial: String?
    ) : Entretenimiento() {
}