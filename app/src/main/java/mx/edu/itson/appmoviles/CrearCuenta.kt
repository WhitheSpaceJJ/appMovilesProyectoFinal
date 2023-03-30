package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class CrearCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        val ivRegresar : ImageView = findViewById(R.id.ivRegresarCrear)

        ivRegresar.setOnClickListener{
            var intent: Intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }
    }
}