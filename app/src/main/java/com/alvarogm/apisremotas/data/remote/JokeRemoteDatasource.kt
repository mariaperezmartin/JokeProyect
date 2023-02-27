package com.alvarogm.apisremotas.data.remote

import com.alvarogm.apisremotas.data.remote.ApiService

class JokeRemoteDatasource(private val apiService: ApiService) {
 suspend fun getJoke (category: String,lang:String, amount: Int) = apiService.getJoke(category,lang,amount)
 suspend fun getOneJoke (category: String,amount: Int) = apiService.getOneJoke(category,amount)


}