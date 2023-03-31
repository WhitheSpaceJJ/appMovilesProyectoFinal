package mx.edu.itson.appmoviles


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import mx.edu.itson.appmoviles.databinding.ActivityMenuBinding
import mx.edu.itson.appmoviles.databinding.FragmentActividadesBinding


class Menu : AppCompatActivity() {


    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var perfilFragment = FragmentPerfil()
        var actividadesFragment = FragmentActividades()
        var catalogoFragment = FragmentCatalogo()
        var buscarFragment = FragmentBuscar()
        var bibliotecaFragment = FragmentBiblioteca()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.nav_Inicio -> {
                    setCurrentFragment(catalogoFragment)
                    true
                }

                R.id.nav_Buscar -> {
                    setCurrentFragment(buscarFragment)
                    true
                }

                R.id.nav_Biblioteca -> {
                    setCurrentFragment(bibliotecaFragment)
                    true
                }

                R.id.nav_Actividades -> {
                    setCurrentFragment(actividadesFragment)
                    true
                }

                R.id.nav_Perfil -> {
                    setCurrentFragment(perfilFragment)
                    true
                }
                else -> false
            }
        }

    }

    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView, fragment)
            commit()
        }
    }

}