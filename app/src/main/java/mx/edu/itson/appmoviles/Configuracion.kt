package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Configuracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        val btn_ayuda: Button = findViewById(R.id.buttonAyuda)

        btn_ayuda.setOnClickListener {
            var intent: Intent = Intent(this, Faq::class.java)
            startActivity(intent)
        }
    }
}