package com.generation.simuladordedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGerarSeqD6 = findViewById<Button>(R.id.buttonGerarSeqD6)
        val buttonGerarSeqD12 = findViewById<Button>(R.id.buttonGerarSeqD12)
        val buttonGerarSeqD20 = findViewById<Button>(R.id.buttonGerarSeqD20)

        buttonGerarSeqD6.setOnClickListener {
            rodarDados(6)
        }
        buttonGerarSeqD12.setOnClickListener {
            rodarDados(12)
        }
        buttonGerarSeqD20.setOnClickListener {
            rodarDados(20)
        }
    }

    private fun rodarDados(lados: Int){
        val rolagemD6 = (1..lados).random()
        val rolagemD12 = (1..lados).random()
        val rolagemD20 = (1..lados).random()

        val textSequence = findViewById<TextView>(R.id.TextSequencia)

        textSequence.text = rolagemD6.toString()
        textSequence.text = rolagemD12.toString()
        textSequence.text = rolagemD20.toString()
    }
}