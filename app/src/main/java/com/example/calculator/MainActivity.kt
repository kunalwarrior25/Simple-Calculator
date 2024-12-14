package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    var operator = true // Used to track if the last input was an operator
    var deci = true // Used to track if a decimal point has been added
    var value = "" // The current expression value
    var result = "" // The evaluated result

    lateinit var setvalue: TextView
    lateinit var setresult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setvalue = findViewById(R.id.value)
        setresult = findViewById(R.id.result)
    }

    // Functions to handle digit buttons (0-9)
    fun a0(view: View) {
        value += "0"
        operator = true
        updateValue()
    }

    fun a00(view: View) {
        value += "00"
        operator = true
        updateValue()
    }

    fun a1(view: View) {
        value += "1"
        operator = true
        updateValue()
    }

    fun a2(view: View) {
        value += "2"
        operator = true
        updateValue()
    }

    fun a3(view: View) {
        value += "3"
        operator = true
        updateValue()
    }

    fun a4(view: View) {
        value += "4"
        operator = true
        updateValue()
    }

    fun a5(view: View) {
        value += "5"
        operator = true
        updateValue()
    }

    fun a6(view: View) {
        value += "6"
        operator = true
        updateValue()
    }

    fun a7(view: View) {
        value += "7"
        operator = true
        updateValue()
    }

    fun a8(view: View) {
        value += "8"
        operator = true
        updateValue()
    }

    fun a9(view: View) {
        value += "9"
        operator = true
        updateValue()
    }

    // Clear the input and result
    fun ac(view: View) {
        value = ""
        setresult.setText("0")
        operator = true
        deci = true
        updateValue()
    }

    // Show the result
    fun a_equal(view: View) {
        value = result
        updateValue()
    }

    // Backspace functionality
    fun a_back(view: View) {
        if (value.isNotEmpty()) {
            val lastChar = value.last()
            if (lastChar in arrayOf('+', '-', '÷', 'x')) {
                operator = true
            }
            if (lastChar == '.') {
                deci = true
            }
            value = value.substring(0, value.length - 1)
            updateValue()
        }
    }

    // Adding operators
    fun a_add(view: View) {
        addOperator("+")
    }

    fun a_minus(view: View) {
        addOperator("-")
    }

    fun a_divide(view: View) {
        addOperator("÷")
    }

    fun a_multi(view: View) {
        addOperator("x")
    }

    // Adding a decimal point
    fun a_dot(view: View) {
        if (deci) {
            value += "."
            deci = false
            updateValue()
        }
    }

    // Helper function to update the value TextView and result
    private fun updateValue() {
        var last = value.last()
        if (last in arrayOf('1','2','3','4','5','6','7','8','9','0')){
            calculateResult()
        }
        setvalue.text = value

    }

    // Function to calculate the result using ExpressionBuilder
    private fun calculateResult() {
        try {
            val formattedExpression = value.replace("÷", "/").replace("x", "*")
            val expression = ExpressionBuilder(formattedExpression).build()
            val resultValue = expression.evaluate()
            result = resultValue.toString()
            setresult.text = result
        } catch (e: Exception) {
            setresult.text = "Error"
        }
    }

    private fun addOperator(op: String) {
        if (operator && value.isNotEmpty()) {
            val lastChar = value.last()
            if (lastChar !in arrayOf('+', '-', '÷', 'x')) {
                value += op
                operator = false
                updateValue()
            }
        }
    }
}
