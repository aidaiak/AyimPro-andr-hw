package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private lateinit var txtCount: TextView
    private lateinit var btnCount: AppCompatButton
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCount = findViewById(R.id.txt1)
        btnCount = findViewById(R.id.btn1)

        btnCount.setOnClickListener {
            onClick(it)
        }
    }
    private fun onClick(v: View) {
        count++
        txtCount.text = count.toString()
    }
}