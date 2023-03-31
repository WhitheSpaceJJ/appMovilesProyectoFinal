package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Actividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad)

        val iv_cerrar_actividad: ImageView = findViewById(R.id.ivCerrarActividad)

        iv_cerrar_actividad.setOnClickListener {
            var intent: Intent = Intent(this,Menu::class.java)
            startActivity(intent)
        }
    }
}