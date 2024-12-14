package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    var oparator = true

    var deci = true
    var value = ""
    var result = ""

    lateinit var setvalue:TextView
    lateinit var setresult:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setvalue = findViewById(R.id.value)
        setresult = findViewById(R.id.result)
    }
    fun a0(view: View) {
        if (value.isNotEmpty() ) {
            value = value + "0"
            value()
        }
    }
    fun a00(view: View) {
        if (value.isNotEmpty()) {
            value = value + "00"
            value()
        }
    }
    fun a1(view: View) {
        value = value + "1"
        oparator = true
        value()
    }
    fun a2(view: View) {
        value = value + "2"
        oparator = true
        value()
    }
    fun a3(view: View) {
        value = value + "3"
        oparator = true
        value()
    }
    fun a4(view: View) {
        value = value + "4"
        oparator = true
        value()
    }
    fun a5(view: View) {
        value = value + "5"
        oparator = true
        value()
    }
    fun a6(view: View) {
        value = value + "6"
        oparator = true
        value()
    }
    fun a7(view: View) {
        value = value + "7"
        oparator = true
        value()
    }
    fun a8(view: View) {
        value = value + "8"
        oparator = true
        value()
    }
    fun a9(view: View) {
        value = value + "9"
        oparator = true
        value()
    }
    fun ac(view: View) {
        value = ""
        setresult.setText("0")
        oparator = true
        deci = true
        value()
    }
    fun a_equal(view: View) {
        value = result
        value()
    }
    fun a_back(view: View) {
        if (value.isNotEmpty()) {
            val lastChar = value.last()
            if (lastChar in arrayOf('+', '-', '÷', 'x')) {
                oparator = true
            }
            if (lastChar == '.') {
                deci = true
            }
            value = value.substring(0, value.length - 1)
            value()

        }
    }
    fun a_add(view: View) {
        if (oparator) {
            var lastchar = value.last()
            if (lastchar in arrayOf('+', '-', '÷', 'x')) {
                value = value + "+"
                oparator = false
                value()
            }
        }
    }
    fun a_minus(view: View) {
        if (oparator) {
            var lastchar = value.last()
            if (lastchar in arrayOf('+', '-', '÷', 'x')) {
                value = value + "-"
                oparator = false
                value()
            }
        }
    }
    fun a_divide(view: View) {
        if (oparator) {
            var lastchar = value.last()
            if (lastchar in arrayOf('+', '-', '÷', 'x')) {
                value = value + "÷"
                oparator = false
                value()
            }
        }
    }
    fun a_multi(view: View) {
        if (oparator) {
            var lastchar = value.last()
            if (lastchar in arrayOf('+', '-', '÷', 'x')) {
                value = value + "x"
                oparator = false
                value()
            }
        }
    }
    fun a_dot(view: View) {
        if (deci) {
            value = value + "."
            deci = false
        }
    }

    private fun value(){
        setvalue.setText("$value")
        result()
    }

    private fun result(){
        try {
            val formattedExpression = value.replace("÷", "/").replace("x", "*")
            val expression = ExpressionBuilder(formattedExpression).build()
            val resultValue = expression.evaluate()

            result = resultValue.toString()
            setresult.text = result

        } catch (e: Exception) {
        }
    }
}