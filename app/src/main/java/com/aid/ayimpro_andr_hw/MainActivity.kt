package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var txt: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt = findViewById(R.id.txt)
        val edit = findViewById<AppCompatEditText>(R.id.edit)
        val btn = findViewById<AppCompatButton>(R.id.btn)

        btn.setOnClickListener {
            val text = edit.text.toString().trim()
            val listOfWords = text.split("\\s+".toRegex())
            var maxA = 0
            var word = ""

            listOfWords.forEach {
                if (it.contains('a')) {
                    val numOfA = it.count{c -> c == 'a'}
                    if (maxA < numOfA)
                    {
                        maxA = numOfA
                        word = it
                    }
                }
            }

            txt.text = "The word with max 'A's: $word & number of 'A's = $maxA\n"
        }
    }
}