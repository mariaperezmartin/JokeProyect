package com.alvarogm.apisremotas.presentation;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarogm.apisremotas.data.local.database.Jokes
import com.alvarogm.apisremotas.data.local.database.JokesDatasource
import com.alvarogm.apisremotas.data.remote.JokeRemoteDatasource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class JokesViewModel(
    private val jokesRemoteDatasource: JokeRemoteDatasource,
    private val jokesDatasource: JokesDatasource,
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

    fun getJokesOrOneJoke(category: String,lang: String, jokeAmount: Int) {
        if (jokeAmount > 1) {
            getJokes(category, lang, jokeAmount)
        } else {
            getJokes(category, lang, 2)
        }
    }


    suspend fun isJokeInLocalDatabase(jokeName: String): Boolean {
        val jokesList = jokesDatasource.getJokes().first()//lista local
        return jokesList.any { it.joke == jokeName }
    }

    fun getJokes(category: String,lang: String, jokeAmount: Int) {
        viewModelScope.launch(handler) {
            val jokes = jokesRemoteDatasource.getJoke(category,lang, jokeAmount)
            _uiState.value = JokesScreenState.Success(jokes.jokes)
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