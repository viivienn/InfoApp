package com.example.myapplication.subChapterList

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.data.SubChapter

class SubChapterListViewModel internal constructor(
    chapterRepository: ChapterRepository,
    private val savedStateHandle: SavedStateHandle,
    private val parentChapterId: String
) : ViewModel() {
    val subChapters: LiveData<List<SubChapter>> = chapterRepository.getSubChapters(parentChapterId)

}
