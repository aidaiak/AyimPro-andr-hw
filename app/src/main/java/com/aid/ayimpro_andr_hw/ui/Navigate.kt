package com.aid.ayimpro_andr_hw.ui

import androidx.fragment.app.Fragment


interface Navigate {
    fun openFragment(fragment: Fragment, addToBackStack: Boolean? = true)
}