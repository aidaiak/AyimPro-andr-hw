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

    override fun setImage(image: Int) {
        val fragment2 = supportFragmentManager
            .findFragmentById(R.id.frg2_cont) as? Fragment2
        fragment2?.getImage(image)
    }
}