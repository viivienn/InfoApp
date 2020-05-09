package com.example.myapplication.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Chapter
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.data.Question
import com.example.myapplication.data.SubChapter

class GameViewModel internal constructor(
    chapterRepository: ChapterRepository,
    private val savedStateHandle: SavedStateHandle,
    private val parentChapterId: String
) : ViewModel() {
    val questions: List<Question> = chapterRepository.getQuestions(parentChapterId)
}