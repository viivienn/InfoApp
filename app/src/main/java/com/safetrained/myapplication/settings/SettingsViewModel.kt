package com.safetrained.myapplication.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    private val _languageClicked = MutableLiveData<Boolean>()

    fun onLanguage() {
        _languageClicked.value = true
    }
}