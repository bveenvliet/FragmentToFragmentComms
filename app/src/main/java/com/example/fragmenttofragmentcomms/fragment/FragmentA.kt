package com.example.fragmenttofragmentcomms.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.fragmenttofragmentcomms.R

class FragmentA : Fragment() {
    private lateinit var listener: FragmentAListener
    private lateinit var btnOk: Button
    private lateinit var etMessage: EditText

    interface FragmentAListener {
        fun onFragmentAOkClicked(input: CharSequence)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false).apply {
            etMessage = findViewById(R.id.etMessage)
            btnOk = findViewById(R.id.btnOk)
            btnOk.setOnClickListener {
                listener.onFragmentAOkClicked(etMessage.text)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = when (context) {
            is FragmentAListener -> context
            else -> throw NotImplementedError("Interface not implemented")
        }
    }

    fun update(input: CharSequence) {
        etMessage.setText(input)
    }

}