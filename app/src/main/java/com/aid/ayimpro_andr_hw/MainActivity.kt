package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.PackageManagerCompat
import androidx.core.content.PackageManagerCompat.LOG_TAG


class MainActivity : AppCompatActivity() {

    private lateinit var txtCount: TextView
    private lateinit var btnCount: AppCompatButton
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCount = findViewById(R.id.txt1)
        btnCount = findViewById(R.id.btn1)
        val btnReset = findViewById<AppCompatButton>(R.id.btn2)

        btnCount.setOnClickListener {
            onClick(it)
        }

        btnReset.setOnClickListener {
            onClick(it)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(key, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(key)
    }

    private fun onClick(v: View) {
        when (v.id) {
            R.id.btn1 -> {
                count++
                txtCount.text = count.toString()
            }
            R.id.btn2 -> {
                count = 0
                txtCount.text = count.toString()
            }
        }
    }

    companion object {
        private const val key = "KEY_COUNT"
    }

}