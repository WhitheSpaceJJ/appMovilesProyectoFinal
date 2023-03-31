package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

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
        val textViewTitulo: TextView = findViewById(R.id.txt_titulo)
        val butonconfiguracion: Button = findViewById(R.id.btnConfiguracion)
        val butonlectura: Button = findViewById(R.id.btnLectura)
        val butonRegresar: Button = findViewById(R.id.blRegresar)
        val btn_fin_lectura: Button = findViewById(R.id.btnFinLectura)
        val barraProgreso: ProgressBar = findViewById(R.id.barraHistoriaBase)
        val btn_diccionario: Button = findViewById(R.id.btnDiccionario)
        butonconfiguracion.visibility = View.VISIBLE
        butonRegresar.visibility = View.VISIBLE
        barraProgreso.visibility = View.VISIBLE
        btn_fin_lectura.visibility = View.VISIBLE
        butonlectura.visibility =View.VISIBLE
        btn_diccionario.visibility = View.INVISIBLE


        btn_diccionario.setOnClickListener {
            var intent2: Intent= Intent(this,PopUpDiccionario::class.java)
            startActivity(intent2)
            butonconfiguracion.visibility = View.VISIBLE
            butonRegresar.visibility = View.VISIBLE
            barraProgreso.visibility = View.VISIBLE
            btn_fin_lectura.visibility = View.VISIBLE
            butonlectura.visibility =View.VISIBLE
            btn_diccionario.visibility = View.INVISIBLE
        }
        textViewTitulo.setOnClickListener {
            butonconfiguracion.visibility = View.INVISIBLE
            butonRegresar.visibility = View.INVISIBLE
            barraProgreso.visibility = View.INVISIBLE
            btn_fin_lectura.visibility = View.INVISIBLE
            butonlectura.visibility = View.INVISIBLE
            btn_diccionario.visibility = View.VISIBLE
        }

        btn_fin_lectura.setOnClickListener {
            var intent: Intent= Intent(this,FinLectura::class.java)
            startActivity(intent)
        }

    }
}