package com.aid.ayimpro_andr_hw

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.aid.ayimpro_andr_hw.database.Employee

class InputFragment : Fragment(R.layout.input) {
    private val dbInstance get() = Injector.database

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val eName = view.findViewById<AppCompatEditText>(R.id.edit_name)
        val eCompany = view.findViewById<AppCompatEditText>(R.id.edit_company)
        val eSalary = view.findViewById<AppCompatEditText>(R.id.edit_salary)
        val btn = view.findViewById<AppCompatButton>(R.id.btn_save)

        btn.setOnClickListener {
            val e = Employee(
                name = eName.text.toString(),
                company = eCompany.text.toString(),
                salary = eSalary.text.toString().toInt()
            )
            dbInstance.employeeDao().insert(e)
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frg_cont, EmployeeFragment())
                .commit()
        }

    }
}