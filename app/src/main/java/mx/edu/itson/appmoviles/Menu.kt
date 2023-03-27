
package mx.edu.itson.appmoviles


import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.edu.itson.appmoviles.databinding.ActivityMenuBinding


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

        binding.bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_Perfil ->{
                    setCurrentFragment(perfilFragment)
                    true
                }
                R.id.nav_Actividades ->{
                    setCurrentFragment(actividadesFragment)
                    true
                }
                R.id.nav_Inicio ->{
                    setCurrentFragment(catalogoFragment)
                    true
                }
                else -> false
            }
        }

    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView,fragment)
            commit()
        }
    }


}