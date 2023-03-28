package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class IniciarSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)


        val button: Button = findViewById(R.id.btn_iniciar_sesion)

        button.setOnClickListener{
        var intent: Intent = Intent(this, Menu::class.java)
        startActivity(intent)
    }
}

}