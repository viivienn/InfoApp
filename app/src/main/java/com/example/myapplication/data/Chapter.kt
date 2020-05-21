package com.example.myapplication.data

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "chapters")
data class Chapter(
    @PrimaryKey @ColumnInfo(name = "chapterId") val chapterId: String,
    val title: String,
    val image: String,
    val image_sub: String,
    val lang: String,
    val checklist: List<String>
)


@Entity(tableName = "subchapters",
    foreignKeys= [ForeignKey(
    entity=Chapter::class,
    parentColumns= ["chapterId"],
    childColumns= ["parentChapterId"],
    onDelete=CASCADE
)],
    indices = [(Index(value = ["subChapterId"]))]
)
data class SubChapter(
    @PrimaryKey @ColumnInfo(name = "subChapterId") val subChapterId: String,
    @ColumnInfo(name = "parentChapterId") val parentChapterId: String,
    val title: String,
    val image: String,
    val content: String
)

@Entity(tableName = "questions",
    foreignKeys= [ForeignKey(
        entity=Chapter::class,
        parentColumns= ["chapterId"],
        childColumns= ["parentChapterId"],
        onDelete=CASCADE
    )],
    indices = [(Index(value = ["questionId"]))]
)
data class Question(
    @PrimaryKey @ColumnInfo(name = "questionId") val questionId: Int,
    @ColumnInfo(name = "parentChapterId") val parentChapterId: String,
    val question: String,
    val choices: List<String>,
    val answer: String
)
//class Converters {
//    @TypeConverter
//    fun fromString(value: String?): List<String> {
//        val listType =
//            object : TypeToken<List<String?>?>() {}.type
//        return Gson().fromJson(value, listType)
//    }
//
//    @TypeConverter
//    fun fromArrayList(list: List<String?>?): String {
//        val gson = Gson()
//        return gson.toJson(list)
//    }
//}
//class Converters {
//    @TypeConverter
//    fun fromTimestamp(value: Long?): Date? {
//        return value?.let { Date(it) }
//    }
//
//    @TypeConverter
//    fun dateToTimestamp(date: Date?): Long? {
//        return date?.time?.toLong()
//    }
//}
//class SubChapterConvertor {
//    companion object {
//
//        private val gson = Gson()
//
//        @JvmStatic
//        @TypeConverter
//        fun stringToSubChapter(data: String): SubChapter {
//            val convertData = JSONArray(data)
//            var list: SubChapter? = null
//            for (i in 0 until convertData.length()) {
//                val convertValue = convertData.getJSONObject(i)
//                list = SubChapter(convertValue.get("subChapterId").toString(),
//                    convertValue.get("parentChapterId").toString(),
//                    convertValue.get("title").toString(),
//                    convertValue.get("image").toString(),
//                    convertValue.get("content").toString()
//                )
//
//            }
//
//            return list!!
//        }
//
//        @JvmStatic
//        @TypeConverter
//        fun stringToList(data: String): List<SubChapter> {
//            val convertData = JSONArray(data)
//            val list = ArrayList<SubChapter>()
//            for (i in 0 until convertData.length()) {
//                val convertValue = convertData.getJSONObject(i)
//                list.add(SubChapter(convertValue.get("subChapterId").toString(),
//                    convertValue.get("parentChapterId").toString(),
//                    convertValue.get("title").toString(),
//                    convertValue.get("image").toString(),
//                    convertValue.get("content").toString()
//                    )
//                )
//            }
//
//            return list
//        }
//
//        @TypeConverter
//        @JvmStatic
//        fun listToString(someObjects: SubChapter): String {
//            return gson.toJson(someObjects)
//        }
//
//        @TypeConverter
//        @JvmStatic
//        fun listToString(someObjects: List<SubChapter>): String {
//            return gson.toJson(someObjects)
//        }
//
//    }
//}

