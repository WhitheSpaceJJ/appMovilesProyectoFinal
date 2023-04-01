package mx.edu.itson.appmoviles

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible


class HistoriaBase : AppCompatActivity(), View.OnClickListener {

    var tv_texto_historia: TextView? = null
    var btn_configuracion_historia: Button? = null
    var btn_regresar_lectura: Button? = null
    var btn_siguiente_lectura: Button? = null
    var pb_progreso: ProgressBar? = null
    var btn_diccionario: Button? = null
    var btn_escuchar_historia: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia_base)

        tv_texto_historia = findViewById(R.id.tvTextoHistoria)
        btn_configuracion_historia = findViewById(R.id.btnConfiguracionHistoria)
        btn_regresar_lectura = findViewById(R.id.btnRegresarLectura)
        btn_siguiente_lectura = findViewById(R.id.btnSiguienteLectura)
        pb_progreso = findViewById(R.id.pbHistoriaBase)
        btn_diccionario = findViewById(R.id.btnDiccionarioHistoria)
        btn_escuchar_historia = findViewById(R.id.btnEscucharHistoria)

        val iv_regresar_historia: ImageView = findViewById(R.id.ivRegresarHistoria)

        iv_regresar_historia.setOnClickListener {
            var intent: Intent = Intent(this, HistoriaInfo::class.java)
            startActivity(intent)
        }

        btn_escuchar_historia?.setOnClickListener {
            var intent: Intent = Intent(this, PopUpVoz::class.java)
            startActivity(intent)
        }

        btn_configuracion_historia?.setOnClickListener {
            var intent: Intent = Intent(this, PopUpLectura::class.java)
            startActivity(intent)
        }

        btn_diccionario?.setOnClickListener {
            var intent: Intent = Intent(this, PopUpDiccionario::class.java)
            startActivity(intent)
        }


    }


    override fun onClick(view: View) {

        when(view.id){
            R.id.tvTextoHistoria ->{
                if(btn_diccionario?.isInvisible== true){
                    btn_regresar_lectura?.visibility = View.INVISIBLE
                    pb_progreso?.visibility = View.INVISIBLE
                    btn_siguiente_lectura?.visibility = View.INVISIBLE
                    btn_configuracion_historia?.visibility = View.INVISIBLE
                    btn_escuchar_historia?.visibility = View.INVISIBLE
                    btn_diccionario?.visibility = View.VISIBLE
                }else{
                    btn_regresar_lectura?.visibility = View.VISIBLE
                    pb_progreso?.visibility = View.VISIBLE
                    btn_siguiente_lectura?.visibility = View.VISIBLE
                    btn_configuracion_historia?.visibility = View.VISIBLE
                    btn_escuchar_historia?.visibility = View.VISIBLE
                    btn_diccionario?.visibility = View.INVISIBLE
                }
            }
        }
    }


}
