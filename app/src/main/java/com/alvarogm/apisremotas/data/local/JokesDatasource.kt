package com.alvarogm.apisremotas.data.local

import android.content.Context
import com.alvarogm.apisremotas.data.JokeClass
import com.alvarogm.apisremotas.data.local.Jokes
import com.alvarogm.apisremotas.data.local.getDatabase
import kotlinx.coroutines.flow.Flow

class JokesDatasource constructor (private val applicationContext : Context) {
    fun getJokes(): Flow<List<Jokes>> {
        val db = getDatabase(applicationContext )
        return db.jokesDao().getAll()
    }

    suspend fun createJoke(joke: String) {
        val db = getDatabase(applicationContext )
        db.jokesDao().insert(Jokes( joke = joke))
    }
    suspend fun deleteJoke(jokes: Jokes) {
        val db = getDatabase(applicationContext )
        db.jokesDao().delete(jokes)
    }
}