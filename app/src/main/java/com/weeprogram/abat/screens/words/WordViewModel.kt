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

    var idWord = MutableLiveData<Int>()


    private var _showAlertDialog = MutableLiveData<Boolean?>()

    val showAlertDialog: LiveData<Boolean?>
        get() = _showAlertDialog

    init {
        _showAlertDialog.value = false
        idWord.value = 0
        viewModelScope.launch {
            val oldWord = getWordFromDatabase(2)
            print(oldWord)
        }
    }




    private suspend fun update(word: Word) {
        database.update(word)
    }

    fun onWordClicked(id: Int) {
        _showAlertDialog.value = true
        idWord.value = id
    }

    fun onClickOk(newWord: String) {
        viewModelScope.launch {
            val oldWord = getWordFromDatabase(idWord.value!!)
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