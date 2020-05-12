package com.example.myapplication.subChapterDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.Chapter
import com.example.myapplication.data.ChapterRepository
import kotlinx.coroutines.launch

class SubChapterDetailViewModel(
    chapterRepository: ChapterRepository,
    private val subChapterId: String,
    private val parentChapterId: String
) : ViewModel() {
    val subChapter = chapterRepository.getSubChapter(subChapterId, parentChapterId)

    val chapter: LiveData<Chapter> = chapterRepository.getChapter(parentChapterId)
}
