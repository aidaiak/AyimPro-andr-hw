package com.aid.ayimpro_andr_hw

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment


class About : Fragment(R.layout.about_page) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar: androidx.appcompat.widget.Toolbar = view.findViewById(R.id.toolbar_about)
        toolbar.inflateMenu(R.menu.about_menu)

        toolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
        toolbar.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frg_cont, HomePage())
                .addToBackStack(null)
                .commit()
        }
    }
}