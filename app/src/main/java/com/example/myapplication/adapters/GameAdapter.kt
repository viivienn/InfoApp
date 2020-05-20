package com.example.myapplication.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.Question
import com.example.myapplication.databinding.ListItemResultBinding

//class GameAdapter : ListAdapter<Question, RecyclerView.ViewHolder>(QuestionDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return QuestionViewHolder(ListItemResultBinding.inflate(
//            LayoutInflater.from(parent.context), parent, false))
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val question = getItem(position)
//        (holder as QuestionViewHolder).bind(question)
//    }
//
//    class QuestionViewHolder(
//        private val binding: ListItemResultBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
////        init {
////            binding.setClickListener {
////                binding.question?.let { subchapter ->
////                    if(subchapter.title.contains("Quiz")){
////                        navigateToQuiz(subchapter, it)
////                    }
////                    else if(subchapter.title.contains("Checklist")){
////                        navigateToChecklist(subchapter, it)
////                    }
////                    else{
////                        navigateToQuestionDetail(subchapter, it)
////                    }
////                }
////            }
////        }
//
//        fun bind(item: Question) {
//            binding.apply {
//                question = item
//                executePendingBindings()
//            }
//        }
//    }
//}
//
//private class QuestionDiffCallback : DiffUtil.ItemCallback<Question>() {
//
//    override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
//        return oldItem.questionId == newItem.questionId
//    }
//
//    override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
//        return oldItem == newItem
//    }
//}


class GameAdapter(val items : List<Question>, val uAnswer: String) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemResultBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val question = items[position]
        val choice = uAnswer[position].toString().toInt()

        Log.i("choice", choice.toString())
        val uans = question.choices[choice]
        var color = ""
        if(question.answer == uans){
            color = "ff99cc00"
        }else{
            color = "ffff4444"
        }
        (holder as ViewHolder).bind(question, uans, color)
    }

    class ViewHolder(private val binding: ListItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Question, uans: String, col: String) {
            binding.apply {
                question = item
                userAns = uans
                color = col
                executePendingBindings()
            }
        }
    }

}