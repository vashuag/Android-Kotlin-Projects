package com.example.calcu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private fun evaluateExpression(expression: String): Double {
        val parts = expression.split("+", "-", "*", "/")
        val numbers = mutableListOf<Double>()
        val operators = mutableListOf<Char>()

        for (part in parts) {
            numbers.add(part.toDouble())
        }

        for (i in 1 until expression.length) {
            val c = expression[i]
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operators.add(c)
            }
        }

        for (i in 0 until operators.size) {
            val operator = operators[i]
            when (operator) {
                '+' -> numbers[i + 1] = numbers[i] + numbers[i + 1]
                '-' -> numbers[i + 1] = numbers[i] - numbers[i + 1]
                '*' -> numbers[i + 1] = numbers[i] * numbers[i + 1]
                '/' -> numbers[i + 1] = numbers[i] / numbers[i + 1]
            }
        }

        return numbers.last()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val buttonPlus = findViewById<Button>(R.id.buttonPlus)
        val buttonMinus = findViewById<Button>(R.id.buttonMinus)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        val buttonEquals = findViewById<Button>(R.id.buttonEquals)
        val buttonClear = findViewById<Button>(R.id.buttonClear)

        val numberButtons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)

        for (button in numberButtons) {
            button.setOnClickListener {
                val currentResult = resultTextView.text.toString()
                val buttonValue = button.text.toString()
                resultTextView.text = currentResult + buttonValue
            }
        }

        buttonPlus.setOnClickListener {
            val currentResult = resultTextView.text.toString()
            resultTextView.text = currentResult + "+"
        }

        buttonMinus.setOnClickListener {
            val currentResult = resultTextView.text.toString()
            resultTextView.text = currentResult + "-"
        }

        buttonMultiply.setOnClickListener {
            val currentResult = resultTextView.text.toString()
            resultTextView.text = currentResult + "*"
        }

        buttonDivide.setOnClickListener {
            val currentResult = resultTextView.text.toString()
            resultTextView.text = currentResult + "/"
        }

        buttonEquals.setOnClickListener {
            val expression = resultTextView.text.toString()
            val result = evaluateExpression(expression)
            resultTextView.text = result.toString()
        }

        buttonClear.setOnClickListener {
            resultTextView.text = ""
        }
    }


}
