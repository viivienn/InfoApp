package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GlossaryDao {
    @Query("SELECT * FROM words WHERE lang = :lang ORDER BY word")
    fun getWords(lang: String): LiveData<List<Word>>

    @Query("SELECT * FROM words WHERE wordId= :wordId ORDER BY wordId")
    fun getWord(wordId:String): LiveData<Word>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllWords(words: List<Word>)

}