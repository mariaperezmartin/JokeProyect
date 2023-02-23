package com.alvarogm.apisremotas.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.alvarogm.apisremotas.data.local.database.Jokes
import kotlinx.coroutines.flow.Flow

@Dao
interface JokesDao {
    @Query("SELECT * FROM jokes ")
    fun getAll(): Flow<List<Jokes>>
    @Query("SELECT * FROM jokes WHERE joke LIKE :joke ")
    suspend fun findByTitle (joke: String): Jokes
    @Insert
    suspend fun insert(jokes: Jokes)
    @Delete
    suspend fun delete(jokes: Jokes)
}