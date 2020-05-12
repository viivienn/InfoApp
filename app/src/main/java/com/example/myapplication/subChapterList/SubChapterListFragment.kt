package com.example.myapplication.subChapterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.adapters.SubChapterAdapter
import com.example.myapplication.databinding.FragmentSubchapterListBinding
import com.example.myapplication.utilities.InjectorUtils

class SubChapterListFragment : Fragment() {
    private val args: SubChapterListFragmentArgs by navArgs()

    private val viewModel: SubChapterListViewModel by viewModels {
        InjectorUtils.provideSubChapterListViewModelFactory(this, args.parentChapterId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        (activity as AppCompatActivity).supportActionBar?.hide()
        val binding = FragmentSubchapterListBinding.inflate(inflater, container, false)
            .apply {
                sviewModel = viewModel
                toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

        }
        binding.setLifecycleOwner(this);
//        context ?: return binding.root

        val adapter = SubChapterAdapter()
        binding.subchapterList.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }
    private fun subscribeUi(adapter: SubChapterAdapter) {
        viewModel.subChapters.observe(viewLifecycleOwner) { subChapters ->
            adapter.submitList(subChapters)
        }
    }
}