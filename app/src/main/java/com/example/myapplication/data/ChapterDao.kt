package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChapterDao {
    @Query("SELECT * FROM chapters WHERE lang = :lang ORDER BY chapterId")
    fun getChapters(lang: String): LiveData<List<Chapter>>

    @Query("SELECT * FROM subchapters WHERE parentChapterId = :parentChapterId ORDER BY title")
    fun getSubChapters(parentChapterId: String): LiveData<List<SubChapter>>

    @Query("SELECT title FROM chapters WHERE chapterId = :chapterId")
    fun getChapterTitle(chapterId: String): LiveData<String>

    @Query("SELECT * FROM chapters WHERE chapterId = :chapterId ORDER BY chapterId LIMIT 1")
    fun getChapter(chapterId: String): LiveData<Chapter>

    @Query("SELECT * FROM subchapters WHERE parentChapterId = :parentChapterId AND subChapterId = :subChapterId ORDER BY subChapterId LIMIT 1")
    fun getSubChapter(subChapterId: String, parentChapterId:String): LiveData<SubChapter>

    @Query("SELECT * FROM questions WHERE parentChapterId = :parentChapterId ORDER BY questionid")
    fun getQuestions(parentChapterId: String): List<Question>

    @Query("SELECT * FROM questions WHERE parentChapterId = :parentChapterId AND questionId = :questionId ORDER BY questionId LIMIT 1")
    fun getQuestion(questionId: String, parentChapterId: String): LiveData<Question>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(chapters: List<Chapter>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSubChapters(subChapters: List<SubChapter>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllQuestions(subChapters: List<Question>)
}