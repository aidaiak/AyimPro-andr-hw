package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frg_cont, LoginFragment())
            .commit()
    }

    override fun goHomepage() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_cont, HomePageFragment())
            .commit()
    }
}
