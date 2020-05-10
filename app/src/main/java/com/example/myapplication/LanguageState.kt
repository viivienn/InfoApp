package com.example.myapplication

import android.app.Application;
import android.content.Context
import kotlin.time.measureTime

class LanguageState: Application() {
    private lateinit var ulang : String
    private var option = -1

     fun setLang(lang:String){
        ulang = lang
    }

    fun getLang(): String {
        return ulang
    }

    fun getOption(): Int {
        if (ulang=="en"){
            option = 0
            return option
        }
        else{
            option = 1
            return option
        }
    }


    companion object {
        val instance = LanguageState()
    }

}