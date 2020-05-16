package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.Question
import com.example.myapplication.databinding.ListItemResultBinding

class GameAdapter : ListAdapter<Question, RecyclerView.ViewHolder>(QuestionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return QuestionViewHolder(ListItemResultBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val question = getItem(position)
        (holder as QuestionViewHolder).bind(question)
    }

    class QuestionViewHolder(
        private val binding: ListItemResultBinding
    ) : RecyclerView.ViewHolder(binding.root) {
//        init {
//            binding.setClickListener {
//                binding.question?.let { subchapter ->
//                    if(subchapter.title.contains("Quiz")){
//                        navigateToQuiz(subchapter, it)
//                    }
//                    else if(subchapter.title.contains("Checklist")){
//                        navigateToChecklist(subchapter, it)
//                    }
//                    else{
//                        navigateToQuestionDetail(subchapter, it)
//                    }
//                }
//            }
//        }

        fun bind(item: Question) {
            binding.apply {
                question = item
                executePendingBindings()
            }
        }
    }
}

private class QuestionDiffCallback : DiffUtil.ItemCallback<Question>() {

    override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
        return oldItem.questionId == newItem.questionId
    }

    override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
        return oldItem == newItem
    }
}