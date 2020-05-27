package com.safetrained.myapplication.glossary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.safetrained.myapplication.adapters.GlossaryAdapter
import com.safetrained.myapplication.databinding.FragmentGlossaryBinding
import com.safetrained.myapplication.utilities.InjectorUtils

class GlossaryFragment : Fragment() {

    private val viewModel: GlossaryViewModel by viewModels {
        InjectorUtils.provideGlossaryViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGlossaryBinding.inflate(inflater, container, false) .apply {
            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }
        }
        context ?: return binding.root

        val adapter = GlossaryAdapter()
        binding.wordList.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }


    private fun subscribeUi(adapter: GlossaryAdapter) {
        viewModel.words.observe(viewLifecycleOwner) { words ->
            adapter.submitList(words)
        }
    }
}



