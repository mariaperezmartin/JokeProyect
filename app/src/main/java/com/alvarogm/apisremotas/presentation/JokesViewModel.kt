package com.alvarogm.apisremotas.presentation;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarogm.apisremotas.data.JokeRemoteDatasource
import com.alvarogm.apisremotas.data.local.Jokes
import com.alvarogm.apisremotas.data.local.JokesDatasource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JokesViewModel(
    private val jokesRemoteDatasource: JokeRemoteDatasource,
    private val jokesDatasource: JokesDatasource
) : ViewModel() {

    private val _uiState: MutableStateFlow<JokesScreenState> =  MutableStateFlow(JokesScreenState.Loading)
    val uiState: StateFlow<JokesScreenState> = _uiState.asStateFlow()

    private val _uiStateLocal: MutableStateFlow<JokesScreenStateLocal> = MutableStateFlow(JokesScreenStateLocal.LoadingLocal)
    val uiStateLocal: StateFlow<JokesScreenStateLocal> = _uiStateLocal.asStateFlow()

/*    private val handler2 = CoroutineExceptionHandler { _, _ ->
        _uiStateLocal.value = JokesScreenStateLocal.NoResultsLocal(
            "Ha ocurrido un error, revise su conexión a internet o inténtelo de nuevo " + "más tarde"
        )
    }*/

    private val handler = CoroutineExceptionHandler { _, _ ->
        _uiState.value = JokesScreenState.Error(
            "Ha ocurrido un error, revise su conexión a internet o inténtelo de nuevo " + "más tarde"
        )
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

    fun saveJoke(joke: String){
        viewModelScope.launch {
            jokesDatasource.createJoke(joke)
        }
    }

 /*   fun getAllJokes() {
        viewModelScope.launch {
      *//*      delay(3000) // TODO: Don't forget to remove this*//*
            jokesDatasource.getJokes().collect {
                if (it.isEmpty()) {
                    _uiStateLocal.value = JokesScreenStateLocal.NoResultsLocal
                } else {
                    _uiStateLocal.value = JokesScreenStateLocal.SuccessLocal(it)
                }
            }
        }
    }*/
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