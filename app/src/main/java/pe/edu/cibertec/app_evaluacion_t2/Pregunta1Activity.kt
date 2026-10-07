package pe.edu.cibertec.app_evaluacion_t2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.app_evaluacion_t2.databinding.ActivityPregunta1Binding


data class Usuario(val identificador: String, val contrasena: String)


class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding


    private val listaUsuariosMock = listOf(
        Usuario("I202510545", "41107489"),
        Usuario("I202330752", "77031337"),
        Usuario("I202409433", "70635994"),
        Usuario("I202502852", "932796645"),
        Usuario("I202502852", "76823349"),
        Usuario("I202316852", "969147541"),
        Usuario("I201714859",  "70303886")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnIngresar.setOnClickListener(this)
    }

    // Lógica de Autenticación
    override fun onClick(vista: View?) {
        if (vista?.id == R.id.btnIngresar) {
            val usuarioIngresado = binding.etUsuario.text.toString().trim()
            val claveIngresada = binding.etClave.text.toString().trim()

            // A. Control de entradas (vacíos o solo espacios)
            if (usuarioIngresado.isEmpty() || claveIngresada.isEmpty()) {
                Toast.makeText(this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show()
                return
            }

            // B. Procesamiento y Búsqueda
            val usuarioEncontrado = listaUsuariosMock.find {
                it.identificador == usuarioIngresado && it.contrasena == claveIngresada
            }

            if (usuarioEncontrado != null) {
                // C. Flujo de Éxito
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                // finish() destruye el Login para que no se pueda regresar con el botón "Atrás"
                finish()
            } else {
                // D. Flujo de Error
                Toast.makeText(this, "Datos incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}