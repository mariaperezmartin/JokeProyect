package com.alvarogm.apisremotas.presentation;

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarogm.apisremotas.data.remote.JokeRemoteDatasource
import com.alvarogm.apisremotas.data.local.database.Jokes
import com.alvarogm.apisremotas.data.local.database.JokesDatasource
import com.alvarogm.apisremotas.data.local.preferences.SettingsDatasource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class JokesViewModel(
    private val jokesRemoteDatasource: JokeRemoteDatasource,
    private val jokesDatasource: JokesDatasource,
    private val settingsDatasource: SettingsDatasource
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

    fun getMyPreference() {
       viewModelScope.launch(handler) {
           settingsDatasource.getLanguage()
        }
    }

    suspend fun setMyPreference(s: Unit) {
        settingsDatasource.setLanguage(s)
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
            Log.d("JokesIsLocal", jokes.toString())
            /*val localJoke = jokesDatasource.getJokes().collect(){
                Log.d("JokesIsLocal",it.toString())
            }*/

            /*jokesDatasource.getJokes().collect(){
                for (joke in it){
                    for (jokeRemote in jokes.jokes){
                        if (joke.equals(jokeRemote)){
                            jokeRemote.isLocal = true
                        }
                    }
                }
            }*/
            Log.d("JokesIsLocal", jokes.toString())
            /*jokesDatasource.getJokes().collect {
                val filteredList = it.filter { item -> jokes.id == item.id }
                if(filteredList.isNotEmpty()) {

                }
            }*/
            /*jokesDatasource.getJokes().collect {
                val filteredList = it.filter { item -> jokes.id == item.id }
                if(filteredList.isNotEmpty()) {

                }
            }*/

            /*jokesDatasource.getJokes().collect {
                val filteredList = it.map { item -> JokeClass(

                ) }
                    if(filteredList.isNotEmpty()) {

                }
                }*/
            //jokesLocal
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