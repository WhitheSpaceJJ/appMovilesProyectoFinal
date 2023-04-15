package mx.edu.itson.appmoviles

import java.io.Serializable

data class Usuario(
    var correoElectronico: String,
    var nombreUsuario: String,
    var contrasena: String,
    var temasFavoritos: ArrayList<String> = ArrayList(),
    var perfiles: ArrayList<PerfilUsuario> = ArrayList()
): Serializable
