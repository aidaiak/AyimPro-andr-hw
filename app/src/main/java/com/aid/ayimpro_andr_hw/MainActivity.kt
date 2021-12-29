package com.aid.ayimpro_andr_hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    private lateinit var txt: AppCompatTextView
    private lateinit var activityLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerLauncher()
        txt = findViewById(R.id.act1_txt)
        val btn = findViewById<AppCompatButton>(R.id.act1_btn)

        btn.setOnClickListener {
            activityLauncher.launch(Intent("MainActivity2"))
        }
    }
    private fun registerLauncher() {
        activityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
            txt.text = it.data?.getStringExtra("key") ?: "Default"
        }
        }
    }
}
