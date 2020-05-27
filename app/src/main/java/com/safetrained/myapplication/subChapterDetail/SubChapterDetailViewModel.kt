package com.safetrained.myapplication.subChapterDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.safetrained.myapplication.data.Chapter
import com.safetrained.myapplication.data.ChapterRepository

class SubChapterDetailViewModel(
    chapterRepository: ChapterRepository,
    private val subChapterId: String,
    private val parentChapterId: String
) : ViewModel() {
    val subChapter = chapterRepository.getSubChapter(subChapterId, parentChapterId)

    val chapter: LiveData<Chapter> = chapterRepository.getChapter(parentChapterId)
}
