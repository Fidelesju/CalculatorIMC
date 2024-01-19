package com.example.calculatorimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewValues_categoria: TextView = findViewById(R.id.TextViewValues_categoria)
        val textViewValues_diferenca: TextView = findViewById(R.id.TextViewValues_diferenca)
        val textViewIMC: TextView = findViewById(R.id.textViewIMC)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        val resultConvert = String.format("%.1f", result)
        var categoria: String = "" // Definindo um valor padrão

        val valor: String = when {
            result <= 15.9f -> {
                categoria = "Magreza Grave"
                "Menor ou Igual a 15.9"
            }
            result in 16f..16.9f -> {
                categoria = "Magreza Moderada"
                "16 e 16.9"
            }
            result in 17f..18.4f -> {
                categoria = "Magreza Leve"
                "17 e 18.4"
            }
            result in 18.5f..24.9f -> {
                categoria = "Saudável"
                "18.5 e 24.9"
            }
            result in 25f..29.9f -> {
                categoria = "Sobrepeso"
                "25 e 29.9"
            }
            result in 30f..34.9f -> {
                categoria = "Obesidade Grau I"
                "30 e 34.9"
            }
            result in 35f..39.9f -> {
                categoria = "Obesidade Grau II"
                "35 e 39.9"
            }
            result > 40f -> {
                categoria = "Obesidade Grau III"
                "Maior que 40"
            }
            else -> {
                "Categoria não definida"
            }
        }

        textViewValues_categoria.text = categoria
        textViewValues_diferenca.text = valor
        textViewIMC.text = resultConvert
    }
}
