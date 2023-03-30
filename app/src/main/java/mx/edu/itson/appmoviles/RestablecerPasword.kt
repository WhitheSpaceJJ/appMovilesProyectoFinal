package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class RestablecerPasword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restablecer_pasword)


        val ivRegresar : ImageView = findViewById(R.id.ivRegresarRestablecer)

        ivRegresar.setOnClickListener{
            var intent: Intent = Intent(this, PaswordOlvidada::class.java)
            startActivity(intent)
        }
    }
}