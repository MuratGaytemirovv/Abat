package com.weeprogram.abat.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Alphabet::class, Word::class], version = 1, exportSchema = false)
abstract class AbatDatabase: RoomDatabase() {
    abstract val alphabetDAO: AlphabetDAO
    abstract val wordDAO: WordDAO

    companion object {

        @Volatile
        private var INSTANCE: AbatDatabase? = null

        fun getInstance(context: Context): AbatDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AbatDatabase::class.java,
                        "abat_database")

                        .fallbackToDestructiveMigration()
                        .createFromAsset("database/abat_database.db")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}