package com.weeprogram.abat.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface AlphabetDAO {

    @Query("SELECT * from alphabet WHERE letterId = :key")
    suspend fun get(key: Int): Alphabet?

    @Query("SELECT * FROM alphabet ORDER BY letterId ASC")
    fun getAllLetters(): LiveData<List<Alphabet>>
}