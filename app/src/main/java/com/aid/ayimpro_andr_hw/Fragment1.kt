package com.aid.ayimpro_andr_hw

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment1: Fragment(R.layout.fragment_1) {
    private lateinit var listener: OnClickListener
    private lateinit var txt: AppCompatTextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt = view.findViewById(R.id.frg1_txt)
        val edit = view.findViewById<AppCompatEditText>(R.id.frg1_edit)
        val btn = view.findViewById<AppCompatButton>(R.id.frg1_btn)

        btn.setOnClickListener {
            listener.setText2(edit.text.toString())
        }
    }
    fun setText2(value: String) {
        txt.text = value
    }
}