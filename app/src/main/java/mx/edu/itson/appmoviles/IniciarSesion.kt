package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class IniciarSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)


        val btnIniciarSesion: Button = findViewById(R.id.btn_iniciar_sesion)
        val tvolvide_Pass: TextView = findViewById(R.id.tvOlvidePass)
        val btnRegistrase: Button = findViewById(R.id.btn_registrarse)

        btnIniciarSesion.setOnClickListener{
        var intent: Intent = Intent(this, Menu::class.java)
        startActivity(intent)
    }

        tvolvide_Pass.setOnClickListener {
            var intent: Intent = Intent(this, PaswordOlvidada::class.java)
            startActivity(intent)
        }

        btnIniciarSesion.setOnClickListener{
            var intent: Intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }
}

}