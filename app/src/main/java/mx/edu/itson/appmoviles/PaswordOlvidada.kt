package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class PaswordOlvidada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pasword_olvidada)

        val btnChecar: Button = findViewById(R.id.btn_checar_contra_olvidada)

        btnChecar.setOnClickListener{
            var intent: Intent = Intent(this, RestablecerPasword::class.java)
            startActivity(intent)
        }

        val ivRegresar : ImageView = findViewById(R.id.ivRegresarPass)

        ivRegresar.setOnClickListener{
            var intent: Intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }


    }
}