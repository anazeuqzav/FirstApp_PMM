package com.example.firstapp.firstactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapp.R

/**
 * Actividad principal de la aplicación. Permite al usuario ingresar su
 * nombre, apellidos y edad para iniciar la siguiente actividad: ResultActivity
 */
class MainActivity : AppCompatActivity() {
    /**
     * Método onCreate que se ejecuta al crear la actividad.
     * Se inicializan los componentes de la interfaz y se configura el botón
     * de inicio
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtiene las referencias de los elementos de la inferfaz
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart) // Botón de Inicio o Registro
        val etName = findViewById<AppCompatEditText>(R.id.etName) // EditText para el nombre
        val etSurname = findViewById<AppCompatEditText>(R.id.etSurname) // EditText para el apellido
        val etAge = findViewById<AppCompatEditText>(R.id.etAge) //EditText para la edad

        /**
         * Configura el listener del click para el botón de resgistro.
         * Obtiene el nombre, apelliod y edad ingresado, valida que no estén vaciós
         * y que la edad sea un número válido (comprendido entre 1 y 120).
         * Si la validación es correcta, inicia la actividad ResultActivity.
         */
        btnStart.setOnClickListener {
            val name = etName.text.toString()
            val surname = etSurname.text.toString()
            val ageString = etAge.text.toString();

            // Comprueba que los campos no estén vacíos
            if(name.isEmpty() || surname.isEmpty() || ageString.isEmpty()) {
                // Si alguno de los campos está vacío muestra un pop up
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_LONG).show()
            } else {
                try {
                    // Convierte la edad introducida a un entero
                    val age = ageString.toInt()
                    if (age in 1..119) {
                        // Si la edad es válida, incia ResultActivity pasando los datos con un intent
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("EXTRA_NAME", name)
                        intent.putExtra("EXTRA_SURNAME", surname)
                        intent.putExtra("EXTRA_AGE", age)
                        startActivity(intent)

                     } else {
                         // Muestra un pop up si la edad no se encuentra entre el rango permitido
                        Toast.makeText(this, "Por favor, introduce una edad válida", Toast.LENGTH_LONG).show()
                    }

                // Si la edad introducida no es un número muestra un pop up indicándolo.
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor, introduce una edad válida", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}