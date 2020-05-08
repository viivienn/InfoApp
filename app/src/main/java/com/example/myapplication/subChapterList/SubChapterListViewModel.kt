package com.example.myapplication.subChapterList

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.Chapter
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.data.SubChapter
import kotlinx.coroutines.launch

class SubChapterListViewModel internal constructor(
    chapterRepository: ChapterRepository,
    private val savedStateHandle: SavedStateHandle,
    private val parentChapterId: String
) : ViewModel() {
    val subChapters: LiveData<List<SubChapter>> = chapterRepository.getSubChapters(parentChapterId)

    val chapter: LiveData<Chapter> = chapterRepository.getChapter(parentChapterId)
}
