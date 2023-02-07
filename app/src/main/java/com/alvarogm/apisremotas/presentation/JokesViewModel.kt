package com.alvarogm.apisremotas.presentation;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarogm.apisremotas.data.JokeRemoteDatasource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JokesViewModel(private val episodesRemoteDatasource: JokeRemoteDatasource) :
    ViewModel() {
    private val _uiState: MutableStateFlow<JokesScreenState> =
        MutableStateFlow(JokesScreenState.Loading)
    val uiState: StateFlow<JokesScreenState> = _uiState.asStateFlow()
    private val handler = CoroutineExceptionHandler { _, _ ->
        _uiState.value = JokesScreenState.Error(
            "Ha ocurrido un error, revise su conexión a internet o inténtelo de nuevo " + "más tarde"
        )
    }

    fun getJokes() {
        viewModelScope.launch(handler) {
            /*_uiState.value = JokesScreenState.Loading*/
            val jokes = episodesRemoteDatasource.getJoke()
            _uiState.value = JokesScreenState.Success(jokes.jokes)
        }
    }
}