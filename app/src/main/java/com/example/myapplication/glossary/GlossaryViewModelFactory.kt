package com.example.myapplication.glossary

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.myapplication.chapterList.ChapterListViewModel
import com.example.myapplication.checklist.ChecklistViewModel
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.data.GlossaryRepository

class GlossaryViewModelFactory(
    private val repository: GlossaryRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return GlossaryViewModel(repository, handle) as T
    }
}