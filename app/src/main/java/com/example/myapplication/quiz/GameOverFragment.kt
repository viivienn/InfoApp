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
import com.example.myapplication.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {
    private val args: GameOverFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_over, container, false)
        binding.tryAgainButton.setOnClickListener {
                view: View ->
            view.findNavController().navigate(GameOverFragmentDirections.actionGameOverFragmentToQuizTitleFragment(args.parentChapterId))
        }
        return binding.root
    }
}
