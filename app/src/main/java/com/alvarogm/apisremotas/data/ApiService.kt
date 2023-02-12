package com.alvarogm.apisremotas.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
// @GET("joke/Any?type=single")
 //var amount: Int
 @GET("joke/Any?lang=en&amount=10")
 suspend fun getJoke(): JokeClass

 @GET("joke/Any?lang=es&amount=14")
 suspend fun getJoke14(): JokeClass

/* @GET("joke/Any?lang=es")
 suspend fun getJoke(@Query("amount") amount: Int): JokeClass */
}