package com.weeprogram.abat.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "words", foreignKeys = [ForeignKey(
    entity = Alphabet::class,
    parentColumns = arrayOf("letterId"),
    childColumns = arrayOf("letterId"),
    onDelete = ForeignKey.NO_ACTION
)])
data class Word(
    @PrimaryKey(autoGenerate = true)
    var wordId: Int = 0,
    @ColumnInfo(name = "words")
    var word: String,

   // @ForeignKey()
    var letterId: Int

)
