package com.example.myapplication.quiz

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentQuizTitleBinding

class QuizTitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentQuizTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz_title, container, false
        )

//        binding.playButton.setOnClickListener { view: View ->
//            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
//        }
        //The complete onClickListener with Navigation using createNavigateOnClickListener
//        binding.playButton.setOnClickListener(
//                Navigation.createNavigateOnClickListener())

        setHasOptionsMenu(true)

        return binding.root

    }
}
