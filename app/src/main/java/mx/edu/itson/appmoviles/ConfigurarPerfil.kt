package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ConfigurarPerfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar_perfil)


        val ivRegresar : ImageView = findViewById(R.id.ivRegresarConfigurarPerfil)

        ivRegresar.setOnClickListener{
            var intent: Intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }
    }
}