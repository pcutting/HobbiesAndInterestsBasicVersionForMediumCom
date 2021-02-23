package com.philipcutting.hobbiesandinterestsbasic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.philipcutting.hobbiesandinterestsbasic.databinding.HobbyItemBinding
import com.philipcutting.hobbiesandinterestsbasic.models.Hobby
import com.philipcutting.hobbiesandinterestsbasic.respositories.HobbyRepository

class HobbiesViewAdapter: RecyclerView.Adapter<HobbiesViewAdapter.>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesViewHolder {
        //  ***** this is the key, very import difference from Activities ****
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HobbyItemBinding.inflate(layoutInflater, parent, false)
        return HobbiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HobbiesViewHolder, position: Int) {
        holder.bind(HobbyRepository.hobbies[position])
    }

    override fun getItemCount() = HobbyRepository.hobbies.size
    }

    class HobbiesViewHolder(
        private val binding: HobbyItemBinding
        ) :  RecyclerView.ViewHolder(binding.root)
    {
        fun bind(hobby: Hobby) {
            binding.descriptionLabel.text = hobby.description
        }
    }

}