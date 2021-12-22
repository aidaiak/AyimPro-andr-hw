package com.aid.ayimpro_andr_hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import android.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editAcc = findViewById<TextInputEditText>(R.id.edit_account)
        val editPwd = findViewById<TextInputEditText>(R.id.edit_pwd)
        val btnSign = findViewById<MaterialButton>(R.id.btn_sign)

        val acc = "johndoe@example.com"
        val pwd = "John123"

        btnSign.setOnClickListener {
            if ((acc == editAcc.text.toString()) && (pwd == editPwd.text.toString())) {
                val intent = Intent("Activity2")
                startActivity(intent)
            } else {

            }
        }
    }
}