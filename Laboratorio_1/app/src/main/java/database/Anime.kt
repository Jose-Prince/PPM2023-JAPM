package database

class Anime(
    override var nombre: String,
    override var autor: String,
    override var genre: String,
    var caps : Int,
    var estudio: String,
    ) : Entretenimiento() {
}