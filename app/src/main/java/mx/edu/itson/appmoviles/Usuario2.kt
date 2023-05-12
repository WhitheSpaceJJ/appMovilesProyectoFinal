package mx.edu.itson.appmoviles


data class Usuario2(
    var uid: String?=null,
    var correoElectronico: String?=null,
    var nombreUsuario: String?=null,



){
    override fun toString() = correoElectronico + "\t" +  "\t" + nombreUsuario + "\t"
}
