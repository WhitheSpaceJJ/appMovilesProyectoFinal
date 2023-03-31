package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class Configuracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        val btn_ayuda: Button = findViewById(R.id.buttonAyuda)
        val iv_regresar: ImageView = findViewById(R.id.ivRegresarConfiguracion)
        val btn_editar_perfil: Button = findViewById(R.id.btnEditarPerfil)
        val btn_cambiar_perfil: Button = findViewById(R.id.btnCambiarPerfil)



        btn_ayuda.setOnClickListener {
            var intent: Intent = Intent(this, Faq::class.java)
            startActivity(intent)
        }

        iv_regresar.setOnClickListener {
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)

        }
        btn_cambiar_perfil.setOnClickListener {
            var intent: Intent = Intent(this, Perfiles::class.java)
            startActivity(intent)

        }
        btn_editar_perfil.setOnClickListener {
            var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            startActivity(intent)

        }
    }

}