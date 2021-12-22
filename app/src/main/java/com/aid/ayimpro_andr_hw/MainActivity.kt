package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
}

