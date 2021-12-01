package com.weeprogram.abat.screens.words

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weeprogram.abat.database.Word
import com.weeprogram.abat.database.WordDAO
import kotlinx.coroutines.launch

class WordViewModel(
    dataSource: WordDAO,
    application: Application) : ViewModel() {

    val database = dataSource
    val words = database.getAllWords()



    private suspend fun insert(word: Word) {
        database.insert(word)
    }

    private suspend fun update(word: Word) {
        database.update(word)
    }

    private suspend fun clear() {
        database.clear()
    }

    private suspend fun delete(word: Word) {
        database.delete(word)
    }

    fun onWordClicked(id: Int, newWord: String) {
        viewModelScope.launch {
            val oldWord = getWordFromDatabase(id)
            if (oldWord != null) {
                oldWord.word = newWord
                update(oldWord)
            }

        }
    }


    private suspend fun getWordFromDatabase(key: Int): Word? {
        return database.get(key)
    }
}