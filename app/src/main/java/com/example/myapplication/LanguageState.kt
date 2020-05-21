package com.example.myapplication

import android.app.Application;
import android.content.Context
import kotlin.time.measureTime

class LanguageState: Application() {
    private lateinit var ulang : String
    private var option = -1

     fun setLang(lang:String){
         if (lang=="fr"){
             option = 1
             ulang = lang
         }else{
             ulang = "en"
             option = 0
         }
    }

    fun getLang(): String {
        return ulang
    }

    fun getOption(): Int {
        return option
    }

    companion object {
        val instance = LanguageState()
    }

}