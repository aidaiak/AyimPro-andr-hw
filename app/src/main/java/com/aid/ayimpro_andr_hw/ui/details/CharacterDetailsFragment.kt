package com.aid.ayimpro_andr_hw.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aid.ayimpro_andr_hw.R
import com.aid.ayimpro_andr_hw.database.CharacterEntity
import com.aid.ayimpro_andr_hw.databinding.CharacterBinding
import com.aid.ayimpro_andr_hw.ui.Events
import com.bumptech.glide.Glide

class CharacterDetailsFragment : Fragment(R.layout.character) {
    private var _binding: CharacterBinding? = null
    private val binding get() = _binding!!

    private lateinit var vm: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[CharacterViewModel::class.java]

        vm.setId(arguments?.getLong(KEY_ID))
        vm.fetchCharacter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = CharacterBinding.bind(view)

        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        vm.event.observe(viewLifecycleOwner) {
            when (it) {
                is Events.FetchedCharacter -> setupViews(it.character)
            }
        }
    }

    private fun setupViews(character: CharacterEntity) {
        binding.apply {
            Glide.with(requireContext()).load(character.image).into(detailsImg)
            detailsName.text = getString(R.string.name, character.name)
            detailsStatus.text = getString(R.string.status, character.status)
            detailsSpecies.text = getString(R.string.species, character.species)
            detailsType.text = getString(R.string.type, character.type)
            detailsGen.text = getString(R.string.gender, character.gender)
            detailsOrigin.text = getString(R.string.origin, character.origin)
            detailsLoc.text = getString(R.string.location, character.location)
        }
    }

    companion object {
        const val KEY_ID = "id"

        fun newInstance(id: Long): CharacterDetailsFragment {
            val args = Bundle().apply { putLong(KEY_ID, id) }
            return CharacterDetailsFragment().apply { arguments = args }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
