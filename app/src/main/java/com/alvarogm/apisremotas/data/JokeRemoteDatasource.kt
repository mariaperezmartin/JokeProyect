package com.alvarogm.apisremotas.data

class JokeRemoteDatasource(private val apiService: ApiService) {
 suspend fun getJoke () = apiService.getJoke()
}