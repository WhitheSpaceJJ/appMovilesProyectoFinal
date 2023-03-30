package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ConfigurarPerfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar_perfil)


        val iv_regresar : ImageView = findViewById(R.id.iv_regresar_configurar_perfil)
        val btn_siguiente: Button = findViewById(R.id.btn_siguiente)

        iv_regresar.setOnClickListener{
            var intent: Intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }

        btn_siguiente.setOnClickListener{
            var intent: Intent = Intent(this, Temas::class.java)
            startActivity(intent)
        }
    }
}