package com.weeprogram.abat.screens.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel: ViewModel() {

    private val _navigateToMoreApps = MutableLiveData<Boolean>()
    val navigateToAlphabet : LiveData<Boolean>
        get() {return _navigateToMoreApps}

    init {
        _navigateToMoreApps.value = false
    }

    fun btnNavigateToMoreAppsClicked() {
        _navigateToMoreApps.value = true
    }

    fun navigateToMoreAppsFinished() {
        _navigateToMoreApps.value = false
    }
}