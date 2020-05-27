package com.safetrained.myapplication.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.safetrained.myapplication.R
import com.safetrained.myapplication.data.Question
import com.safetrained.myapplication.databinding.FragmentGameBinding
import com.safetrained.myapplication.utilities.InjectorUtils

class GameFragment : Fragment() {
    private val args: GameFragmentArgs by navArgs()

    private val viewModel: GameViewModel by viewModels {
        InjectorUtils.provideGameViewModelFactory(this, args.parentChapterId)
    }

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    lateinit var questions: MutableList<Question>
    var uAnswers = ""
    private var correct = 0
    private var questionIndex = 0
    private var numQuestions = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

    val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false)
        binding.backButton.setOnClickListener{ view ->
            view.findNavController().navigateUp()
        }
        questions = viewModel.questions.toMutableList()
        numQuestions = questions.size //Math.min((questions.size + 1) / 2, 3)
//         Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.game = this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answer) {
                    correct++
                }

                uAnswers+=answerIndex
                questionIndex++

                // Advance to the next question
                if (questionIndex < numQuestions) {
                    currentQuestion = questions[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                } else {
                    view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment(args.parentChapterId, numQuestions, correct, uAnswers))
                }
//                } else {
//
//                    // Game over! A wrong answer sends us to the gameOverFragment.
//                    view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment(args.parentChapterId))


            }
        }
        return binding.root
    }

//     randomize the questions and set the first question
    private fun randomizeQuestions() {
//        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]

        answers = currentQuestion.choices.toMutableList()
        // and shuffle them
//        answers.shuffle()
//        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_android_trivia_question, questionIndex + 1, numQuestions)
    }
}

