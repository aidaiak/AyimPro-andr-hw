package com.aid.ayimpro_andr_hw

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContentProviderCompat.requireContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val address = findViewById<AppCompatEditText>(R.id.edit)
        val subject = findViewById<AppCompatEditText>(R.id.edit2)
        val txt = findViewById<AppCompatEditText>(R.id.edit3)
        val btn = findViewById<AppCompatButton>(R.id.btn)

        btn.setOnClickListener {
            val mAddress = address.text.toString()
            val mSubject = subject.text.toString()
            val mTxt = txt.text.toString()

            composeEmail(mAddress, mSubject, mTxt)
        }
    }

    private fun composeEmail (mAddress: String, mSubject: String, mTxt: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("mailto:")
            type = "text/plain"

            putExtra(Intent.EXTRA_EMAIL, arrayOf(mAddress))
            putExtra(Intent.EXTRA_SUBJECT, mSubject)
            putExtra(Intent.EXTRA_TEXT, mTxt)
        }

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            // Defining what your app should do if no activity can handle the intent
            Toast.makeText(this, "There is no app to perform the action", Toast.LENGTH_SHORT)
                .show()
        }
    }
}



