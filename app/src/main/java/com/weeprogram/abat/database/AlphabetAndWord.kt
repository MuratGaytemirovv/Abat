package com.weeprogram.abat.database

import androidx.room.Embedded
import androidx.room.Relation

data class AlphabetAndWord (
    @Embedded val alphabet: Alphabet,
    @Relation(
        parentColumn = "letterId",
        entityColumn = "letterId"

    )
    val word: Word


    )

