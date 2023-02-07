package com.alvarogm.apisremotas.presentation

import com.alvarogm.apisremotas.data.JokeClass

sealed class JokesScreenState {
 object Loading: JokesScreenState()
 data class Error(val message: String): JokesScreenState()
// data class Success(val joke: JokeClass): JokesScreenState()
 data class Success(val jokes: List<JokeClass>): JokesScreenState()
}