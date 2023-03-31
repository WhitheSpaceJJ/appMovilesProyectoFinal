package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class HistoriaInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia_info)

        val iv_iamgen_historia: ImageView = findViewById(R.id.iv_historia_imagen)
        val tv_titulo_historia: TextView = findViewById(R.id.tv_titulo_historia)
        val tv_autor_historia: TextView = findViewById(R.id.tv_autor_historia)
        val tv_paginas_historia: TextView = findViewById(R.id.tv_total_paginas_historia)
        val tv_sinopsis_historia: TextView = findViewById(R.id.tv_psinopsis_historia)
        val bundle = intent.extras

        if(bundle!=null){
            iv_iamgen_historia.setImageResource(bundle.getInt("image"))
            tv_titulo_historia.setText(bundle.getString("titulo"))
            tv_autor_historia.setText(bundle.getString("autor"))
            tv_paginas_historia.setText(bundle.getString("numPaginas"))
            tv_sinopsis_historia.setText(bundle.getString("sinopsis"))
        }
        val imageView: ImageView=findViewById(R.id.imageView4Play)
        imageView.setOnClickListener{
            var intent: Intent = Intent(this, HistoriaBase::class.java)
            startActivity(intent)
        }
        val imageViewRegresar: ImageView=findViewById(R.id.imageView4Play)
        imageViewRegresar.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}

