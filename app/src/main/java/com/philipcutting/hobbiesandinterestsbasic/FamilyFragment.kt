package com.philipcutting.hobbiesandinterestsbasic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FamilyFragment: Fragment(R.layout.fragment_family){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bar = (activity as AppCompatActivity).supportActionBar
        bar?.title = "AboutMe My Family"
    }
}