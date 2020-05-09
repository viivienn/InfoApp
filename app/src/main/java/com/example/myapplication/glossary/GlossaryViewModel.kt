package com.example.myapplication.glossary

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Chapter
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.data.GlossaryRepository
import com.example.myapplication.data.Word

class GlossaryViewModel internal constructor(
    glossaryRepository: GlossaryRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val words: LiveData<List<Word>> = glossaryRepository.getWords()

}
