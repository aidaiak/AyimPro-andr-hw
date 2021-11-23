package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txt1: AppCompatTextView
    private lateinit var layout1: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt1 = findViewById(R.id.txt1)
        layout1 = findViewById(R.id.layout1)
        val btn1 = findViewById<AppCompatButton>(R.id.btn1)
        val btn2 = findViewById<AppCompatButton>(R.id.btn2)
        val btn3 = findViewById<AppCompatButton>(R.id.btn3)

        btn1.setOnClickListener {
            onClick(it)
        }

        btn2.setOnClickListener {
            onClick(it)
        }

        btn3.setOnClickListener {
            onClick(it)
        }
    }

    private fun onClick(v: View) {
        when(v.id) {
            R.id.btn1 -> {
                txt1.text = "RED"
                layout1.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            }
            R.id.btn2 -> {
                txt1.text = "YELLOW"
                layout1.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
            }
            R.id.btn3 -> {
                txt1.text = "GREEN"
                layout1.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
            }
            else -> "Unknown"
        }
    }
}