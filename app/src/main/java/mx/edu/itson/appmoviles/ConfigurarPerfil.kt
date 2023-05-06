package mx.edu.itson.appmoviles

import android.content.Intent
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
    var imagenesPerfil = ArrayList<Int>()
    var imagenPerfil: Int = 1
    var numPerfil=0

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
        cargarImgPerfiles()


        siguiente_imagen_perfil.setOnClickListener {
            imagenPerfil++
            if (imagenPerfil > (imagenesPerfil.size - 1)) {
                imagenPerfil = 0
            }

            imagen_perfil.setImageResource(imagenesPerfil.get(imagenPerfil))

        }

        anterior_imagen_perfil.setOnClickListener {
            imagenPerfil--
            if (imagenPerfil < 0) {
                imagenPerfil = 2
            }

            imagen_perfil.setImageResource(imagenesPerfil.get(imagenPerfil))
        }


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

            if (intent.hasExtra("uid")) {
                var uid = intent.getSerializableExtra("uid") as String

                validaPerfil(uid)

            }
        }
    }

    private fun validaPerfil(uid: String) {
        et_configura_nombre = findViewById(R.id.et_configura_nombre)
        et_configura_edad = findViewById(R.id.et_configurar_edad)

        var nombre: String = et_configura_nombre?.text.toString()
        var edad: String = et_configura_edad?.text.toString()


        if (!nombre.isNullOrBlank() && !edad.isNullOrBlank()) {
            agregarPerfilFirebase(nombre, edad, imagenPerfil, uid)
        } else {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun agregarPerfilFirebase(nombre: String, edad: String, imagen: Int, uid: String) {

        val perfiles = arrayListOf(
            PerfilUsuario(
                nombre = nombre,
                edad = edad.toInt(),
                imagen = imagen

            )
        )
        

        userRef.child(uid).child("perfiles").child(numPerfil.toString()).setValue(perfiles)


        val intent: Intent = Intent(this, Temas::class.java)
        intent.putExtra(
            "uid", uid
        )
        startActivity(intent)


    }

    fun cargarImgPerfiles() {
        imagenesPerfil.add(R.drawable.perfilfull1)
        imagenesPerfil.add(R.drawable.perfilfull2)
        imagenesPerfil.add(R.drawable.perfilfull3)
    }
}