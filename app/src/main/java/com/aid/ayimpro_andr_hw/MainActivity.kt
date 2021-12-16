package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatTextView
import com.aid.ayimpro_andr_hw.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnZero.setOnClickListener{setTextFields("0")}
            btnOne.setOnClickListener{setTextFields("1")}
            btnTwo.setOnClickListener{setTextFields("2")}
            btnThree.setOnClickListener{setTextFields("3")}
            btnFour.setOnClickListener{setTextFields("4")}
            btnFive.setOnClickListener{setTextFields("5")}
            btnSix.setOnClickListener{setTextFields("6")}
            btnSeven.setOnClickListener{setTextFields("7")}
            btnEight.setOnClickListener{setTextFields("8")}
            btnNine.setOnClickListener{setTextFields("9")}

            btnSubtract.setOnClickListener{setTextFields("-")}
            btnMultiply.setOnClickListener{setTextFields("*")}
            btnDivide.setOnClickListener{setTextFields("/")}
            btnAdd.setOnClickListener{setTextFields("+")}
            leftBrace.setOnClickListener{setTextFields("(")}
            rightBrace.setOnClickListener{setTextFields(")")}
            btnDecimalPoint.setOnClickListener{setTextFields(".")}

            btnClear.setOnClickListener {
                txtInput.text = ""
            }
            btnBackspace.setOnClickListener {
                val str = txtInput.text.toString()
                if (str.isNotEmpty()) {
                    txtInput.text = str.substring(0, str.length - 1)
                }
            }
            btnResult.setOnClickListener {
                try {
                    val ex = ExpressionBuilder(txtInput.text.toString()).build()
                    val result = ex.evaluate()

                    val longRes = result.toLong()
                    if (result == longRes.toDouble())
                        txtInput.text = longRes.toString()
                    else
                        txtInput.text = result.toString()
                } catch (e: ArithmeticException) {
                    txtInput.text = "Error"
                }
            }
        }
    }
    fun setTextFields(str: String) {
        binding.txtInput.append(str)
    }
}