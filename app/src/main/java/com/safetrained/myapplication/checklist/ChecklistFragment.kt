package com.safetrained.myapplication.checklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.safetrained.myapplication.adapters.ChecklistAdapter

import com.safetrained.myapplication.databinding.FragmentChecklistBinding

import com.safetrained.myapplication.utilities.InjectorUtils
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fragment_checklist.*

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

                var isShow = true
                var scrollRange = -1
                appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
                    if (scrollRange == -1){
                        scrollRange = barLayout?.totalScrollRange!!
                    }
                    if (scrollRange + verticalOffset == 0){
                        toolbar_layout.title = "Checklist"
                        isShow = true
                    } else if (isShow){
                        toolbar_layout.title = " " //careful there should a space between double quote otherwise it wont work
                        isShow = false
                    }
                })


            }

        val adapter = ChecklistAdapter(args.parentChapterId)
        binding.checklistList.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: ChecklistAdapter) {
        viewModel.chapter.observe(viewLifecycleOwner) { chapter ->
            adapter.submitList(chapter.checklist)
        }
    }
}