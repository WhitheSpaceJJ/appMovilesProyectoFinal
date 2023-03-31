package mx.edu.itson.appmoviles

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//FragmentBuscar : Fragment(R.layout.fragment_buscar) {
class FragmentCatalogo : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    var catalogo: ArrayList<Historia> = ArrayList<Historia>()
    var adapter: HistoriaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_catalogo, container, false)
        agregarHistorias()
        adapter = HistoriaAdapter(view.context, catalogo)
        var listView: GridView = view.findViewById(R.id.catalogo)
        listView.adapter=adapter
        return view
    }

    private fun agregarHistorias() {
        catalogo.add(
            Historia(
                R.drawable.regaloprincesa,
                "El regalo de la princesa",
                "Pepe aguilar",
                "12","Érase una vez una pequeña princesa que al cumplir los diez años tuvo una fantástica\n" +
                        "fiesta. Había músicos, flores, helado de fresa y pasteles con glaseado rosa. Los\n" +
                        "invitados trajeron los más maravillosos regalos.",
                ArrayList<String>(),ArrayList<Int>(),ArrayList<String>()
            )
        )
        catalogo.add(
            Historia(
                R.drawable.cenicienta,
                "Cenicienta",
                "Maria Bonita",
                "13",
                "Érase una vez una hermosa joven que vivía con su madrastra y dos hermanastras que\n" +
                        "la obligaban a hacer todo el trabajo de la casa. La pobre joven tenía que cocinar, limpiar\n" +
                        "y también lavarles la ropa.",
                ArrayList<String>(),ArrayList<Int>(),ArrayList<String>()
            )
        )
        catalogo.add(
            Historia(
                R.drawable.pinocho,
                "Pinocho",
                "Carlos Coyoli",
                "10",
                "Érase una vez un anciano carpintero llamado Gepeto que era muy feliz haciendo\n" +
                        "juguetes de madera para los niños de su pueblo.\n" +
                        "Un día, hizo una marioneta de una madera de pino muy especial y decidió llamarla\n" +
                        "Pinocho. En la noche, un hada azul llegó al taller del anciano carpintero:",
                ArrayList<String>(),ArrayList<Int>(),ArrayList<String>()
            )
        )
        catalogo.add(
            Historia(
                R.drawable.reinanieves,
                "La reina de las nieves",
                "Miguel angel",
                "9",
                "Había una vez un horripilante ogro que creó un gran espejo que hacía ver todo lo bueno\n" +
                        "y hermoso como feo y perverso. Era tanta su maldad, que hizo volar el espejo hasta lo\n" +
                        "más alto del espacio para dejarlo caer y quebrarse en millones de pequeños fragmentos\n" +
                        "de cristal en la Tierra. Si uno de esos fragmentos alcanzara los ojos de alguien, todo lo\n" +
                        "vería mal y si el fragmento se alojara en su corazón, este se volvería tan frío como el\n" +
                        "hielo.\n",
                ArrayList<String>(),ArrayList<Int>(),ArrayList<String>()
            )
        )

    }

    class HistoriaAdapter : BaseAdapter {
        var context: Context? = null
        var catalogo = ArrayList<Historia>()

        constructor(context: Context, catalogo: ArrayList<Historia>) {
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
            var historia = catalogo[p0]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.item_medalla_coleccionable_catalogo, null)

            var imagen: ImageView = vista.findViewById(R.id.imageView)

            imagen.setImageResource(historia.image)
            imagen.setOnClickListener {
                var intento = Intent(context, HistoriaInfo::class.java)
                intento.putExtra("image", historia.image)
                intento.putExtra("titulo", historia.titulo)
                intento.putExtra("autor", historia.autor)
                intento.putExtra("numPaginas", historia.numPaginas)
                intento.putExtra("sinopsis", historia.sinopsisi)
                context!!.startActivity(intento)
            }
            return vista
        }
    }
}