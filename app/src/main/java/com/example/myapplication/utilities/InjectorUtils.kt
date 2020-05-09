package com.example.myapplication.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.myapplication.chapterList.ChapterListViewModelFactory
import com.example.myapplication.checklist.ChecklistViewModelFactory
import com.example.myapplication.subChapterList.SubChapterListViewModelFactory
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.data.GlossaryRepository
import com.example.myapplication.glossary.DefinitionViewModelFactory
import com.example.myapplication.glossary.GlossaryViewModelFactory
import com.example.myapplication.quiz.GameViewModelFactory
import com.example.myapplication.subChapterDetail.SubChapterDetailViewModelFactory

object InjectorUtils {

    private fun getChapterRepository(context: Context): ChapterRepository {
        return ChapterRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).chapterDao())
    }

    private fun getGlossaryRepository(context: Context): GlossaryRepository {
        return GlossaryRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).glossaryDao())
    }
    fun provideChapterListViewModelFactory(fragment: Fragment): ChapterListViewModelFactory {
        val repository = getChapterRepository(fragment.requireContext())
        return ChapterListViewModelFactory(repository, fragment)
    }

    fun provideGlossaryViewModelFactory(fragment: Fragment): GlossaryViewModelFactory {
        val repository = getGlossaryRepository(fragment.requireContext())
        return GlossaryViewModelFactory(repository, fragment)
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
    fun provideDefinitionViewModelFactory(
        fragment: Fragment,
        wordId: String
    ): DefinitionViewModelFactory {
        val repository = getGlossaryRepository(fragment.requireContext())

        return DefinitionViewModelFactory(wordId, repository, fragment)
    }

    fun provideGameViewModelFactory(
        fragment: Fragment,
        parentChapterId: String
    ): GameViewModelFactory {
        val repository = getChapterRepository(fragment.requireContext())

        return GameViewModelFactory(parentChapterId, repository, fragment)
    }

    fun provideChecklistViewModelFactory(
        fragment: Fragment,
        parentChapterId: String
    ): ChecklistViewModelFactory {
        val repository = getChapterRepository(fragment.requireContext())

        return ChecklistViewModelFactory(parentChapterId, repository, fragment)
    }
}
