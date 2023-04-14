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
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        agregarHistorias()
        /*
        adapter = HistoriaAdapter(view.context, catalogo)
        var listView: GridView = view.findViewById(R.id.catalogo)
        listView.adapter=adapter
    */
        // Obtén la referencia al RecyclerView desde el diseño XML
        val recyclerView: RecyclerView = view.findViewById(R.id.catalogo)

// Crea un GridLayoutManager para organizar los elementos en una cuadrícula de 2 columnas
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager

// Crea un adaptador personalizado que extienda de RecyclerView.Adapter, y pásalo al RecyclerView
        val adapter = HistoriaAdapter(requireContext(), catalogo)
        recyclerView.adapter = adapter

        return view
    }

    private fun agregarHistorias() {
        catalogo.add(
            Historia(
                R.drawable.regaloprincesa,
                "El regalo de la princesa",
                "Pepe Aguilar",
                "6",
                "Érase una vez una pequeña princesa que al cumplir los diez años tuvo una fantástica fiesta. Había músicos, flores, helado de fresa y pasteles con glaseado rosa. Los invitados trajeron los más maravillosos regalos. Pero entre todos los regalos, uno en particular llamó la atención de la princesa. Era una caja pequeña, envuelta en papel dorado y con un lazo rojo. La princesa abrió la caja con cuidado y dentro encontró un espejo mágico que podía concederle cualquier deseo. Sin embargo, la princesa sabía que con grandes poderes venían grandes responsabilidades.",
                arrayListOf("Aventura", "Fantasía", "Magia", "Princesas", "Amistad", "Crecimiento"),
                arrayListOf(R.drawable.princesa1,R.drawable.princesa2,R.drawable.princesa3,R.drawable.princesa4,R.drawable.princesa5,R.drawable.princesa6), // Imágenes no especificadas
                arrayListOf(
                    //6
                    "La princesa recibió muchos regalos en su fiesta de cumpleaños.",
                    "Uno de los regalos era una caja envuelta en papel dorado con un lazo rojo.",
                    "Dentro de la caja encontró un espejo mágico que podía concederle cualquier deseo.",
                    "La princesa sabía que con grandes poderes venían grandes responsabilidades.",
                    "La princesa aprendió a usar el espejo mágico con sabiduría y bondad.",
                    "La princesa vivió feliz para siempre con el espejo mágico a su lado."
                )
            ))
        catalogo.add(
            Historia(
                R.drawable.reinanieves,
                "Blancanieves",
                "Disney plus TV",
                "8",
                "Había una vez una reina que anhelaba tener una hija, y un día sus deseos se cumplieron con el nacimiento de una hermosa niña de piel blanca como la nieve, labios rojos como la sangre y cabello negro como el ébano. Pero la felicidad no duró mucho tiempo, ya que la reina falleció poco después del nacimiento de su hija. El rey se volvió a casar con una mujer vanidosa y cruel, quien poseía un espejo mágico al que preguntaba quién era la más hermosa del reino. Cuando el espejo respondió que Blancanieves lo era, la madrastra se enfureció y ordenó la muerte de la joven. Sin embargo, el cazador enviado para realizar la tarea se apiadó de Blancanieves y la dejó escapar. La joven llegó a un bosque, donde encontró refugio en una cabaña habitada por siete enanos. Pero la malvada madrastra descubrió que Blancanieves seguía viva y se disfrazó para envenenarla con una manzana. Afortunadamente, un príncipe la despertó de su sueño con un beso de amor verdadero y vivieron felices para siempre.",
                arrayListOf("Cuento de hadas", "Fantasía", "Aventura", "Infantil","Amor","Lealtad"),
                arrayListOf(R.drawable.blanca1,R.drawable.blanca2,R.drawable.blanca3,R.drawable.blanca4,R.drawable.blanca5,R.drawable.blanca6,R.drawable.blanca7,R.drawable.blanca8),
                arrayListOf(
                    "Una reina deseaba tener una hija, y su deseo se cumplió con el nacimiento de Blancanieves.",
                    "La reina falleció poco después del nacimiento de su hija, y el rey se volvió a casar con una mujer vanidosa y cruel.",
                    "La madrastra tenía un espejo mágico al que preguntaba quién era la más hermosa del reino.",
                    "Cuando el espejo respondió que Blancanieves lo era, la madrastra ordenó la muerte de la joven.",
                    "El cazador enviado para realizar la tarea se apiadó de Blancanieves y la dejó escapar.",
                    "Blancanieves llegó a un bosque y encontró refugio en una cabaña habitada por siete enanos.",
                    "La madrastra descubrió que Blancanieves seguía viva y se disfrazó para envenenarla con una manzana.",
                    "Un príncipe la despertó de su sueño con un beso de amor verdadero y vivieron felices para siempre."
                )
            )
        )

        catalogo.add(
                Historia(
                    R.drawable.cenicienta,
                    "Cenicienta",
                    "Maria Bonita",
                    "5",
                    "Érase una vez una hermosa joven que vivía con su madrastra y dos hermanastras que la obligaban a hacer todo el trabajo de la casa. La pobre joven tenía que cocinar, limpiar y también lavarles la ropa.",
                    arrayListOf("Ficción", "Cuento de hadas", "Romance", "Drama", "Infantil", "Fantasía"),
                    arrayListOf(R.drawable.cenicienta1,R.drawable.cenicienta2,R.drawable.cenicienta3,R.drawable.cenicienta4,R.drawable.cenicienta5),
                    // 5
                    arrayListOf(
                        "Cenicienta quiere asistir al baile real, pero sus malvadas hermanastras le dicen que no puede ir.",
                        "Una hada madrina aparece para ayudar a Cenicienta, convirtiendo una calabaza en un carruaje y unos ratones en caballos.",
                        "Cenicienta asiste al baile con un hermoso vestido y zapatos de cristal, y se roba la atención del príncipe.",
                        "Cuando llega la medianoche, Cenicienta tiene que huir del baile y regresar a casa.",
                        "El príncipe queda enamorado de Cenicienta y busca por todo el pueblo para encontrarla."
                    )
                )
                )
        catalogo.add(
            Historia(
                R.drawable.pinocho,
                "Pinocho",
                "Carlos Coyoli",
                "6",
                "Érase una vez un anciano carpintero llamado Gepeto que era muy feliz haciendo juguetes de madera para los niños de su pueblo. Un día, hizo una marioneta de una madera de pino muy especial y decidió llamarla Pinocho. En la noche, un hada azul llegó al taller del anciano carpintero:",
                arrayListOf("Cuento de hadas", "Aventura", "Infantil", "Fantasía","Familiar","Magia"),
                arrayListOf(R.drawable.pinocho1,R.drawable.pinocho2,R.drawable.pinocho3,R.drawable.pinocho4,R.drawable.pinocho5,R.drawable.pinocho6),
                //6
                arrayListOf(
                    "Gepeto era un anciano carpintero que hacía juguetes de madera para los niños.",
                    "Un día, Gepeto decidió hacer una marioneta de madera de pino especial y la llamó Pinocho.",
                    "Esa noche, un hada azul llegó al taller del anciano carpintero y le dio vida a la marioneta.",
                    "Pinocho era una marioneta muy traviesa y desobediente, y siempre se metía en problemas.",
                    "Pinocho aprendió importantes lecciones sobre la honestidad y la responsabilidad durante sus aventuras.",
                    "Al final de la historia, Pinocho se convirtió en un niño de verdad gracias a su buen comportamiento."
                )
            )
        )

    }
    class HistoriaAdapter(private val context: Context, private val catalogo: ArrayList<Historia>) :
        RecyclerView.Adapter<HistoriaAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_medalla_coleccionable_catalogo, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val historia = catalogo[position]
            val height = context.resources.getDimension(R.dimen.image_heightCatalogo).toInt()
            val width = context.resources.getDimension(R.dimen.image_widthCatalogo).toInt()

            holder.imagen.setImageResource(historia.image)
            holder.imagen.layoutParams.height = height
            holder.imagen.layoutParams.width = width
            if (((position%2)==0)&&(position!=0)) {
                val marginTop = context.resources.getDimension(R.dimen.imageTopCatalogo2).toInt()
                val params = holder.imagen.layoutParams as ViewGroup.MarginLayoutParams
                params.setMargins(0, marginTop, 0, 0)
                holder.imagen.layoutParams = params
            }else if((position==1)||((position%2)!=0)) {
                val marginTop = context.resources.getDimension(R.dimen.imageTopCatalogo).toInt()
                val params = holder.imagen.layoutParams as ViewGroup.MarginLayoutParams
                params.setMargins(0, marginTop, 0, 0)
                holder.imagen.layoutParams = params
            }
            holder.imagen.setOnClickListener {
                var intento = Intent(context, HistoriaInfo::class.java)
                intento.putExtra("historia", historia)
                intento.putExtra("image", historia.image)
                intento.putExtra("titulo", historia.titulo)
                intento.putExtra("autor", historia.autor)
                intento.putExtra("numPaginas", historia.numPaginas)
                intento.putExtra("sinopsis", historia.sinopsisi)
                context.startActivity(intento)
            }
        }

        override fun getItemCount(): Int {
            return catalogo.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var imagen: ImageView = itemView.findViewById(R.id.imageView)
        }
    }

