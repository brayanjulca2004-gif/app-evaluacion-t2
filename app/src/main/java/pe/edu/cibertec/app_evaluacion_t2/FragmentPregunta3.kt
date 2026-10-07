package pe.edu.cibertec.app_evaluacion_t2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.app_evaluacion_t2.databinding.FragmentPregunta3Binding

class FragmentPregunta3 : Fragment() {

    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPregunta3Binding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView
        binding.recyclerAnimales.layoutManager =
            LinearLayoutManager(requireContext())

        // Crear lista de animales
        val listaAnimales = crearListaAnimales()

        // Asignar adaptador
        binding.recyclerAnimales.adapter =
            AnimalAdapter(listaAnimales)
    }

    private fun crearListaAnimales(): List<Animal> {

        return listOf(

            Animal(
                "León",
                "Mamífero",
                imagenRandom("lion")
            ),

            Animal(
                "Tigre",
                "Mamífero",
                imagenRandom("tiger")
            ),

            Animal(
                "Elefante",
                "Mamífero",
                imagenRandom("elephant")
            ),

            Animal(
                "Jirafa",
                "Mamífero",
                imagenRandom("giraffe")
            ),

            Animal(
                "Cebra",
                "Mamífero",
                imagenRandom("zebra")
            ),

            Animal(
                "Oso",
                "Mamífero",
                imagenRandom("bear")
            ),

            Animal(
                "Lobo",
                "Mamífero",
                imagenRandom("wolf")
            ),

            Animal(
                "Zorro",
                "Mamífero",
                imagenRandom("fox")
            ),

            Animal(
                "Panda",
                "Mamífero",
                imagenRandom("panda")
            ),

            Animal(
                "Koala",
                "Mamífero",
                imagenRandom("koala")
            ),

            Animal(
                "Águila",
                "Ave",
                imagenRandom("eagle")
            ),

            Animal(
                "Búho",
                "Ave",
                imagenRandom("owl")
            ),

            Animal(
                "Flamenco",
                "Ave",
                imagenRandom("flamingo")
            ),

            Animal(
                "Pingüino",
                "Ave",
                imagenRandom("penguin")
            ),

            Animal(
                "Delfín",
                "Mamífero marino",
                imagenRandom("dolphin")
            ),

            Animal(
                "Tiburón",
                "Pez",
                imagenRandom("shark")
            ),

            Animal(
                "Tortuga",
                "Reptil",
                imagenRandom("turtle")
            ),

            Animal(
                "Cocodrilo",
                "Reptil",
                imagenRandom("crocodile")
            ),

            Animal(
                "Camaleón",
                "Reptil",
                imagenRandom("chameleon")
            ),

            Animal(
                "Rana",
                "Anfibio",
                imagenRandom("frog")
            )
        )
    }

    private fun imagenRandom(animal: String): String {

        val numeroRandom = (1..10000).random()

        return "https://picsum.photos/seed/${animal}${numeroRandom}/640/480"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}