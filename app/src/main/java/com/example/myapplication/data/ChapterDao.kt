package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChapterDao {
    @Query("SELECT * FROM chapters ORDER BY chapterId")
    fun getChapters(): LiveData<List<Chapter>>

    @Query("SELECT * FROM subchapters WHERE parentChapterId = :parentChapterId ORDER BY subChapterId")
    fun getSubChapters(parentChapterId: String): LiveData<List<SubChapter>>

//    @Query("SELECT * FROM chapters WHERE chapterId = :chapterId")
//    fun getChapter(chapterId: String): LiveData<Chapter>
//
    @Query("SELECT * FROM subchapters WHERE parentChapterId = :parentChapterId AND subChapterId = :subChapterId ORDER BY subChapterId LIMIT 1")
    fun getSubChapter(subChapterId: String, parentChapterId:String): LiveData<SubChapter>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(chapters: List<Chapter>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSubChapters(subChapters: List<SubChapter>)
}