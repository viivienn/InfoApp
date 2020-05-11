package com.example.myapplication.adapters

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemChecklistBinding


class ChecklistAdapter(parentId: String) : ListAdapter<String, RecyclerView.ViewHolder>(ChecklistDiffCallback()) {
    val parentIdValue = parentId
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ChecklistViewHolder(ListItemChecklistBinding.inflate(
            LayoutInflater.from(parent.context), parent, false), parent.context, parentIdValue)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val checklist = getItem(position)
        (holder as ChecklistViewHolder).bind(checklist)
    }

    class ChecklistViewHolder(

        private val binding: ListItemChecklistBinding,
        private val context: Context,
        private val parentId: String
    ) : RecyclerView.ViewHolder(binding.root) {

        var settings: SharedPreferences = context!!.getSharedPreferences("checklists", 0)
                init {
            binding.setClickListener {
                binding?.let { checkbox ->
                    val editor: Editor = settings.edit()
                    editor.putString(parentId + "-" + checkbox.checkBoxItem.text.toString(), checkbox.checkBoxItem.isChecked.toString())
                    editor.apply()
                }
            }
        }
        fun bind(item: String) {
            binding.apply {
                 checkbox = item
                checkBoxItem.isChecked = settings.getString("$parentId-$item", "false")!!.toBoolean();
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