package com.example.myapplication.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.Chapter
import com.example.myapplication.data.SubChapter
import com.example.myapplication.utilities.CHAPTER_DATA_FILENAME
import com.example.myapplication.utilities.SUB_CHAPTER_DATA_FILENAME
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