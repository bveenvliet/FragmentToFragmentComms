package com.example.fragmenttofragmentcomms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmenttofragmentcomms.fragment.FragmentA
import com.example.fragmenttofragmentcomms.fragment.FragmentA.FragmentAListener
import com.example.fragmenttofragmentcomms.fragment.FragmentB
import com.example.fragmenttofragmentcomms.fragment.FragmentB.FragmentBListener

class MainActivity : AppCompatActivity(), FragmentAListener, FragmentBListener {

    private var fragmentA: FragmentA = FragmentA()
    private var fragmentB: FragmentB = FragmentB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_a, fragmentA)
            .replace(R.id.container_b, fragmentB)
            .commit()

    }

    override fun onFragmentAOkClicked(input: CharSequence) {
        fragmentB.update(input)
    }

    override fun onFragmentBOkClicked(input: CharSequence) {
        fragmentA.update(input)
    }

}