package com.safetrained.myapplication.data

import com.safetrained.myapplication.LanguageState

class GlossaryRepository private constructor(private val glossaryDao: GlossaryDao) {

    fun getWords() = glossaryDao.getWords(LanguageState.instance.getLang())
    fun getWord(wordId: String) = glossaryDao.getWord(wordId)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: GlossaryRepository? = null

        fun getInstance(glossaryDao: GlossaryDao) =
            instance ?: synchronized(this) {
                instance ?: GlossaryRepository(glossaryDao).also { instance = it }
            }
    }
}