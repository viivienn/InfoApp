package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.chapterList.ChapterListFragmentDirections
import com.example.myapplication.data.Chapter
import com.example.myapplication.databinding.ListItemChapterBinding

class ChapterAdapter : ListAdapter<Chapter, RecyclerView.ViewHolder>(ChapterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ChapterViewHolder(ListItemChapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chapter = getItem(position)
        (holder as ChapterViewHolder).bind(chapter)
    }

    class ChapterViewHolder(
        private val binding: ListItemChapterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.chapter?.let { chapter ->
                    navigateToSubChapter(chapter, it)
                }
            }
        }

        private fun navigateToSubChapter(
            chapter:Chapter,
            view: View
        ) {
            val direction =
                ChapterListFragmentDirections.actionNavigationHomeToSubChapterListFragment(
                    chapter.chapterId
                )
            view.findNavController().navigate(direction)
        }

        fun bind(item: Chapter) {
            binding.apply {
                chapter = item
                executePendingBindings()
            }
        }
    }
}

private class ChapterDiffCallback : DiffUtil.ItemCallback<Chapter>() {

    override fun areItemsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
        return oldItem.chapterId == newItem.chapterId
    }

    override fun areContentsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
        return oldItem == newItem
    }
}