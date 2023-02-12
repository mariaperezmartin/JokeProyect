package com.alvarogm.apisremotas.presentation;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarogm.apisremotas.data.JokeRemoteDatasource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JokesViewModel(
    private val episodesRemoteDatasource: JokeRemoteDatasource,
/*    private val jokesDatasource: JokesDatasource*/
) : ViewModel() {

    private val _uiState: MutableStateFlow<JokesScreenState> =  MutableStateFlow(JokesScreenState.Loading)
    val uiState: StateFlow<JokesScreenState> = _uiState.asStateFlow()

/*    private val _uiStateLocal: MutableStateFlow<JokesScreenStateLocal> =  MutableStateFlow(JokesScreenStateLocal.Loading)*/
    //val uiStateLocal: StateFlow<JokesScreenStateLocal> = _uiState.asStateFlow()

    private val _uiStateLocal = MutableStateFlow(JokesScreenStateLocal(JokesScreenState.LoadingLocal))
    val uiStateLocal: StateFlow<JokesScreenStateLocal> = _uiStateLocal.asStateFlow()



    private val handler = CoroutineExceptionHandler { _, _ ->
        _uiState.value = JokesScreenState.Error(
            "Ha ocurrido un error, revise su conexión a internet o inténtelo de nuevo " + "más tarde"
        )
    }


    fun getJokes(category: String, jokeAmount: Int) {
        viewModelScope.launch(handler) {
            /*_uiState.value = JokesScreenState.Loading*/
            val jokes = episodesRemoteDatasource.getJoke(category, jokeAmount)
            _uiState.value = JokesScreenState.Success(jokes.jokes)
        }
    }

/*    fun getAllJokes() {
        viewModelScope.launch {
            _uiState.value = JokesScreenState.Loading
            val allJokes = jokesDatasource.getAllJokes()
            _uiState.value = JokesScreenState.Success(allJokes.)

        }
    }*/

/*
    fun jokesDatasource() {
        viewModelScope.launch {
            delay(3000) // TODO: Don't forget to remove this
            jokesDatasource.getAllJokes().collect {
                if (it.isEmpty()) {
                    _uiStateLocal.value = JokesScreenStateLocal(JokesScreenState.NoResultsLocal)
                } else {
                    _uiStateLocal.value = JokesScreenStateLocal(JokesScreenState.SuccessLocal(it))
                }
            }
        }
    }
*/


}