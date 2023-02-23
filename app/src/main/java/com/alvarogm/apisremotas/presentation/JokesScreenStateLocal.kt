package com.alvarogm.apisremotas.presentation

import com.alvarogm.apisremotas.data.local.database.Jokes

data class MainScreenUiState(val state: JokesScreenStateLocal)
sealed class JokesScreenStateLocal {
    object LoadingLocal : JokesScreenStateLocal()
    data class NoResultsLocal(val message: String) : JokesScreenStateLocal()
    data class SuccessLocal(val data: List<Jokes>) : JokesScreenStateLocal()

}