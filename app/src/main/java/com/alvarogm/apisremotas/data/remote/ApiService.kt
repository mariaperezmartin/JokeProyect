package com.alvarogm.apisremotas.data.remote

import com.alvarogm.apisremotas.data.remote.Joke
import com.alvarogm.apisremotas.data.remote.JokeClass
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
// @GET("joke/Any?type=single")
 //var amount: Int
/*
 @GET("joke/Any?lang=es")
 suspend fun getJoke(@Query("amount") amount: Int,@Query("amount2") amount2: Int): JokeClass
*/

 //@GET("joke/{category}?lang=en")
 @GET("joke/{category}")
 suspend fun getJoke(@Path("category") category: String, @Query("lang") lang: String,@Query("amount") amount: Int): JokeClass

 @GET("joke/{category}?lang=es")
 suspend fun getOneJoke(@Path("category") category: String, @Query("amount") amount: Int): Joke


/* @Query("SELECT * FROM Jokes ")
 fun getAll(): Flow<List<JokeClass>>*/
/* @GET("joke/Any?lang=es&amount=14")
 suspend fun getJoke14(): JokeClass*/

/* @GET("joke/Any?lang=es")
 suspend fun getJoke(@Query("amount") amount: Int): JokeClass */
}