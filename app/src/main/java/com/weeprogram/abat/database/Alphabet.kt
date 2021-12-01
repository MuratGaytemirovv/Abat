package com.weeprogram.abat.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alphabet")
data class Alphabet(
    @PrimaryKey(autoGenerate = true)
    var letterId: Int = 0,
    @ColumnInfo(name = "letter_from_alphabet")
    var letter: String

)
