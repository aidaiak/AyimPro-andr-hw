package com.aid.ayimpro_andr_hw

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aid.ayimpro_andr_hw.databinding.EmployeeListBinding

class EmployeeListFragment: Fragment(R.layout.employee_list) {
    private var _binding: EmployeeListBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EmployeeListBinding.bind(view)

        binding.recycler
        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = Adapter{
            listener.goEmployeeFragment("ITEM - $it")
        }

        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = adapter
        binding.recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("ITEM - $i")
        }
        adapter.setData(list)
    }
}