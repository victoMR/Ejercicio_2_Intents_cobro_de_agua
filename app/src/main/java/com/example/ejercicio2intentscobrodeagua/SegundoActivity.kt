package com.example.ejercicio2intentscobrodeagua

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SegundoActivity : AppCompatActivity() {

    // atributos
    private lateinit var tvTotal : TextView
    private lateinit var btnVolver : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo)

        // inicializar atributos
        tvTotal = findViewById(R.id.tvTotal)
        btnVolver = findViewById(R.id.btnVolver)

        // obtener los extras
        val litros = intent.getIntExtra("litros",0)

        // calcular el costo
        val costo = when{  // cuando se cumpla la condicion se ejecuta el codigo
            litros <= 50 -> 50 // si es menor o igual a 50 se cobra 50
            litros in 51..200 -> 50 + (litros - 50) * 1.5 // si esta entre 51 y 200 se cobra 50 + (litros - 50) * 1.5
            else -> 50 + 150 * 1.5 + (litros - 200) * 3.5  // si es mayor a 200 se cobra 50 + 150 * 1.5 + (litros - 200) * 3.5
        } // fin del when

        // mostrar el costo
        tvTotal.text = "El costo es: $$costo 🚰0"

        // evento click del botón de volver
        btnVolver.setOnClickListener {
            // finalizar la actividad
            finish()
        }

    }
}