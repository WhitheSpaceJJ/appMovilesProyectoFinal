package mx.edu.itson.appmoviles

import java.io.Serializable

data class PerfilUsuario(
    val nombre: String,
    val edad: Int,
    val imagen: Int,
    var bibliotecaHistorias: ArrayList<Int> = ArrayList(),
    var porcentajes: ArrayList<Int> = ArrayList()
): Serializable
