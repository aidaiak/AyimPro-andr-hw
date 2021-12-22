package com.aid.ayimpro_andr_hw

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment_2) {
    private lateinit var txt: AppCompatTextView
    private lateinit var btn: AppCompatButton
    private lateinit var listener: OnClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt = view.findViewById(R.id.frg2_txt)
        btn = view.findViewById(R.id.frg2_btn)

        val text = arguments?.getString("key") ?: "defaultText"
        txt.text = text

        btn.setOnClickListener {
            listener.openAct(text)
            }

        }
}