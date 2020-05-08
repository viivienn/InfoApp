package com.example.myapplication.data

import androidx.lifecycle.LiveData

class ChapterRepository private constructor(private val chapterDao: ChapterDao) {

    fun getChapters() = chapterDao.getChapters()

    fun getSubChapters(parentChapterId: String) = chapterDao.getSubChapters(parentChapterId)

    fun getChapter(chapterId: String) = chapterDao.getChapter(chapterId)
//
    fun getSubChapter(subChapterId: String, parentChapterId: String) =  chapterDao.getSubChapter(subChapterId, parentChapterId)

    fun getChapterTile(parentChapterId: String) = chapterDao.getChapterTitle(parentChapterId)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: ChapterRepository? = null

        fun getInstance(chapterDao: ChapterDao) =
            instance ?: synchronized(this) {
                instance ?: ChapterRepository(chapterDao).also { instance = it }
            }
    }
}