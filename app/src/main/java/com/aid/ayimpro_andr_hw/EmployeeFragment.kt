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
            val e = dbInstance.employeeDao().getById(1L)
            name.text = e.name
            company.text = e.company
            salary.text = e.salary.toString()

            btnDelete.setOnClickListener {
                dbInstance.employeeDao().delete(e)
                listener.goInputFragment()
            }

            btnEdit.setOnClickListener {
                dbInstance.employeeDao().update(e)
                listener.goInputFragment()
            }
        }

        val text = arguments?.getString("key") ?: "defaultText"
        binding.name.text = text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}