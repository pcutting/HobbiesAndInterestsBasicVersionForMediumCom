package com.philipcutting.hobbiesandinterestsbasic

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.philipcutting.hobbiesandinterestsbasic.databinding.FragmentHobbiesBinding
import com.philipcutting.hobbiesandinterestsbasic.models.Hobby

class HobbiesFragment: Fragment(R.layout.fragment_hobbies), HobbyNewDialogFragment.OnClickListener {

    private val TAG = "HobbiesFragment"
    private lateinit var fragmentHobbiesBinding: FragmentHobbiesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentHobbiesBinding.bind(view)
        fragmentHobbiesBinding = binding
        binding.fab.setOnClickListener {
            Log.d(TAG, "Fab clicked.")
            showDialog()
        }

        binding.hobbiesList.adapter = HobbiesViewAdapter()
        binding.hobbiesList.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)


        val bar = (activity as AppCompatActivity).supportActionBar
        bar?.title = "AboutMe Hobbies"
    }

    private fun showDialog() {
        val dialog = HobbyNewDialogFragment.create(this)
        dialog.show(parentFragmentManager, "HobbyDialogFragment")
    }

    override fun onDialogPositiveClick(hobby: Hobby?) {
        Log.d(TAG, "OnDialogPositiveClick -> Save button clicked: $hobby")
        // Do anything you want with hobby.  remember it's nullable here.
    }

    override fun onDialogNegativeClick(hobby: Hobby?) {
        Log.d(TAG, "onDialogNegativeClick -> cancel button clicked.")
        // If you can think of something useful for a potentially entered description that was
        // followed by a cancel click... put it here.
    }


}