package mx.edu.itson.appmoviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.database.FirebaseDatabase

class Temas : AppCompatActivity() {

    var uid: String?=null
    var numPerfil: String? =null
    var temasFavoritos = ArrayList<String>()

    private var userRef = FirebaseDatabase.getInstance().getReference("usuarios")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temas)

        uid = intent.getSerializableExtra("uid") as String
        numPerfil = intent.getSerializableExtra("numPerfil") as String


        val btn_listo : Button = findViewById(R.id.btn_listo)
        val btn_regresar : ImageView = findViewById(R.id.btn_regresar)

        btn_listo.setOnClickListener{

            userRef.child(uid!!).child("perfiles").child(numPerfil!!).child("temasFavoritos").setValue(temasFavoritos)

            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
        btn_regresar.setOnClickListener{
            //uid = intent.getSerializableExtra("uid") as String
            var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            intent.putExtra("uid", uid)
            startActivity(intent)
        }
    }

    fun agregaCategoria (view: View){

        when(view.id){
            R.id.btn_deportes -> temasFavoritos.add("Deportes")
            R.id.btn_animales -> temasFavoritos.add("Animales")
            R.id.btn_magia -> temasFavoritos.add("Magia")
            R.id.btn_videojuegos -> temasFavoritos.add("Videojuegos")
            R.id.btn_musical -> temasFavoritos.add("musical")
            R.id.btn_aventuras -> temasFavoritos.add("aventuras")
        }
    }
}