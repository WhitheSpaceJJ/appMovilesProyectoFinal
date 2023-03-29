package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var imagen: ImageView = findViewById(R.id.imagen)

        imagen.setOnClickListener{
            var intento = Intent(this, IniciarSesion::class.java)
            this.startActivity(intento)
        }
    }
}