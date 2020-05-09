package com.example.myapplication.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myapplication.data.Question
//import com.example.myapplication.databinding.FragmentGameBinding
//import com.example.myapplication.databinding.FragmentGameWonBinding
//import com.example.myapplication.databinding.ListItemChecklistBinding
//import com.example.myapplication.databinding.ListItemQuizBinding
//
//class GameAdapter : ListAdapter<String, RecyclerView.ViewHolder>(GameDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return GameViewHolder(
//            ListItemQuizBinding.inflate(
//            LayoutInflater.from(parent.context), parent, false))
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val checklist = getItem(position)
//        (holder as GameViewHolder).bind(checklist)
//    }
//
//    class GameViewHolder(
//        private val binding: ListItemQuizBinding,
//        private val gbinding: FragmentGameBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
//        //        init {
////            binding.setClickListener {
////                binding?.let { checkbox ->
////
////
////                }
////            }
////        }
//        fun bind(item: String) {
//            binding.apply {
//                question = item
//                executePendingBindings()
//            }
//        }
//    }
//}
//
//private class GameDiffCallback : DiffUtil.ItemCallback<String>() {
//
//    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
//        return oldItem == newItem
//    }
//
//    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
//        return oldItem == newItem
//    }
//}