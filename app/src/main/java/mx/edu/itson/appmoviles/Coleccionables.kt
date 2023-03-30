package mx.edu.itson.appmoviles


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import mx.edu.itson.appmoviles.R.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentPerfil.newInstance] factory method to
 * create an instance of this fragment.
 */
class Coleccionables : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view: View = inflater.inflate(layout.activity_coleccionables, container, false)
        val coleccion = listOf(R.drawable.coleccionable1, R.drawable.coleccionable2, R.drawable.coleccionable3, R.drawable.coleccionable4, R.drawable.coleccionable5, R.drawable.coleccionable6)
        val adapter = ColeccionableAdapter(coleccion)
        val gridView = view.findViewById<GridView>(R.id.inviernoColeccionables)
        gridView.adapter = adapter
        val regresar:ImageView=view.findViewById(R.id.buttonRegresar)

        regresar.setOnClickListener {
            val menuActivity = requireActivity() as Menu
            menuActivity.setCurrentFragment(ColeccionBase())
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentPerfil.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentPerfil().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    class ColeccionableAdapter(private val coleccionable: List<Int>) : BaseAdapter() {

        override fun getCount(): Int {
            return coleccionable.size
        }

        override fun getItem(position: Int): Any {
            return coleccionable[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_medalla_coleccionable, parent, false)
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(coleccionable[position])
            return view
        }
    }

}
