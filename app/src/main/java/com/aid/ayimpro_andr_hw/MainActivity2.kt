package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var txt2: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txt2 = findViewById(R.id.text2)
        val txt = intent.getStringExtra("key2")
        txt2.text = "$txt"
    }
}

