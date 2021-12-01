package com.weeprogram.abat.database

import androidx.lifecycle.LiveData

class AlphabetRepository(private val alphabetDAO: AlphabetDAO) {

    fun getAllLetters(): LiveData<List<Alphabet>> = alphabetDAO.getAllLetters()

}