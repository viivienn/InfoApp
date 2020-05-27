package com.safetrained.myapplication.checklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.safetrained.myapplication.data.Chapter
import com.safetrained.myapplication.data.ChapterRepository

class ChecklistViewModel internal constructor(
    chapterRepository: ChapterRepository,
    private val savedStateHandle: SavedStateHandle,
    private val parentChapterId: String
) : ViewModel() {
    val chapter: LiveData<Chapter> = chapterRepository.getChapter(parentChapterId)
}
