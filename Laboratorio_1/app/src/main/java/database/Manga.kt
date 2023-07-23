package database

class Manga(
    override var nombre: String,
    override var autor: String,
    override var genre: String,
    var estado: String,
    var caps: Int
    ) : Entretenimiento() {
}