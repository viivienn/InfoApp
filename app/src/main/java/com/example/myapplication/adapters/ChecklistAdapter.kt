package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemChapterBinding
import com.example.myapplication.databinding.ListItemChecklistBinding


class ChecklistAdapter : ListAdapter<String, RecyclerView.ViewHolder>(ChecklistDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ChecklistViewHolder(ListItemChecklistBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val checklist = getItem(position)
        (holder as ChecklistViewHolder).bind(checklist)
    }

    class ChecklistViewHolder(
        private val binding: ListItemChecklistBinding
    ) : RecyclerView.ViewHolder(binding.root) {
//        init {
//            binding.setClickListener {
//                binding?.let { checkbox ->
//
//
//                }
//            }
//        }
        fun bind(item: String) {
            binding.apply {
                 checkbox = item
                executePendingBindings()
            }
        }
    }
}

private class ChecklistDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}