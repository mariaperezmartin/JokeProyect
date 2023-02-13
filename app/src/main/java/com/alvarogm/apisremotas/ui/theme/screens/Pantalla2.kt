package com.alvarogm.apisremotas.ui.theme.screens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alvarogm.apisremotas.presentation.*
import com.alvarogm.apisremotas.ui.theme.components.ErrorBlock
import com.alvarogm.apisremotas.ui.theme.components.JokeCell
import com.alvarogm.apisremotas.ui.theme.components.JokeCellLocal
import com.alvarogm.apisremotas.ui.theme.components.JokeCellOne
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
    val screenStateLocal by viewModel.uiStateLocal.collectAsStateWithLifecycle()
    val mContext = LocalContext.current
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(550.dp)
    ) {
        if (category == "MisBromas") {

/*
            if (jokesScreenStateLocal is MainScreenUiState.JokesScreenStateLocal.LoadingLocal) {
                // Mostrar un indicador de carga
            } else if (jokesScreenStateLocal is MainScreenUiState.JokesScreenStateLocal.NoResultsLocal) {
                // Mostrar un mensaje de error indicando que no se encontraron resultados
                val message = (jokesScreenStateLocal as MainScreenUiState.JokesScreenStateLocal.NoResultsLocal).message
            } else if (jokesScreenStateLocal is MainScreenUiState.JokesScreenStateLocal.SuccessLocal) {
                // Mostrar los datos obtenidos
                val data = (jokesScreenStateLocal as MainScreenUiState.JokesScreenStateLocal.SuccessLocal).data
            }
*/

            when (screenStateLocal) {
                JokesScreenStateLocal.LoadingLocal -> CircularProgressIndicator(
                    modifier = Modifier.size(
                        48.dp
                    )
                )
                is JokesScreenStateLocal.NoResultsLocal ->
                    /* ErrorBlock(
                         message = (screenState as JokesScreenStateLocal.NoResultsLocal).message
                     ) { viewModel.getAllJokes() }*/
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "EROROROROROROROROO")
                    }
                is JokesScreenStateLocal.SuccessLocal ->
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "$amount JOKES - ${category.uppercase()}")
                        (screenStateLocal as JokesScreenStateLocal.SuccessLocal).data.forEach() {
                            JokeCellLocal(it, viewModel)
                        }
                    }
                else -> {}
            }
            /* LaunchedEffect(viewModel) {
                 viewModel.getAllJokes()
             }*/
        } else {
            if (amount < 2) {
                when (screenState) {
                    JokesScreenState.Loading -> CircularProgressIndicator(
                        modifier = Modifier.size(
                            48.dp
                        )
                    )
                    is JokesScreenState.Error ->
                        ErrorBlock(
                            message = (screenState as JokesScreenState.Error).message
                        ) { viewModel.getOneJoke(category, amount) }
                    is JokesScreenState.Success ->
                        Column(
                            modifier = Modifier.verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "$amount JOKES - ${category.uppercase()}")
                            JokeCellOne((screenState as JokesScreenState.SuccessOne).onejoke, viewModel)
                        }
                    else -> {}
                }
            } else {
                when (screenState) {
                    JokesScreenState.Loading -> CircularProgressIndicator(
                        modifier = Modifier.size(
                            48.dp
                        )
                    )
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
                                JokeCell(it, viewModel)
                            }
                        }
                    else -> {}
                }
            }

        }
        LaunchedEffect(viewModel) {
            if (category == "MisBromas") {
                viewModel.getAllJokes()
            } else {
                if (amount < 2) {
                    viewModel.getOneJoke(category, amount)
                } else {
                    viewModel.getJokes(category, amount)
                }
            }
        }
    }
}

/*
@Composable
fun SnackbarDemo() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Button(onClick = {
            coroutineScope.launch {
                val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "This is your message",
                    actionLabel = "Do something"
                )
                when (snackbarResult) {
                    SnackbarResult.Dismissed -> TODO()
                    SnackbarResult.ActionPerformed -> TODO()
                }
            }
        }) {
            Text(text = "Click me!")
        }
    }
}*/
/*
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun ErrorSnackbar(
    errorMessage: String,
    showError: Boolean = !errorMessage.isNullOrBlank(),
    modifier: Modifier = Modifier,
    onErrorAction: () -> Unit = { },
    onDismiss: () -> Unit = { }
) {
    fun launchInComposition(showError) {
        delay(timeMillis = 5000L)
        if (showError) {
            onDismiss()
        }
    }
    AnimatedVisibility(
        visible = showError,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        modifier = modifier
    ) {
        Snackbar(
            modifier = Modifier.padding(16.dp),
            text = { Text(errorMessage) },
            action = {
                TextButton(
                    onClick = {
                        onErrorAction()
                        onDismiss()
                    },
                    contentColor = contentColor()
                ) {
                    Text(
                        text = "Ok",
                    )
                }
            }
        )
    }
}*/

