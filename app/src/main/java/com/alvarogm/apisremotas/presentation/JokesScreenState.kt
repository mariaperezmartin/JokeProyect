package com.alvarogm.apisremotas.presentation

import com.alvarogm.apisremotas.data.remote.Joke
import com.alvarogm.apisremotas.data.remote.JokeClass

/*data class JokesScreenStateLocal(val state: JokesScreenState)*/
sealed class JokesScreenState {
 object Loading: JokesScreenState()
 data class Error(val message: String): JokesScreenState()
// data class Success(val joke: JokeClass): JokesScreenState()
 data class Success(val jokes: List<JokeClass>): JokesScreenState()
 data class SuccessOne(val onejoke: Joke): JokesScreenState()
}