package com.alvarogm.apisremotas.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Jokes::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun jokesDao() : JokesDao
}