package com.safetrained.myapplication.glossary

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.safetrained.myapplication.data.GlossaryRepository
import com.safetrained.myapplication.data.Word

class GlossaryViewModel internal constructor(
    glossaryRepository: GlossaryRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val words: LiveData<List<Word>> = glossaryRepository.getWords()

}
