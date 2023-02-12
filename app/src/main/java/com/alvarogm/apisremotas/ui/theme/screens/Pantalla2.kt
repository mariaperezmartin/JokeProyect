package com.alvarogm.apisremotas.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alvarogm.apisremotas.presentation.JokesScreenState
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.components.ErrorBlock
import com.alvarogm.apisremotas.ui.theme.components.JokeCell

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun Pantalla2(
    category: String,
    amount: Int,
    darkMode: MutableState<Boolean>,
    viewModel: JokesViewModel
) {

/*    if (category == "MisBromas"){

    }else{

    }*/

    println("ASKJDGHAKLSGDAKSGDKAHJSGDJKAHSGDJKAHSGDJKAHSGDAKJSHGDAKSJHDGAKJSHDGAKJSHDGAKSJHDGAKSJHDGAKJSHDGASJKHDG" + amount.toString())
    val screenState by viewModel.uiState.collectAsStateWithLifecycle()
    val mContext = LocalContext.current
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(550.dp)
    ) {
        if (category == "MisBromas") {
            when (screenState) {
                JokesScreenState.Loading -> CircularProgressIndicator(modifier = Modifier.size(48.dp))
                is JokesScreenState.Error ->
                    ErrorBlock(
                        message = (screenState as JokesScreenState.Error).message
                    ) { viewModel.getJokes(category, amount) }
                is JokesScreenState.Success ->
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "$amount JOKES - ${category.uppercase()}")
                        (screenState as JokesScreenState.Success).jokes.forEach() {
                            JokeCell(it,viewModel)
                        }
                    }
                else -> {}
            }
            LaunchedEffect(viewModel) {
                viewModel.getJokes(category, amount)
            }
        } else {
            when (screenState) {
                JokesScreenState.Loading -> CircularProgressIndicator(modifier = Modifier.size(48.dp))
                is JokesScreenState.Error ->
                    ErrorBlock(
                        message = (screenState as JokesScreenState.Error).message
                    ) { viewModel.getJokes(category, amount) }
                is JokesScreenState.Success ->
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
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
                        Text(text = "$amount JOKES - ${category.uppercase()}")
                        (screenState as JokesScreenState.Success).jokes.forEach() {
                            JokeCell(it,viewModel)
                        }
                    }
                else -> {}
            }
            LaunchedEffect(viewModel) {
                viewModel.getJokes(category, amount)
            }
        }
    }
}