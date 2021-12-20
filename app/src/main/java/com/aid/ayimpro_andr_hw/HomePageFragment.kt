package com.aid.ayimpro_andr_hw

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class HomePageFragment: Fragment(R.layout.home_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_home)
        toolbar.inflateMenu(R.menu.menu)

        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.menu -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.frg_cont, AboutFragment())
                        .addToBackStack(null)
                        .commit()
                }
            }
            true
        }
    }
}