package com.safetrained.myapplication.subChapterDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.safetrained.myapplication.data.ChapterRepository

class SubChapterDetailViewModelFactory(
    private val chapterRepository: ChapterRepository,
    private val subChapterId: String,
    private val parentChapterId: String
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SubChapterDetailViewModel(chapterRepository, subChapterId, parentChapterId) as T
    }
}