package com.safetrained.myapplication.subChapterList

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.safetrained.myapplication.data.Chapter
import com.safetrained.myapplication.data.ChapterRepository
import com.safetrained.myapplication.data.SubChapter

class SubChapterListViewModel internal constructor(
    chapterRepository: ChapterRepository,
    private val savedStateHandle: SavedStateHandle,
    private val parentChapterId: String
) : ViewModel() {
    val subChapters: LiveData<List<SubChapter>> = chapterRepository.getSubChapters(parentChapterId)

    val chapter: LiveData<Chapter> = chapterRepository.getChapter(parentChapterId)
}
