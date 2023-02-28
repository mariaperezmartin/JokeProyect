package com.alvarogm.apisremotas.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alvarogm.apisremotas.data.local.preferences.StoreUserLanguage
import com.alvarogm.apisremotas.presentation.*
import com.alvarogm.apisremotas.ui.theme.components.ErrorBlock
import com.alvarogm.apisremotas.ui.theme.components.JokeCell
import com.alvarogm.apisremotas.ui.theme.components.JokeCellLocal
import com.mathroda.snackie.SnackieState
import kotlinx.coroutines.CoroutineScope
fun getErrorMessage(language: String): String {
    return when (language) {
        "Es" -> "Ha ocurrido un error, revise su conexión a internet o inténtelo de nuevo más tarde"
        "En" -> "An error has occurred, check your internet connection or try again later"
        "De" -> "Es ist ein Fehler aufgetreten, bitte überprüfen Sie Ihre Internetverbindung oder versuchen Sie es später noch einmal"
        "Fr" -> "Une erreur s'est produite, veuillez vérifier votre connexion Internet ou réessayer plus tard"
        else -> "An error has occurred, check your internet connection or try again later" // Valor por defecto si no se reconoce el idioma
    }
}
fun getErrorMessageLocal(language: String): String {
    return when (language) {
        "Es" -> "No se ha encontrado bromas guardadas"
        "En" -> "No saved jokes found"
        "De" -> "Keine gespeicherten Witze gefunden"
        "Fr" -> "Aucune blague stockée n'a été trouvée"
        else -> "An error has occurred, check your internet connection or try again later" // Valor por defecto si no se reconoce el idioma
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun Pantalla2(

    category: String,
    lang: String,
    amount: Int,
    darkMode: Boolean,
    viewModel: JokesViewModel,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope
) {
    val screenState by viewModel.uiState.collectAsStateWithLifecycle()
    val screenStateLocal by viewModel.uiStateLocal.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    //val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val scope = rememberCoroutineScope()
    //val scaffoldState = rememberScaffoldState()
    val mContext = LocalContext.current

    val openDialog = remember { mutableStateOf(false) }

    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")

    SnackbarHost(hostState = snackbarHostState)

    Scaffold(
        scaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState),
    ) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(550.dp)
        ) {
            if (category == "MisBromas") {

                when (screenStateLocal) {
                    JokesScreenStateLocal.LoadingLocal -> CircularProgressIndicator(
                        modifier = Modifier.size(
                            48.dp
                        )
                    )
                    is JokesScreenStateLocal.NoResultsLocal ->
                        ErrorBlock(
                            message = getErrorMessageLocal(savedEmail.value.toString())
                        ) { viewModel.getJokes(category, lang,amount) }
/*                        Column(
                            modifier = Modifier.verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(when (savedEmail.value.toString()) {
                                "Es" -> "Error"
                                "En" -> "Error"
                                "De" -> "Fehler"
                                "Fr" -> "Erreur"
                                else -> {"Error"}
                            })
                        }*/
                    is JokesScreenStateLocal.SuccessLocal ->
                        Column(
                            modifier = Modifier.verticalScroll(rememberScrollState()),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "$amount JOKES - ${category.uppercase()}")
                            (screenStateLocal as JokesScreenStateLocal.SuccessLocal).data.forEach() {
                                JokeCellLocal(it, viewModel,scaffoldState,coroutineScope)
                            }
                        }
                    else -> {}
                }
            } else {
                if (amount == 1) {
                    when (screenState) {
                        JokesScreenState.Loading -> CircularProgressIndicator(
                            modifier = Modifier.size(
                                48.dp
                            )
                        )
                        is JokesScreenState.Error ->
                            ErrorBlock(
                                message = getErrorMessage(savedEmail.value.toString())
                            ) { viewModel.getJokes(category, lang,amount) }
                        is JokesScreenState.Success ->
                            Column(
                                modifier = Modifier.verticalScroll(rememberScrollState()),
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "1 JOKE - ${category.uppercase()}")
                                JokeCell((screenState as JokesScreenState.Success).jokes[1], viewModel, scaffoldState,coroutineScope)
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
                                message = getErrorMessage(savedEmail.value.toString())
                            ) { viewModel.getJokes(category, lang, amount) }
                        is JokesScreenState.Success ->
                            Column(
                                modifier = Modifier.verticalScroll(rememberScrollState()),
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "$amount JOKES - ${category.uppercase()}")

                                (screenState as JokesScreenState.Success).jokes.forEach() {
                                    JokeCell(it, viewModel, scaffoldState,coroutineScope)
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
                    viewModel.getJokesOrOneJoke(category, lang, amount)
                   /* if (amount == 1) {
                        viewModel.getOneJoke(category, amount)
                    } else {
                        viewModel.getJokes(category, amount)
                    }*/
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

