package com.aid.ayimpro_andr_hw

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


class MainActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frg_cont, Fragment1())
            .commit()
    }

    override fun onClick(adapterPosition: String) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("key", adapterPosition)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_cont, fragment2)
            .addToBackStack(null)
            .commit()
    }

    override fun openAct(position: String) {
        val intent = Intent("MainActivity2")
        intent.putExtra("key2", position)

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "The is no activity to perform the action", Toast.LENGTH_SHORT).show()
        }

    }
}




