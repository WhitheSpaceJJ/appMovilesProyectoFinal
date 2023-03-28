package mx.edu.itson.appmoviles

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgLogo: ImageView = findViewById(R.id.img_logo_main)

        imgLogo.setOnClickListener{
            var intent: Intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }

    }
}