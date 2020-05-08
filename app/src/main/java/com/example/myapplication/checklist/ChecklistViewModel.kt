package com.example.myapplication.checklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Chapter
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.data.SubChapter

class ChecklistViewModel internal constructor(
    chapterRepository: ChapterRepository,
    private val savedStateHandle: SavedStateHandle,
    private val parentChapterId: String
) : ViewModel() {
    val chapter: LiveData<Chapter> = chapterRepository.getChapter(parentChapterId)
}
