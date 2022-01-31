package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aid.ayimpro_andr_hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClick {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.frg_cont, InputFragment())
            .commit()
    }

    override fun goEmployeeFragment(adapterPosition: String) {
        val employeeFragment = EmployeeFragment()
        val bundle = Bundle()
        bundle.putString("key", adapterPosition)
        employeeFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_cont, EmployeeFragment())
            .commit()
    }

    override fun goInputFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_cont, InputFragment())
            .commit()
    }
}