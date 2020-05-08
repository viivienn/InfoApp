package com.example.myapplication.checklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.adapters.ChecklistAdapter

import com.example.myapplication.databinding.FragmentChecklistBinding

import com.example.myapplication.utilities.InjectorUtils

class ChecklistFragment : Fragment() {
    private val args: ChecklistFragmentArgs by navArgs()

    private val viewModel: ChecklistViewModel by viewModels {
        InjectorUtils.provideChecklistViewModelFactory(this, args.parentChapterId)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentChecklistBinding.inflate(inflater, container, false)
            .apply {
                toolbar.setNavigationOnClickListener { view ->
                    view.findNavController().navigateUp()
                }

            }

        val adapter = ChecklistAdapter()
        binding.checklistList.adapter = adapter
        subscribeUi(adapter)
//        binding.toolbarLayout.title = viewModel.chapter.value?.title.toString()
//        Log.i("title", viewModel.title.toString())
//        Log.i("title", viewModel.chapter.value?.title.toString())
        return binding.root
    }

    private fun subscribeUi(adapter: ChecklistAdapter) {
        viewModel.chapter.observe(viewLifecycleOwner) { chapter ->
            adapter.submitList(chapter.checklist)
        }
    }
}