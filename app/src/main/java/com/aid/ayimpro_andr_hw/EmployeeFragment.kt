package com.aid.ayimpro_andr_hw

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.aid.ayimpro_andr_hw.databinding.EmployeeBinding

class EmployeeFragment : Fragment(R.layout.employee) {
    private var _binding: EmployeeBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database
    private lateinit var listener: OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EmployeeBinding.bind(view)

        binding.apply {
            val id = arguments?.getLong("ID") ?: -1L
            val e = dbInstance.employeeDao().getById(1L)

            name.text = e.name
            company.text = e.company
            salary.text = e.salary.toString()

            btnDelete.setOnClickListener {
                listener.deleteEmployee(e.id!!)
            }

            btnEdit.setOnClickListener {
                listener.editEmployee(e.id!!)
            }
        }
    }
}