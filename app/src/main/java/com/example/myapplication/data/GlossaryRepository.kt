package com.example.myapplication.data

class GlossaryRepository private constructor(private val glossaryDao: GlossaryDao) {

    fun getWords() = glossaryDao.getWords()
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