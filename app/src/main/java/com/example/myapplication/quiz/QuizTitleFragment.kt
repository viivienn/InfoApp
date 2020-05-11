package com.example.myapplication.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentQuizTitleBinding


class QuizTitleFragment : Fragment() {
    private val args: QuizTitleFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentQuizTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz_title, container, false
        )

        binding.backButton.setOnClickListener{ view ->
            view.findNavController().navigateUp()
        }

//        val back = binding.backButton as ImageButton
//        back.setOnClickListener(view: View ->
//            viewonBackPressed()
//        )

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
