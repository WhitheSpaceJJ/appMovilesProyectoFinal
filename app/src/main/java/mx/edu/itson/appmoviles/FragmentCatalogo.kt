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
                R.drawable.biblioteca1,
                "El regalo de la princesa",
                "aaa",
                "123",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa"
            )
        )
        catalogo.add(
            Historia(
                R.drawable.biblioteca2,
                "Ricitos de oro",
                "aaa",
                "123",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa"
            )
        )
        catalogo.add(
            Historia(
                R.drawable.biblioteca3,
                "Cenicienta",
                "aaa",
                "123",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa"
            )
        )
        catalogo.add(
            Historia(
                R.drawable.biblioteca4,
                "Rapunzel",
                "aaa",
                "123",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa"
            )
        )
        catalogo.add(
            Historia(
                R.drawable.animales,
                "La reina de las nieves",
                "aaa",
                "123",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa"
            )
        )
        catalogo.add(
            Historia(
                R.drawable.aventura,
                "Pinochio",
                "aaa",
                "123",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa"
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

            var imagen: ImageView = vista.findViewById(R.id.historia_imagen)

            imagen.setImageResource(historia.image)

            imagen.setOnClickListener {
                var intento = Intent(context, HistoriaInfo::class.java)

                intento.putExtra("image", historia.image)
                intento.putExtra("titulo", historia.titulo)
                intento.putExtra("autor", historia.autor)
                intento.putExtra("numPaginas", historia.numPaginas)
                intento.putExtra("sinopsis", historia.sinopsis)
                context!!.startActivity(intento)
            }
            return vista
        }
    }
}