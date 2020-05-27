package com.safetrained.myapplication.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.safetrained.myapplication.data.*
import com.safetrained.myapplication.utilities.CHAPTER_DATA_FILENAME
import com.safetrained.myapplication.utilities.GLOSSARY_DATA_FILENAME
import com.safetrained.myapplication.utilities.QUESTION_DATA_FILENAME
import com.safetrained.myapplication.utilities.SUB_CHAPTER_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope


class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            val database = AppDatabase.getInstance(applicationContext)
            applicationContext.assets.open(CHAPTER_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val chapterType = object : TypeToken<List<Chapter>>() {}.type
                    val chapterList: List<Chapter> = Gson().fromJson(jsonReader, chapterType)
                    database.chapterDao().insertAll(chapterList)

                    applicationContext.assets.open(SUB_CHAPTER_DATA_FILENAME).use { inputStream ->
                        JsonReader(inputStream.reader()).use { jsonReader ->
                            val subChapterType = object : TypeToken<List<SubChapter>>() {}.type
                            val subChapterList: List<SubChapter> =
                                Gson().fromJson(jsonReader, subChapterType)
                            database.chapterDao().insertAllSubChapters(subChapterList)
                            Result.success()
                        }
                    }

                    applicationContext.assets.open(QUESTION_DATA_FILENAME).use { inputStream ->
                        JsonReader(inputStream.reader()).use { jsonReader ->
                            val questionType = object : TypeToken<List<Question>>() {}.type
                            val questionList: List<Question> =
                                Gson().fromJson(jsonReader, questionType)
                            database.chapterDao().insertAllQuestions(questionList)
                            Result.success()
                        }
                    }

                    applicationContext.assets.open(GLOSSARY_DATA_FILENAME).use { inputStream ->
                        JsonReader(inputStream.reader()).use { jsonReader ->
                            val wordType = object : TypeToken<List<Word>>() {}.type
                            val WordList: List<Word> =
                                Gson().fromJson(jsonReader, wordType)
                            database.glossaryDao().insertAllWords(WordList)
                            Result.success()
                        }
                    }


                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private val TAG = SeedDatabaseWorker::class.java.simpleName
    }
}