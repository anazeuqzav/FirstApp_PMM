package com.example.firstapp.firstactivity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapp.R
/**
 * ResultActivity muestra el saludo y la información de edad del usuario que se ingresó
 * en la actividad principal (MainActivity).
 */
class ResultActivity : AppCompatActivity() {
    /**
     * Método onCreate, que se ejecuta al crear la actividad.
     * Configura la interfaz de usuario y muestra los datos obtenidos de MainActivity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtiene la referencia de TextView para el saludo y extrae los datos de nombre y apellido
        val tvResultHello = findViewById<TextView>(R.id.tvResultHello)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        val surname:String = intent.extras?.getString("EXTRA_SURNAME").orEmpty()
        // Configura el texto del saludo con el nombre y apellido obtenidos.
        tvResultHello.text = "Hola $name $surname!"

        // Obtiene la referencia del Textview para la edad
        val tvResultAge = findViewById<TextView>(R.id.tvResultAge)
        val age: Int? = intent.extras?.getInt("EXTRA_AGE")
        // Muestra la edad obtenida
        tvResultAge.text ="Edad: ${age}";

        // Configura el botón para regresar a la actividad anterior.
        val btnBack = findViewById<AppCompatButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Termina la actividad y regresa al MainActivity
        }
    }
}