package mx.edu.itson.appmoviles

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class ConfigurarPerfil : AppCompatActivity() {

    var et_configura_nombre: EditText? = null
    var et_configura_edad: EditText? = null

    //realtime database
    private var userRef = FirebaseDatabase.getInstance().getReference("usuarios")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar_perfil)

        val iv_regresar: ImageView = findViewById(R.id.iv_regresar_configurar_perfil)
        val btn_siguiente: Button = findViewById(R.id.btnSiguienteConfiPerfil)
        val mas_edad: ImageView = findViewById(R.id.ivMasEdad)
        val menos_edad: ImageView = findViewById(R.id.ivMenosEdad)
        val siguiente_imagen_perfil: ImageView = findViewById(R.id.ivSiguienteImgPerfil)
        val anterior_imagen_perfil: ImageView = findViewById(R.id.ivAnteriorImgPerfil)
        val imagen_perfil: ImageView = findViewById(R.id.ivImagenPerfil)


        mas_edad.setOnClickListener {
            et_configura_edad = findViewById(R.id.et_configurar_edad)
            var edadUser = et_configura_edad?.text.toString().toInt()
            edadUser++
            et_configura_edad?.setText(edadUser.toString())
        }

        menos_edad.setOnClickListener {
            et_configura_edad = findViewById(R.id.et_configurar_edad)
            var edadUser = et_configura_edad?.text.toString().toInt()
            edadUser--
            et_configura_edad?.setText(edadUser.toString())
        }

        iv_regresar.setOnClickListener {
            var intent: Intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }

        btn_siguiente.setOnClickListener {

            if (intent.hasExtra("usuario")) {
                var usuario2 = intent.getSerializableExtra("usuario") as Usuario

                validaPerfil(usuario2)

                var intent: Intent = Intent(this, Temas::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validaPerfil(usuario: Usuario) {
        et_configura_nombre = findViewById(R.id.et_configura_nombre)
        et_configura_edad = findViewById(R.id.et_configurar_edad)

        var nombre: String = et_configura_nombre?.text.toString()
        var edad: String = et_configura_edad?.text.toString()
        //var uid: String = usuario.uid.toString()

        if (!nombre.isNullOrBlank() && !edad.isNullOrBlank()) {
            agregarPerfilFirebase(nombre, edad, usuario)
        } else {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun agregarPerfilFirebase(nombre: String, edad: String, usuario: Usuario) {

        val uid = usuario.uid.toString()
        val tamPerfiles = usuario.perfiles.size-1

        val usuarioAux = Usuario(
            /*
            uid = uid,
            correoElectronico = usuario.correoElectronico.toString(),
            nombreUsuario = usuario.nombreUsuario.toString(),
            temasFavoritos = arrayListOf(
                /*
                "tecnología", "ciencia", "cultura"
                 ,"tecnología", "ciencia", "cultura"
                 */
            ),
            perfiles = arrayListOf(
                PerfilUsuario(
                    nombre, edad.toInt(), 0,
                    arrayListOf(0, 0, 0, 0),
                    arrayListOf(0, 0, 0, 0)
                )
            )*/


        )
        userRef.child(uid).child("perfiles").child(tamPerfiles.toString()).child("nombre").setValue(nombre)
        userRef.child(uid).child("perfiles").child(tamPerfiles.toString()).child("edad").setValue(edad)

        //userRef.child(usuario.uid.toString()).setValue(usuario)
        //database.child("users").child(userId).child("username").setValue(name)

    }
}