package com.weeprogram.abat.database

import androidx.lifecycle.LiveData

class WordRepository(private val wordDAO: WordDAO) {

    suspend fun insert(word: Word) =
        wordDAO.insert(word)

    suspend fun update(word: Word) =
        wordDAO.insert(word)

    suspend fun delete(word: Word) =
        wordDAO.insert(word)

    fun getAllWords(): LiveData<List<Word>> = wordDAO.getAllWords()

    suspend fun clear() =
        wordDAO.clear()
}