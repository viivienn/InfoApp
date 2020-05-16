package com.example.myapplication.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.adapters.GameAdapter
import com.example.myapplication.adapters.SubChapterAdapter
import com.example.myapplication.databinding.FragmentGameResultsBinding
import com.example.myapplication.databinding.FragmentQuizResultsBinding
import com.example.myapplication.databinding.FragmentSubchapterListBinding
import com.example.myapplication.utilities.InjectorUtils
import kotlinx.android.synthetic.main.list_item_result.view.*

class GameResultsFragment : Fragment() {
    private val args: GameResultsFragmentArgs by navArgs()

    private val viewModel: GameViewModel by viewModels {
        InjectorUtils.provideGameViewModelFactory(this, args.parentChapterId)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        (activity as AppCompatActivity).supportActionBar?.hide()
        val binding = FragmentQuizResultsBinding.inflate(inflater, container, false)
        binding.setLifecycleOwner(this);

        binding.backButton.setOnClickListener{ view ->
            view.findNavController().navigateUp()
        }
        binding.resultText.setText(getString(R.string.correct_res, args.numCorrect.toString(), args.numQuestions.toString()))
        binding.tryAgainButton.setOnClickListener {
                view: View ->
            view.findNavController().navigate(GameResultsFragmentDirections.actionGameWonFragmentToQuizTitleFragment(args.parentChapterId))
        }
        val adapter = GameAdapter(viewModel.questions, args.userAnswers )
        binding.resultsList.adapter = adapter

        // Inflate the layout for this fragment

        return binding.root
    }

}