package com.example.myapplication.glossary

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.data.GlossaryRepository

class DefinitionViewModel internal constructor(
    glossaryRepository: GlossaryRepository,
    private val savedStateHandle: SavedStateHandle,
    private val wordId: String
) : ViewModel() {
    val word = glossaryRepository.getWord(wordId)
}
