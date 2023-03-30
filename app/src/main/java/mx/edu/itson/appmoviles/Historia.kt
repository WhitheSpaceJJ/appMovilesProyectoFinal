package mx.edu.itson.appmoviles

data class Historia(var image:Int,
                    var titulo: String,
                    var autor: String,
                    var numPaginas: String,
                    var sinopsisi: String
                    ,
                    var generos: ArrayList<String>,
                    var imagenes: ArrayList<Int>
                    ,
                    var parrafos: ArrayList<String>
                    )
