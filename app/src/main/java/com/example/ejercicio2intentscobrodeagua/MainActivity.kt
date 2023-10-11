package com.example.ejercicio2intentscobrodeagua

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // atributos
    private lateinit var etLitros : EditText
    private lateinit var btnCalcular : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inicializar atributos
        etLitros = findViewById(R.id.etLitros)
        btnCalcular = findViewById(R.id.btnCalcular)

        // evento click del botón
        btnCalcular.setOnClickListener {

            // crear el intent
            val intent = Intent(this@MainActivity,SegundoActivity::class.java)

            // delcaramos los extras de calcular el costo a paga por litros gastados , cuota mensual 50, 50 litros gratis, entre 50 y 200 litros 1.50 por litro, mas de 200 litros 3.50 por litro
            val litros = etLitros.text.toString().toIntOrNull()
            intent.putExtra("litros",litros)

            // si no hay nada en litros
            if (litros == null){
                // mostrar mensaje
                etLitros.error = "Debe ingresar un numero"
                // salir de la función
                return@setOnClickListener
            }


            // iniciar la actividad
            startActivity(intent)
        }
    }
}