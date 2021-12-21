package com.weeprogram.abat.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDAO {

    @Insert
    suspend fun insert(word: Word)

    @Update
    suspend fun update(word: Word)

    @Delete
    suspend fun delete(word: Word)

    @Query("SELECT * from words WHERE wordId = :key")
    suspend fun get(key: Int): Word?

    @Query("SELECT * FROM words ORDER BY wordId ASC")
    fun getAllWords(): LiveData<List<Word>>


    @Query("DELETE FROM words")
    suspend fun clear()
}