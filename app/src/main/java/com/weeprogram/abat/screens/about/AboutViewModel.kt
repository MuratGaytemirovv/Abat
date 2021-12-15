package com.weeprogram.abat.screens.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel: ViewModel() {

    private val _navigateToMoreAboutLanguage = MutableLiveData<Boolean>()
    val navigateToAlphabet : LiveData<Boolean>
        get() {return _navigateToMoreAboutLanguage}

    init {
        _navigateToMoreAboutLanguage.value = false
    }

    fun btnNavigateToMoreAboutLanguageClicked() {
        _navigateToMoreAboutLanguage.value = true
    }

    fun navigateToMoreAboutLanguageFinished() {
        _navigateToMoreAboutLanguage.value = false
    }
}