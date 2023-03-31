package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class HistoriaBase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia_base)

        val iv_regresar: ImageView = findViewById(R.id.ivRegresarHistoria)

        iv_regresar.setOnClickListener {
            var intent: Intent= Intent(this,HistoriaInfo::class.java)
            startActivity(intent)
        }

        val btn_lectura: Button = findViewById(R.id.btnLectura)

        btn_lectura.setOnClickListener {
            var intent: Intent= Intent(this,PopUpVoz::class.java)
            startActivity(intent)
        }

        val btn_configuracion: Button = findViewById(R.id.btnConfiguracion)

        btn_configuracion.setOnClickListener {
            var intent: Intent= Intent(this,PopUpLectura::class.java)
            startActivity(intent)
        }
    }
}