package com.weeprogram.abat.screens.alphabet

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weeprogram.abat.database.AlphabetDAO

class AlphabetViewModelFactory(private val dataSource: AlphabetDAO,
                               private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlphabetViewModel::class.java)) {
            return AlphabetViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}