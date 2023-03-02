package com.alvarogm.apisremotas.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alvarogm.apisremotas.R
import com.alvarogm.apisremotas.data.local.preferences.StoreUserLanguage
import com.alvarogm.apisremotas.data.remote.Flags
import com.alvarogm.apisremotas.data.remote.JokeClass
import com.alvarogm.apisremotas.presentation.*
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.components.ErrorBlock
import com.alvarogm.apisremotas.ui.theme.components.JokeCell
import com.alvarogm.apisremotas.ui.theme.components.JokeCellLocal
import com.alvarogm.apisremotas.ui.theme.components.JokeCellOne
import com.alvarogm.apisremotas.ui.theme.navigation.Destinations
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.Oval
import com.gandiva.neumorphic.shape.RoundedCorner
import com.mathroda.snackie.BrightGreen
import com.mathroda.snackie.SnackieError
import com.mathroda.snackie.SnackieSuccess
import com.mathroda.snackie.rememberSnackieState
import kotlinx.coroutines.CoroutineScope

fun getErrorMessage(language: String): String {
    return when (language) {
        "Es" -> "Bromas no disponibles, revise su conexión a internet o inténtelo de nuevo más tarde"
        "En" -> "Jokes not available, check your internet connection or try again later."
        "De" -> "Witze nicht verfügbar, überprüfen Sie Ihre Internetverbindung oder versuchen Sie es später noch einmal"
        "Fr" -> "Blagues non disponibles, veuillez vérifier votre connexion internet ou réessayer plus tard"
        else -> "Jokes not available, check your internet connection or try again later."
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
    viewModel: JokesViewModel
) {
    val screenState by viewModel.uiState.collectAsStateWithLifecycle()
    val screenStateLocal by viewModel.uiStateLocal.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")
    val success = rememberSnackieState()
    SnackbarHost(hostState = snackbarHostState)

    Scaffold(
        scaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState),
    ) {
        SnackieSuccess(state = success, containerColor = BrightGreen)
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
                                if ((screenState as JokesScreenState.Success).jokes.size>1){
                                    JokeCell((screenState as JokesScreenState.Success).jokes[1], viewModel)
                                }else{
                                    val type = (screenState as JokesScreenState.Success).jokes[0].type
                                    val category = (screenState as JokesScreenState.Success).jokes[0].category
                                    if((screenState as JokesScreenState.Success).jokes[0].type == "single"){
                                        val joke = (screenState as JokesScreenState.Success).jokes[0].joke
                                        JokeCellOne(type,"","",joke,category,viewModel)
                                    }else{
                                        val delivery = (screenState as JokesScreenState.Success).jokes[0].delivery
                                        val setup = (screenState as JokesScreenState.Success).jokes[0].setup
                                        JokeCellOne(type,delivery,setup,"",category,viewModel)
                                    }

                                }
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
                    viewModel.getJokesOrOneJoke(category, lang, amount)
                }
            }
        }
    }
}

