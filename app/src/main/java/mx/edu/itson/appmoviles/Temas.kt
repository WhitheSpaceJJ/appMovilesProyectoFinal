package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Temas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temas)

        val btn_listo : Button = findViewById(R.id.btn_listo)

        btn_listo.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}