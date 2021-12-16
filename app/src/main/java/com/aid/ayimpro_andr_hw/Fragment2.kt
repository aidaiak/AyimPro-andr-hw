package com.aid.ayimpro_andr_hw

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment_2) {
    private lateinit var listener: OnClickListener
    private lateinit var txt2: AppCompatTextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt2 = view.findViewById(R.id.frg2_txt)
        val edit2 = view.findViewById<AppCompatEditText>(R.id.frg2_edit)
        val btn2 = view.findViewById<AppCompatButton>(R.id.frg2_btn)

        btn2.setOnClickListener {
            listener.setText1(edit2.text.toString())
        }
    }
    fun setText1(value: String) {
        txt2.text = value
    }
}