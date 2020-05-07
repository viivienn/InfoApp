package com.example.myapplication.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.myapplication.chapterList.ChapterListViewModelFactory
import com.example.myapplication.subChapterList.SubChapterListViewModelFactory
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.subChapterDetail.SubChapterDetailViewModelFactory

object InjectorUtils {

    private fun getChapterRepository(context: Context): ChapterRepository {
        return ChapterRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).chapterDao())
    }
    fun provideChapterListViewModelFactory(fragment: Fragment): ChapterListViewModelFactory {
        val repository = getChapterRepository(fragment.requireContext())
        return ChapterListViewModelFactory(repository, fragment)
    }

    fun provideSubChapterDetailViewModelFactory(
        context: Context,
        subChapterId: String,
        parentChapterId: String
    ): SubChapterDetailViewModelFactory {
        return SubChapterDetailViewModelFactory(
            getChapterRepository(context), subChapterId, parentChapterId)
    }

    fun provideSubChapterListViewModelFactory(
    fragment: Fragment,
        parentChapterId: String
    ): SubChapterListViewModelFactory {
        val repository = getChapterRepository(fragment.requireContext())

    return SubChapterListViewModelFactory(parentChapterId, repository, fragment)
    }
}
