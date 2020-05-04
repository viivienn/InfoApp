package com.example.myapplication.ui.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel() {
    private val _languageClicked = MutableLiveData<Boolean>()

    fun onLanguage() {
        _languageClicked.value = true
    }
}