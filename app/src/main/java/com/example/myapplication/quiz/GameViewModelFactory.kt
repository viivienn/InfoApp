package com.example.myapplication.quiz

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.subChapterList.SubChapterListViewModel

class GameViewModelFactory(
    private val parentChapterId: String,
    private val repository: ChapterRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return GameViewModel(repository, handle, parentChapterId) as T
    }
}