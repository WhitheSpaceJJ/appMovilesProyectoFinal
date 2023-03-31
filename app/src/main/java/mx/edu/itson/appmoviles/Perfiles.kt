package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Perfiles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfiles)

        val Perfil1: ImageView = findViewById(R.id.iv_perfil_1)
        val Perfil2: ImageView = findViewById(R.id.iv_perfil_2)
        val Perfil3: ImageView = findViewById(R.id.iv_perfil_3)
        val agregar_perfil: ImageView = findViewById(R.id.iv_agregar_perfil)

        Perfil1.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        Perfil2.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        Perfil3.setOnClickListener{
            var intent: Intent = Intent(this, PopUpPrueba::class.java)
            startActivity(intent)
        }

        agregar_perfil.setOnClickListener{
            var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            startActivity(intent)
        }
    }
}