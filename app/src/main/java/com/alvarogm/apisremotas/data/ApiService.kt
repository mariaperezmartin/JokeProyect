package com.alvarogm.apisremotas.data

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

 @GET("joke/{category}")
 suspend fun getJoke(@Path("category") category: String, @Query("amount") amount: Int): JokeClass


/* @Query("SELECT * FROM Jokes ")
 fun getAll(): Flow<List<JokeClass>>*/
/* @GET("joke/Any?lang=es&amount=14")
 suspend fun getJoke14(): JokeClass*/

/* @GET("joke/Any?lang=es")
 suspend fun getJoke(@Query("amount") amount: Int): JokeClass */
}