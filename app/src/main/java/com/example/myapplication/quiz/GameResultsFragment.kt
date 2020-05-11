package com.example.myapplication.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentGameResultsBinding

class GameResultsFragment : Fragment() {
    private val args: GameResultsFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameResultsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_results, container, false)
        binding.backButton.setOnClickListener{ view ->
            view.findNavController().navigateUp()
        }
        binding.resultText.setText(getString(R.string.correct_res, args.numCorrect.toString(), args.numQuestions.toString()))
        binding.tryAgainButton.setOnClickListener {
                view: View ->
            view.findNavController().navigate(GameResultsFragmentDirections.actionGameWonFragmentToQuizTitleFragment(args.parentChapterId))
        }
        return binding.root
    }
}