package pe.edu.cibertec.app_evaluacion_t2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.app_evaluacion_t2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.nav_pregunta1 -> {
                    true
                }

                R.id.nav_pregunta2 -> {
                    true
                }

                R.id.nav_pregunta3 -> {
                    true
                }

                R.id.nav_pregunta4 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contenedorFragment, FragmentPregunta4())
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
}