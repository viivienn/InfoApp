package com.safetrained.myapplication.quiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.safetrained.myapplication.data.ChapterRepository
import com.safetrained.myapplication.data.Question

class GameViewModel internal constructor(
    chapterRepository: ChapterRepository,
    private val savedStateHandle: SavedStateHandle,
    private val parentChapterId: String
) : ViewModel() {
    val questions: List<Question> = chapterRepository.getQuestions(parentChapterId)
}