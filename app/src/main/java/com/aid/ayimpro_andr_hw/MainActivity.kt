package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frg1_cont, Fragment1())
            .add(R.id.frg2_cont, Fragment2())
            .commit()
    }

    override fun setText1(enteredText : String) {
        val fragment1 = supportFragmentManager.findFragmentById(R.id.frg1_cont) as? Fragment1
        fragment1?.setText2(enteredText)
    }

    override fun setText2(enteredText: String) {
        val fragment2 = supportFragmentManager.findFragmentById(R.id.frg2_cont) as? Fragment2
        fragment2?.setText1(enteredText)
    }
}