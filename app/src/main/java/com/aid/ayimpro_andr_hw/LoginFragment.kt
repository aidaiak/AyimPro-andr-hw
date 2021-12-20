package com.aid.ayimpro_andr_hw

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class LoginFragment: Fragment(R.layout.login_page) {
    private lateinit var listener: OnClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editAcc = view.findViewById<AppCompatEditText>(R.id.edit_account)
        val editPwd = view.findViewById<AppCompatEditText>(R.id.edit_pwd)
        val btnSign = view.findViewById<AppCompatButton>(R.id.btn_sign)

        val acc = "johndoe@example.com"
        val pwd = "John123"

        btnSign.setOnClickListener {
            if ((acc == editAcc.text.toString()) && (pwd == editPwd.text.toString())) {
                listener.goHomepage()
            } else {
                Toast.makeText(requireContext(), "Incorrect login or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}