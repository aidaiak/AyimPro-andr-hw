package com.aid.ayimpro_andr_hw

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.aid.ayimpro_andr_hw.databinding.EmployeeEditBinding

class EmployeeEditFragment: Fragment(R.layout.employee_edit) {
    private var _binding: EmployeeEditBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database
    private lateinit var listener: OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EmployeeEditBinding.bind(view)

        binding.apply {
            val id = arguments?.getLong("KEY_E") ?: -1L
            val e = dbInstance.employeeDao().getById(id)

            btnSave.setOnClickListener {
                    e.name = editName.text.toString()
                    e.company = editCompany.text.toString()
                    e.salary = editSalary.text.toString().toInt()

                Toast.makeText(requireContext(), "User edited", Toast.LENGTH_SHORT).show()
                dbInstance.employeeDao().update(e)
                listener.goEmployeeList()
            }
        }
    }
}