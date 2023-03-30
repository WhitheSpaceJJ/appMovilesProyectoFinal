package mx.edu.itson.appmoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView

class Medallas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medallas)
        val medallas = listOf(R.drawable.medalla1, R.drawable.medalla2, R.drawable.medalla3, R.drawable.medalla4, R.drawable.medalla5, R.drawable.medalla6)

        val adapter = MedallasAdapter(medallas)
        val gridView = findViewById<GridView>(R.id.medallas)
        gridView.adapter = adapter
    }
    class MedallasAdapter(private val medallas: List<Int>) : BaseAdapter() {

        override fun getCount(): Int {
            return medallas.size
        }

        override fun getItem(position: Int): Any {
            return medallas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_medalla, parent, false)
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(medallas[position])
            return view
        }
    }


}