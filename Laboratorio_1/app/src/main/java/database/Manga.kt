package database

class Manga(
    override var nombre: String,
    override var autor: String,
    override var genre: String,
    override var estado: String,
    var caps: Int?
    ) : Entretenimiento() {
}