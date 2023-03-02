package com.alvarogm.apisremotas.data.remote

import com.alvarogm.apisremotas.data.remote.Joke
import com.alvarogm.apisremotas.data.remote.JokeClass
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
 @GET("joke/{category}")
 suspend fun getJoke(@Path("category") category: String, @Query("lang") lang: String,@Query("amount") amount: Int): JokeClass

}