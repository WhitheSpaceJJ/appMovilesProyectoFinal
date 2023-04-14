package mx.edu.itson.appmoviles
data class Usuario(
    val correoElectronico: String,
    val nombreUsuario: String,
    val contrasena: String,
    val temasFavoritos: ArrayList<String> = ArrayList(),
    val perfiles: ArrayList<PerfilUsuario> = ArrayList()
)
