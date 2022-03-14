package com.aid.ayimpro_andr_hw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.aid.ayimpro_andr_hw.databinding.RepoListBinding

class RepoListFragment : Fragment(R.layout.repo_list) {
    private var _binding: RepoListBinding? = null
    private val binding get() = _binding!!
    private val adapter = RecyclerView.Adapter {
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = RepoListBinding.bind(view!!)
        return binding.root
    }
}
