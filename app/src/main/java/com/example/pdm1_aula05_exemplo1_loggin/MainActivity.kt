package com.example.pdm1_aula05_exemplo1_loggin

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciando os elementos do layout
        val editTextNumber1: EditText = findViewById(R.id.editTextNumber1)
        val editTextNumber2: EditText = findViewById(R.id.editTextNumber2)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        // Função para obter os valores inseridos
        fun getNumbers(): Pair<Double, Double>? {
            val num1 = editTextNumber1.text.toString()
            val num2 = editTextNumber2.text.toString()

            return if (num1.isNotEmpty() && num2.isNotEmpty()) {
                Pair(num1.toDouble(), num2.toDouble())
            } else {
                Toast.makeText(this, "Por favor, insira ambos os números", Toast.LENGTH_SHORT).show()
                null
            }
        }

        // Soma
        buttonAdd.setOnClickListener {
            val numbers = getNumbers()
            if (numbers != null) {
                val result = numbers.first + numbers.second
                textViewResult.text = "Resultado: $result"
            }
        }

        // Subtração
        buttonSubtract.setOnClickListener {
            val numbers = getNumbers()
            if (numbers != null) {
                val result = numbers.first - numbers.second
                textViewResult.text = "Resultado: $result"
            }
        }

        // Multiplicação
        buttonMultiply.setOnClickListener {
            val numbers = getNumbers()
            if (numbers != null) {
                val result = numbers.first * numbers.second
                textViewResult.text = "Resultado: $result"
            }
        }

        // Divisão
        buttonDivide.setOnClickListener {
            val numbers = getNumbers()
            if (numbers != null) {
                if (numbers.second != 0.0) {
                    val result = numbers.first / numbers.second
                    textViewResult.text = "Resultado: $result"
                } else {
                    Toast.makeText(this, "Não é possível dividir por zero", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {const val TAG = "Prof. José Paulo - DEBUG_LIFE_CYCLE"}

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "método onStart() foi invocado!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "método onRestart() foi invocado!")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "método onResume() foi invocado!")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "método onPause() foi invocado!")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "método onStop() foi invocado!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "método onDestroy() foi invocado!")
    }
}