package com.safetrained.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.safetrained.myapplication.data.Word
import com.safetrained.myapplication.databinding.ListItemGlossaryBinding
import com.safetrained.myapplication.glossary.GlossaryFragmentDirections

class GlossaryAdapter : ListAdapter<Word, RecyclerView.ViewHolder>(GlossaryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WordViewHolder(
            ListItemGlossaryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val word = getItem(position)
        (holder as WordViewHolder).bind(word)
    }

    class WordViewHolder(
        private val binding: ListItemGlossaryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.word?.let { word ->
                    navigateToDefinition(word, it)
                }
            }
        }

        private fun navigateToDefinition(
            word: Word,
            view: View
        ) {
            val direction =
                GlossaryFragmentDirections.actionNavigationGlossaryToDefinitionFragment(
                    word.wordId
                )
            view.findNavController().navigate(direction)
        }
        fun bind(item: Word) {
            binding.apply {
                word = item
                executePendingBindings()
            }
        }
    }
}

private class GlossaryDiffCallback : DiffUtil.ItemCallback<Word>() {

    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.wordId == newItem.wordId
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem == newItem
    }
}