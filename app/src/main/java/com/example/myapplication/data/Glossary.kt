package com.example.myapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(
    @PrimaryKey @ColumnInfo(name = "wordId") val wordId: String,
    val word: String,
    val lang: String,
    val definition: String
)