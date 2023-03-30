package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Perfiles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfiles)

        val Perfil1: ImageView = findViewById(R.id.ivPerfil1)
        val Perfil2: ImageView = findViewById(R.id.ivPerfil2)
        val Perfil3: ImageView = findViewById(R.id.ivPerfil3)

        Perfil1.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        Perfil2.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        Perfil3.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

    }
}