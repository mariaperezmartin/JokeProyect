package com.alvarogm.apisremotas.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alvarogm.apisremotas.presentation.JokesScreenState
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.components.ErrorBlock
import com.alvarogm.apisremotas.ui.theme.components.JokeCell

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainScreen(viewModel: JokesViewModel) {
    val screenState by viewModel.uiState.collectAsStateWithLifecycle()
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        when (screenState) {
            JokesScreenState.Loading -> CircularProgressIndicator(modifier = Modifier.size(48.dp))
            is JokesScreenState.Error ->
                ErrorBlock(
                    message = (screenState as JokesScreenState.Error).message) { viewModel.getJokes() }
            is JokesScreenState.Success ->
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    //JokeCell((screenState as JokesScreenState.Success).joke)
                   /* var amount: Int = 20

// Input para ingresar el valor de la variable amount
                    EditText(text = "$amount", onTextChanged = {
                        val newAmount = it.toString().toIntOrNull() ?: 20
                        amount = newAmount
                    })

// Botón para cambiar la variable amount
                    Button(onClick = { updateAmount() }) {
                        Text(text = "Update Amount")
                    }
*/
                    (screenState as JokesScreenState.Success).jokes.forEach() {
                        JokeCell(it)
                    }
                }
            else -> {}
        }
    }
    LaunchedEffect(viewModel) {
        viewModel.getJokes()
    }
}
