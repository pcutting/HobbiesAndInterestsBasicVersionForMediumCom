package com.philipcutting.hobbiesandinterestsbasic

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import com.philipcutting.hobbiesandinterestsbasic.databinding.FragmentNewHobbyBinding
import com.philipcutting.hobbiesandinterestsbasic.models.Hobby
import com.philipcutting.hobbiesandinterestsbasic.respositories.HobbyRepository
import java.lang.IllegalStateException

class HobbyNewDialogFragment : DialogFragment() {

    private lateinit var onClickListener : OnClickListener

    interface OnClickListener {
        fun onDialogPositiveClick(hobby: Hobby? = null)
        fun onDialogNegativeClick(hobby: Hobby? = null)
    }

    companion object {
        fun create(onClickListener: OnClickListener) : HobbyNewDialogFragment {
            return HobbyNewDialogFragment().apply {
                this.onClickListener = onClickListener
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val layoutInflater = LayoutInflater.from(requireContext())
            val binding = FragmentNewHobbyBinding.inflate(layoutInflater)


            builder.setView(binding.root)
                .setPositiveButton(
                    R.string.save_button
                ) { dialog, id ->

                    val hobbyDescription = binding.editTextDescription.text.toString()
                    //edit_text_description
                    val hobby = Hobby(hobbyDescription)
                    // my font is a fun one from IntelliJ.... ! = becomes !=
                    if (hobbyDescription != "" ) {
                        HobbyRepository.hobbies.add(hobby)
                    }
                    this.onClickListener.onDialogPositiveClick(hobby)
                }
                .setNegativeButton(
                    R.string.cancel_button
                ) { dialog, id ->
                    dismiss()
                    this.onClickListener.onDialogNegativeClick()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}