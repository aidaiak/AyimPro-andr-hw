package com.aid.ayimpro_andr_hw

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.aid.ayimpro_andr_hw.databinding.EmployeeDeleteBinding

class EmployeeDeleteFragment: Fragment(R.layout.employee_delete) {
    private var _binding: EmployeeDeleteBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database
    private lateinit var listener: OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EmployeeDeleteBinding.bind(view)

        binding.apply {
            val id = arguments?.getLong("KEY_D") ?: -1L
            val e = dbInstance.employeeDao().getById(id)

            deleteYes.setOnClickListener {
                dbInstance.employeeDao().delete(e)
                Toast.makeText(requireContext(), "User deleted", Toast.LENGTH_SHORT).show()
                listener.goEmployeeList()
            }

            deleteNo.setOnClickListener {
                listener.goEmployeeList()
            }
        }
    }
}