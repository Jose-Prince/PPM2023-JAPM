package database

interface IEstructura {
    fun addEntretenimiento(nombre: String, tipoEntretenimiento: String, autor: String,
                                  genero: String, duracion: Int?, estado: String, caps: Int?,
                                  estudio: String?, pags: Int?, editorial: String?)

    fun showEntretenimiento() : String

    fun modEstado(nombre: String, estado: String)
}