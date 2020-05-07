package com.example.myapplication.chapterList

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Chapter
import com.example.myapplication.data.ChapterRepository

class ChapterListViewModel internal constructor(
    chapterRepository: ChapterRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val chapters: LiveData<List<Chapter>> = chapterRepository.getChapters()

}
