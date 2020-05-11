package com.example.myapplication.chapterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.myapplication.adapters.ChapterAdapter
import com.example.myapplication.databinding.FragmentChapterListBinding
import com.example.myapplication.utilities.InjectorUtils


class ChapterListFragment : Fragment() {

    private val viewModel: ChapterListViewModel by viewModels {
        InjectorUtils.provideChapterListViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentChapterListBinding.inflate(inflater, container, false)


        context ?: return binding.root

        val adapter = ChapterAdapter()
        binding.chapterList.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }


    private fun subscribeUi(adapter: ChapterAdapter) {
        viewModel.chapters.observe(viewLifecycleOwner) { chapters ->
            adapter.submitList(chapters)
        }
    }

}





