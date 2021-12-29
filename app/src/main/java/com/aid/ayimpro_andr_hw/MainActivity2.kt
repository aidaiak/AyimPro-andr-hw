package com.aid.ayimpro_andr_hw

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val edit = findViewById<AppCompatEditText>(R.id.act2_edit)
        val btn = findViewById<AppCompatButton>(R.id.act2_btn)

        btn.setOnClickListener {
            val intent = Intent("android.intent.action.MAIN")
            intent.putExtra("key", edit.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}