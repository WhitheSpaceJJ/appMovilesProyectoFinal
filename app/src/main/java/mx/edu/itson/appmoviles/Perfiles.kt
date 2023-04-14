package mx.edu.itson.appmoviles

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class Perfiles : AppCompatActivity() {
    var perfiles: ArrayList<PerfilUsuario> = ArrayList<PerfilUsuario>()
    var adapter:PerfilAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfiles)
        agregarPerfiles()
        adapter = PerfilAdapter(this, perfiles)
        var listView: GridView = findViewById(R.id.grvperfiles)
        listView.adapter=adapter
        /*
        val agregar_perfil: ImageView = findViewById(R.id.iv_agregar_perfil)
        agregar_perfil.setOnClickListener{
            var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            startActivity(intent)
        }


        val Perfil1: ImageView = findViewById(R.id.iv_perfil_1)
        val Perfil2: ImageView = findViewById(R.id.iv_perfil_2)
        val Perfil3: ImageView = findViewById(R.id.iv_perfil_3)
        val agregar_perfil: ImageView = findViewById(R.id.iv_agregar_perfil)

        Perfil1.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        Perfil2.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        Perfil3.setOnClickListener{
            var intent: Intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }

        agregar_perfil.setOnClickListener{
            var intent: Intent = Intent(this, ConfigurarPerfil::class.java)
            startActivity(intent)
        }
 */
    }
    private fun agregarPerfiles() {
        perfiles.add(PerfilUsuario("Agregar Perfil",0,R.drawable.agregar))
        perfiles.add(PerfilUsuario("jose",21,R.drawable.perfiloficial1))
        perfiles.add(PerfilUsuario("giovanni",37,R.drawable.perfiloficial2))
        perfiles.add(PerfilUsuario("josegiovanni",58,R.drawable.perfiloficial3))
    }
    class PerfilAdapter : BaseAdapter {
        var context: Context? = null
        var catalogo = ArrayList<PerfilUsuario>()

        constructor(context: Context, catalogo: ArrayList<PerfilUsuario>) {
            this.context = context
            this.catalogo = catalogo
        }

        override fun getCount(): Int {
            return catalogo.size
        }

        override fun getItem(p0: Int): Any {
            return catalogo[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var perfil = catalogo[p0]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            // Si el perfil es una imagen, inflar la vista imagen
            if (p0== 0) {
                var vista2 = inflator.inflate(R.layout.perfil_item, null)
                var imagen: ImageView = vista2.findViewById(R.id.ivperfil)
                imagen.setImageResource(R.drawable.agregar)
                var imagenFondo: ImageView = vista2.findViewById(R.id.ivperfilfondo)
                var txv:TextView=vista2.findViewById(R.id.tvperfilnombre)
                txv.setText(perfil.nombre)
                imagenFondo.setImageResource(R.drawable.perfil4)
                imagenFondo.setOnClickListener {
                    var intento = Intent(context, ConfigurarPerfil::class.java)
                    context!!.startActivity(intento)
                }
                imagen.setOnClickListener {
                    var intento = Intent(context, ConfigurarPerfil::class.java)
                    context!!.startActivity(intento)
                }
                return vista2
            }
            else {
                var vista = inflator.inflate(R.layout.perfil_item, null)
                var imagen: ImageView = vista.findViewById(R.id.ivperfil)
                var txv:TextView=vista.findViewById(R.id.tvperfilnombre)
                txv.setText(perfil.nombre)
                if (perfil.imagen.equals(R.drawable.perfiloficial1)){
                    var imagenFondo: ImageView = vista.findViewById(R.id.ivperfilfondo)
                    imagenFondo.setImageResource(R.drawable.perfil1)
                }
                if (perfil.imagen.equals(R.drawable.perfiloficial2)){
                    var imagenFondo: ImageView = vista.findViewById(R.id.ivperfilfondo)
                    imagenFondo.setImageResource(R.drawable.perfil2)
                }
                if (perfil.imagen.equals(R.drawable.perfiloficial3)){
                    var imagenFondo: ImageView = vista.findViewById(R.id.ivperfilfondo)
                    imagenFondo.setImageResource(R.drawable.perfil3)
                }
                imagen.setImageResource(perfil.imagen)
                imagen.setOnClickListener {
                    var intento = Intent(context,Menu::class.java)
                    context!!.startActivity(intento)
                }
                return vista

            }
        }

    }
}