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
            .add(R.id.frg_cont, EmployeeListFragment())
            .commit()
    }

    override fun goEmployeeList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_cont, EmployeeListFragment())
            .commit()
    }

    override fun goInputFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_cont, InputFragment())
            .commit()
    }

    override fun goEmployeeFragment(id: Long) {
        val employeeFragment = EmployeeFragment()
        val bundle = Bundle()
        bundle.putLong("ID", id)
        employeeFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_cont, employeeFragment)
            .commit()
    }

    override fun editEmployee(id: Long) {
        val editEmployee = EmployeeEditFragment()
        val bundle = Bundle()
        bundle.putLong("KEY_E", id)
        editEmployee.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.frg_cont, editEmployee)
            .commit()
    }

    override fun deleteEmployee(id: Long) {
        val deleteEmployee = EmployeeDeleteFragment()
        val bundle = Bundle()
        bundle.putLong("KEY_D", id)
        deleteEmployee.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.frg_cont, deleteEmployee)
            .commit()
    }
}