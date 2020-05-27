package com.safetrained.myapplication.subChapterList

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.safetrained.myapplication.data.ChapterRepository

class SubChapterListViewModelFactory(
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
        return SubChapterListViewModel(repository, handle, parentChapterId) as T
    }
}