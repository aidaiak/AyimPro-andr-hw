package com.aid.ayimpro_andr_hw.ui.main


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aid.ayimpro_andr_hw.R
import com.aid.ayimpro_andr_hw.ui.Navigate
import com.aid.ayimpro_andr_hw.ui.details.CharacterDetailsFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aid.ayimpro_andr_hw.databinding.CharactersListBinding
import com.aid.ayimpro_andr_hw.ui.Events

class CharacterListFragment : Fragment(R.layout.characters_list) {
    private var _binding: CharactersListBinding? = null
    private val binding get() = _binding!!

    private lateinit var vm: MainViewModel
    private lateinit var listener: Navigate

    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[MainViewModel::class.java]
        listener = context as Navigate
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = CharactersListBinding.bind(view)

        setupViews()
        subscribeToLiveData()
    }

    private fun setupViews() {
        adapter = Adapter {
            listener.openFragment(CharacterDetailsFragment.newInstance(it))
        }

        binding.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

            swipeRefreshLayout.setOnRefreshListener { vm.loadCharacters() }
        }
    }

    private fun subscribeToLiveData() {
        vm.charactersLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        vm.event.observe(viewLifecycleOwner) {
            when(it) {
                is Events.ShowToast ->
                    Toast.makeText(requireContext(), getString(it.resId), Toast.LENGTH_SHORT).show()
                is Events.ShowLoading -> binding.swipeRefreshLayout.isRefreshing = true
                is Events.StopLoading -> binding.swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}