package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics

class PopUpDiccionario: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up_diccionario)

        val medidasVentana: DisplayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(medidasVentana);

        var ancho: Int = medidasVentana.widthPixels;
        var alto: Int = medidasVentana.heightPixels

        window.setLayout((ancho*0.75).toInt(), (alto*0.35).toInt())

        val bundle4 = intent.extras!!
        var intent2: Intent = Intent(this,HistoriaBase::class.java)
        intent2.putExtra("image",bundle4.getInt("image"))
        intent2.putExtra("autor",bundle4.getString("autor"))
        intent2.putExtra("numPaginas",bundle4.getString("numPaginas"))
        intent2.putExtra("sinopsis",bundle4.getString("sinopsis"))
        startActivity(intent2)
    }
}