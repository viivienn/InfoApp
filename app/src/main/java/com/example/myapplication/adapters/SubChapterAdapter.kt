package com.example.myapplication.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.SubChapter
import com.example.myapplication.databinding.ListItemSubchapterBinding
import com.example.myapplication.subChapterList.SubChapterListFragmentDirections

class SubChapterAdapter : ListAdapter<SubChapter, RecyclerView.ViewHolder>(SubChapterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SubChapterViewHolder(ListItemSubchapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val subChapter = getItem(position)
        (holder as SubChapterViewHolder).bind(subChapter)
    }

    class SubChapterViewHolder(
        private val binding: ListItemSubchapterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.subChapter?.let { subchapter ->
                    if(subchapter.title == "Quiz"){
                        navigateToQuiz(subchapter, it)
                    }
                    else if(subchapter.title == "Checklist"){
                        navigateToChecklist(subchapter, it)
                    }
                    else{
                        navigateToSubChapterDetail(subchapter, it)
                    }
                }
            }
        }

        private fun navigateToChecklist(
            subchapter: SubChapter,
            view: View
        ) {
            val direction = SubChapterListFragmentDirections.actionSubChapterListFragmentToChecklistFragment(
                subchapter.subChapterId, subchapter.parentChapterId
            )
            view.findNavController().navigate(direction)
        }
        private fun navigateToQuiz(
            subchapter: SubChapter,
            view: View
        ) {
            val direction = SubChapterListFragmentDirections.actionSubChapterListFragmentToQuizTitleFragment(
                subchapter.subChapterId, subchapter.parentChapterId
            )
            view.findNavController().navigate(direction)
        }

        private fun navigateToSubChapterDetail(
            subchapter: SubChapter,
            view: View
        ) {
            val direction = subchapter.parentChapterId?.let {
                SubChapterListFragmentDirections.actionSubChapterListFragmentToSubChaptertDetailFragment(subchapter.subChapterId,
                    it
                )
            }
            view.findNavController().navigate(direction)
        }

        fun bind(item: SubChapter) {
            binding.apply {
                subChapter = item
                executePendingBindings()
            }
        }
    }
}

private class SubChapterDiffCallback : DiffUtil.ItemCallback<SubChapter>() {

    override fun areItemsTheSame(oldItem: SubChapter, newItem: SubChapter): Boolean {
        return oldItem.subChapterId == newItem.subChapterId
    }

    override fun areContentsTheSame(oldItem: SubChapter, newItem: SubChapter): Boolean {
        return oldItem == newItem
    }
}