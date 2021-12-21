package com.weeprogram.abat.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _navigateToAlphabet = MutableLiveData<Boolean>()
    val navigateToAlphabet: LiveData<Boolean>
        get() {
            return _navigateToAlphabet
        }

    init {
        _navigateToAlphabet.value = false
    }

    fun btnNavigateToAlphabetClicked() {
        _navigateToAlphabet.value = true
    }

    fun navigateToAlphabetFinished() {
        _navigateToAlphabet.value = false
    }
}