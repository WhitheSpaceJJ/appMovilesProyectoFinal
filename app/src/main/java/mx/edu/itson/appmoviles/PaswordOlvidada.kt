package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PaswordOlvidada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pasword_olvidada)

        val btnChecar: Button = findViewById(R.id.btn_checar)

        btnChecar.setOnClickListener {
            //var intent: Intent = Intent(this, RestablecerPasword::class.java)
            //startActivity(intent)

            val et_usuario_contra_olvidada: EditText = findViewById(R.id.et_usuario_contra_olvidada)

            var usuario: String = et_usuario_contra_olvidada.text.toString()

            if (!usuario.isNullOrBlank()) {
                //enviarcorreo
            } else {
                Toast.makeText(this, "Ingrese usuario", Toast.LENGTH_SHORT).show()
            }
        }

        val ivRegresar: ImageView = findViewById(R.id.ivRegresarPass)

        ivRegresar.setOnClickListener {
            var intent: Intent = Intent(this, IniciarSesion::class.java)
            startActivity(intent)
        }


    }
}