/*
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
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.item_medalla_coleccionable_catalogo, null)

            if (((p0%2)!=0)&&(p0==1)) {
              vista = inflator.inflate(R.layout.catalogocolumna2, null)
            }

            var imagen: ImageView = vista.findViewById(R.id.imageView)
            val height = context!!.resources.getDimension(R.dimen.image_heightCatalogo).toInt()
            val width = context!!.resources.getDimension(R.dimen.image_widthCatalogo).toInt()
            imagen.setImageResource(historia.image)
            imagen.layoutParams.height = height
            imagen.layoutParams.width = width

            imagen.setOnClickListener {
                var intento = Intent(context, HistoriaInfo::class.java)
                intento.putExtra("historia", historia)
                intento.putExtra("image", historia.image)
                intento.putExtra("titulo", historia.titulo)
                intento.putExtra("autor", historia.autor)
                intento.putExtra("numPaginas", historia.numPaginas)
                intento.putExtra("sinopsis", historia.sinopsisi)
                context!!.startActivity(intento)
            }

            return vista
        }
        /
override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
    var historia = catalogo[p0]
    var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var vista = inflator.inflate(R.layout.item_medalla_coleccionable_catalogo, null)

    var imagen: ImageView = vista.findViewById(R.id.imageView)
    val height = context!!.resources.getDimension(R.dimen.image_heightCatalogo).toInt()
    val width = context!!.resources.getDimension(R.dimen.image_widthCatalogo).toInt()
    imagen.setImageResource(historia.image)
    imagen.layoutParams.height = height
    imagen.layoutParams.width = width

    imagen.setOnClickListener {
        var intento = Intent(context, HistoriaInfo::class.java)
        intento.putExtra("historia", historia)
        intento.putExtra("image", historia.image)
        intento.putExtra("titulo", historia.titulo)
        intento.putExtra("autor", historia.autor)
        intento.putExtra("numPaginas", historia.numPaginas)
        intento.putExtra("sinopsis", historia.sinopsisi)
        context!!.startActivity(intento)
    }

    return vista
}
/
    }
    */
}
