package pe.edu.cibertec.app_evaluacion_t2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {

            val peso = edtPeso.text.toString().toDoubleOrNull()

            if (peso == null) {
                txtResultado.text = "Ingrese un peso válido."
                return@setOnClickListener
            }

            if (peso <= 8) {
                txtResultado.text = "Peso total: S/%.2f kg\nNo aplica penalidad ni recargo especial de cabina."
                    .format(peso)
            } else {
                val exceso = peso - 8
                val recargo = 150 + (exceso * 35)

                txtResultado.text =
                    "Peso total: %.2f kg\nExceso: %.2f kg\nRecargo: S/%.2f"
                        .format(peso, exceso, recargo)
            }
        }
    }
}