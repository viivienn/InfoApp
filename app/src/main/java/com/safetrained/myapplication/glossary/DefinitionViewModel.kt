package com.safetrained.myapplication.glossary

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.safetrained.myapplication.data.GlossaryRepository

class DefinitionViewModel internal constructor(
    glossaryRepository: GlossaryRepository,
    private val savedStateHandle: SavedStateHandle,
    private val wordId: String
) : ViewModel() {
    val word = glossaryRepository.getWord(wordId)
}
