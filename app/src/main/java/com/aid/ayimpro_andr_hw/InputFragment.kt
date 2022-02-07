package com.aid.ayimpro_andr_hw

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.aid.ayimpro_andr_hw.database.Employee
import com.aid.ayimpro_andr_hw.databinding.InputBinding

class InputFragment : Fragment(R.layout.input) {
    private var _binding: InputBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database
    private lateinit var listener: OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = InputBinding.bind(view)

        binding.apply {
            btnSave.setOnClickListener {
                val e = Employee(
                    name = inputName.text.toString(),
                    company = inputCompany.text.toString(),
                    salary = inputSalary.text.toString().toInt()
                )
                dbInstance.employeeDao().insert(e)
                listener.goEmployeeList()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}