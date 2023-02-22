package com.alvarogm.apisremotas.presentation;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarogm.apisremotas.data.Joke
import com.alvarogm.apisremotas.data.JokeClass
import com.alvarogm.apisremotas.data.JokeRemoteDatasource
import com.alvarogm.apisremotas.data.local.Jokes
import com.alvarogm.apisremotas.data.local.JokesDatasource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class JokesViewModel(
    private val jokesRemoteDatasource: JokeRemoteDatasource,
    private val jokesDatasource: JokesDatasource
) : ViewModel() {

    private val _uiState: MutableStateFlow<JokesScreenState> =
        MutableStateFlow(JokesScreenState.Loading)
    val uiState: StateFlow<JokesScreenState> = _uiState.asStateFlow()

    private val _uiStateLocal: MutableStateFlow<JokesScreenStateLocal> =
        MutableStateFlow(JokesScreenStateLocal.LoadingLocal)
    val uiStateLocal: StateFlow<JokesScreenStateLocal> = _uiStateLocal.asStateFlow()


    private val handler = CoroutineExceptionHandler { _, _ ->
        _uiState.value = JokesScreenState.Error(
            "Ha ocurrido un error, revise su conexión a internet o inténtelo de nuevo " + "más tarde"
        )
    }

    fun getJokesOrOneJoke(category: String, jokeAmount: Int) {
        if (jokeAmount > 1) {
            getJokes(category, jokeAmount)
        } else {
           /* getOneJoke(category, jokeAmount)*/
            getJokes(category, 2)
        }
    }


    fun getJokes(category: String, jokeAmount: Int) {
        viewModelScope.launch(handler) {
            /*_uiState.value = JokesScreenState.Loading*/
            val jokes = jokesRemoteDatasource.getJoke(category, jokeAmount)
            _uiState.value = JokesScreenState.Success(jokes.jokes)
        }
    }

    fun getOneJoke(category: String, jokeAmount: Int) {
        viewModelScope.launch(handler) {
            /*_uiState.value = JokesScreenState.Loading*/
            val oneJoke = jokesRemoteDatasource.getOneJoke(category, jokeAmount)
            _uiState.value = JokesScreenState.SuccessOne(oneJoke)
        }
    }

    fun saveJoke(joke: String) {
        viewModelScope.launch {
            jokesDatasource.createJoke(joke)
        }
    }

    fun getAllJokes() {
        viewModelScope.launch {
            jokesDatasource.getJokes().collect { jokes ->
                _uiStateLocal.value = if (jokes.isEmpty()) {
                    JokesScreenStateLocal.NoResultsLocal("No se han encontrado resultados")
                } else {
                    JokesScreenStateLocal.SuccessLocal(jokes)
                }
            }
        }
    }
    fun deleteJoke(joke: Jokes) {
        viewModelScope.launch {
            jokesDatasource.deleteJoke(joke)
        }
    }

}