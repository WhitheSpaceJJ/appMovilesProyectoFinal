package mx.edu.itson.appmoviles

import java.io.Serializable

data class Usuario(
    var uid: String?=null,
    var correoElectronico: String?=null,
    var nombreUsuario: String?=null,
    var perfiles: ArrayList<PerfilUsuario> = ArrayList(),
    var temasFavoritos: ArrayList<String> = ArrayList()

): Serializable
