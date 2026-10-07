package pe.edu.cibertec.app_evaluacion_t2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.app_evaluacion_t2.databinding.FragmentPregunta4Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentPregunta4 : Fragment() {

    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPregunta4Binding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView
        binding.recyclerProductos.layoutManager =
            LinearLayoutManager(requireContext())

        // Consumir API
        obtenerProductos()
    }

    private fun obtenerProductos() {

        RetrofitClient.api.getProductos()
            .enqueue(object : Callback<ProductsResponse> {

                override fun onResponse(
                    call: Call<ProductsResponse>,
                    response: Response<ProductsResponse>
                ) {

                    if (response.isSuccessful) {

                        val productos = response.body()?.products ?: emptyList()

                        binding.recyclerProductos.adapter =
                            ProductoAdapter(productos)

                    } else {

                        Toast.makeText(
                            requireContext(),
                            "Error al obtener los productos",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(
                    call: Call<ProductsResponse>,
                    t: Throwable
                ) {

                    Toast.makeText(
                        requireContext(),
                        "Error de conexión: ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}