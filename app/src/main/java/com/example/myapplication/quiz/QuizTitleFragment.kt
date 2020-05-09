package com.example.myapplication.quiz

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentQuizTitleBinding
import com.example.myapplication.subChapterList.SubChapterListFragmentArgs

class QuizTitleFragment : Fragment() {
    private val args: QuizTitleFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentQuizTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz_title, container, false
        )

        binding.playButton.setOnClickListener { view: View ->
            view.findNavController().navigate(QuizTitleFragmentDirections.actionQuizTitleFragmentToGameFragment(args.parentChapterId))
        }
        //The complete onClickListener with Navigation using createNavigateOnClickListener
//        binding.playButton.setOnClickListener(
//                Navigation.createNavigateOnClickListener())

        setHasOptionsMenu(true)

        return binding.root

    }
}
