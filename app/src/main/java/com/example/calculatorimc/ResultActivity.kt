package com.example.calculatorimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

//        val progressBar : ProgressBar = findViewById(R.id.progressBar)
        val TextViewValues_categoria : TextView = findViewById(R.id.TextViewValues_categoria)
        val TextViewValues_diferenca : TextView = findViewById(R.id.TextViewValues_diferenca)
        val textViewIMC : TextView = findViewById(R.id.textViewIMC)


//        val abaixoDoPesoMax : Float = 18.5f
//        val saudavelMax : Float = 25f
//        val acimaDoPesoMax : Float = 40f
        var diferenca : Float = 24.9f
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        val resultConvert = String.format("%.1f",result)
        var categoria = ""

        if(result <= 15.9f)
        {
            categoria = "Magreza Grave"
            diferenca -= result
        }else if(result in 16f .. 16.9f)
        {
            categoria = "Magreza Moderada"
            diferenca -= result
        }else if(result in 17f .. 18.4f)
        {
            categoria = "Magreza Leve"
            diferenca -= result
        }else if(result in 18.5f .. 24.9f)
        {
            categoria = "Saudável"
            diferenca -= result
        }else if(result in 25f .. 29.9f)
        {
            categoria = "Sobrepeso"
            diferenca -= result
        }else if(result in 30f .. 34.9f)
        {
            categoria = "Obesidade Grau I"
            diferenca -= result
        }else if(result in 35f .. 39.9f)
        {
            categoria = "Obesidade Grau II"
            diferenca -= result
        }else (result > 40f)
        {
            categoria = "Obesidade Grau III"
            diferenca -= result
        }

        val diferencaConvert = String.format("%.1f",diferenca)
        TextViewValues_categoria.text = categoria
        TextViewValues_diferenca.text = diferencaConvert
        textViewIMC.text = resultConvert
//
//        // Defina os limites para cada parte
//        progressBar.setProgress(result.toInt())
//        // ou progressBar.progress = abaixoDoPesoMax
//
//        // Para representar a parte "Saudável", ajuste os limites
//        progressBar.setProgress(saudavelMax.toInt())
//
//        // Para representar a parte "Acima do peso", ajuste os limites
//        progressBar.setProgress(acimaDoPesoMax.toInt())

        println(result)
        println(diferencaConvert)

    }
}