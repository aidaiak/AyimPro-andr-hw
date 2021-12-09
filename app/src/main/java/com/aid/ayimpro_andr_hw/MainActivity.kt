package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatTextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var input: AppCompatTextView
    var lastNumeric: Boolean = false
    var stateError: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input = findViewById(R.id.txt_input)
    }

    fun onDigit (v: View) {
        if(stateError) {
            //eсли нынешнее состояние показывает ошибку, то заменяем ошибку
            input.text = (v as Button).text
            stateError = false
        } else {
            //если другое, то цифра добавляется к input
            input.append((v as Button).text)
        }
        lastNumeric = true
    }

    fun onDecimalPoint (v: View) {
        //юзер вводит decimal
        if (lastNumeric && !stateError && !lastDot) {
            input.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onLeftBrace (v: View) {
        //юзер вводит (
        if (!stateError && !lastDot) {
            input.append("(")
            lastNumeric = false
        }
    }

    fun onRightBrace (v: View) {
        //юзер вводит )
        if (lastNumeric && !stateError && !lastDot) {
            input.append(")")
            lastNumeric = true
            lastDot = false
        }
    }

    fun onOperator (v: View) {
        //юзер вводит знак операции, и мы меняем textview
        if (lastNumeric && !stateError) {
            input.append((v as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    fun onClear (v: View) {
        //юзер стирает данные
        this.input.text = ""
        lastNumeric = false
        stateError = false
        lastDot = false
    }

    fun onBackspace (v: View) {
        input.text = input.text.substring(0, input.length()-1)
    }

    fun onResult (v: View) {
        //выполнение операций
        if (lastNumeric && !stateError) {
            val txt = input.text.toString()
            val expression = ExpressionBuilder(txt).build()
            try {
                val result = expression.evaluate()
                input.text = result.toString()
            } catch (ex: ArithmeticException) {
                input.text = "Error"
                stateError = true
                lastNumeric = false
            }
        }
    }
}