package mx.edu.itson.appmoviles

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView

class Coleccionables : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coleccionables)
        val coleccion = listOf(R.drawable.coleccionable1, R.drawable.coleccionable2, R.drawable.coleccionable3, R.drawable.coleccionable4, R.drawable.coleccionable5, R.drawable.coleccionable6)

        val adapter = ColeccionableAdapter(coleccion)
        val gridView = findViewById<GridView>(R.id.coleccionablesG)
        gridView.adapter = adapter
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
            val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_medalla, parent, false)
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(coleccionable[position])
            return view
        }
    }


}