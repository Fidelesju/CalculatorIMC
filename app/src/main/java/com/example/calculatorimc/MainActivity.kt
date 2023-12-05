package com.example.calculatorimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBarAltura : SeekBar = findViewById(R.id.seekBarAltura)
        val buttonIdadeLess : Button = findViewById(R.id.buttonIdadeLess)
        val buttonIdadePlus : Button = findViewById(R.id.buttonIdadePlus)
        val buttonPesoLess : Button = findViewById(R.id.buttonPesoLess)
        val buttonPesoPlus : Button = findViewById(R.id.buttonPesoPlus)
        val buttonCalcular : Button = findViewById(R.id.buttonCalcular)
        val textViewIdade : TextView = findViewById(R.id.textViewIdade)
        val textViewPeso : TextView = findViewById(R.id.textViewPeso)
        val textViewAltura : TextView = findViewById(R.id.textViewAltura)

        var peso : Int = 50
        var idade : Int = 20
        var altura : Int = 0
        var resultado : Float = 0.0f
        var alturaConvert : Float =  0.0f
        val sexo : String = ""


        textViewAltura.text = altura.toString()
        textViewIdade.text = idade.toString()
        textViewPeso.text = peso.toString()



        seekBarAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Atualize o valor da altura no TextView correspondente
                    altura = progress
                textViewAltura.text = altura.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Este método é chamado quando o usuário toca no SeekBar
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Este método é chamado quando o usuário solta o dedo do SeekBar
            }
        })

        buttonIdadeLess.setOnClickListener {
            if (idade > 0) {
                idade--
                textViewIdade.text = idade.toString()
            }
        }

        buttonIdadePlus.setOnClickListener {
            idade++
            textViewIdade.text = idade.toString()
        }

        buttonPesoLess.setOnClickListener {
            if (peso > 0) {
                peso--
                textViewPeso.text = peso.toString()
            }
        }

        buttonPesoPlus.setOnClickListener {
            peso++
            textViewPeso.text = peso.toString()
        }

        buttonCalcular.setOnClickListener {
            alturaConvert = (altura/100.0).toFloat()
            resultado = peso/(alturaConvert * alturaConvert)
            println(resultado)
            println(alturaConvert)

            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", resultado)
                    putExtra("EXTRA_SEXO", sexo)
                }
            startActivity(intent)
        }
    }
}
