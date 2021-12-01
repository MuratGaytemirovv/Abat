package com.weeprogram.abat.screens.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weeprogram.abat.screens.about.AboutViewModel

class AboutViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AboutViewModel::class.java)) {
            return AboutViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}