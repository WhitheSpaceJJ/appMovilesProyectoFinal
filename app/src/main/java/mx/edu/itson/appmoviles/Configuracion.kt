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
        var perfilFragment = FragmentPerfil()

        btn_ayuda.setOnClickListener {
            var intent: Intent = Intent(this, Faq::class.java)
            startActivity(intent)
        }

        iv_regresar.setOnClickListener {
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)

        }
    }

}