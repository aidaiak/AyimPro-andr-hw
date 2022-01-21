package com.aid.ayimpro_andr_hw

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class EmployeeFragment : Fragment(R.layout.employee) {
    private val dbInstance get() = Injector.database

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtName = view.findViewById<AppCompatTextView>(R.id.name)
        val txtCompany = view.findViewById<AppCompatTextView>(R.id.company)
        val txtSalary = view.findViewById<AppCompatTextView>(R.id.salary)

        val e = dbInstance.employeeDao().getById(2L)
        txtName.text = e.name
        txtCompany.text = e.company
        txtSalary.text = e.salary.toString()
    }
}