package com.alvarogm.apisremotas.data

class JokeRemoteDatasource(private val apiService: ApiService) {
 suspend fun getJoke (category: String,amount: Int) = apiService.getJoke(category,amount)
 suspend fun getOneJoke (category: String,amount: Int) = apiService.getOneJoke(category,amount)


}