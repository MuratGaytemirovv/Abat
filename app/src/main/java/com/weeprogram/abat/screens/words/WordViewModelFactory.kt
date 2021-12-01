package com.weeprogram.abat.screens.words

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weeprogram.abat.database.AlphabetDAO
import com.weeprogram.abat.database.WordDAO
import com.weeprogram.abat.screens.alphabet.AlphabetViewModel

class WordViewModelFactory(private val dataSource: WordDAO,
                           private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            return WordViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}