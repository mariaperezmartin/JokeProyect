package com.alvarogm.apisremotas.ui.theme.components

import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.annotation.DrawableRes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import com.alvarogm.apisremotas.R
import com.alvarogm.apisremotas.data.local.preferences.StoreUserLanguage
import com.alvarogm.apisremotas.data.remote.JokeClass
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.navigation.Destinations
import com.alvarogm.apisremotas.ui.theme.screens.defaultElevation
import com.alvarogm.apisremotas.ui.theme.screens.defaultWidgetPadding
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.Oval
import com.gandiva.neumorphic.shape.RoundedCorner
import com.mathroda.snackie.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


@Composable
fun JokeCell(
    joke: JokeClass,
    viewModel: JokesViewModel,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope

) {
    val success = rememberSnackieState()
    val error = rememberSnackieState()
    val custom = rememberSnackieState()

    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")


    SnackieSuccess(state = success, containerColor = BrightGreen)
    SnackieError(state = error)
/*    SnackieCustom(
        state = custom,
        position = SnackiePosition.Float,
        duration = 3000L,
        icon = Icons.Default.Star,
        containerColor = Color.Gray,
        contentColor = Color.White,
        enterAnimation = fadeIn(),
        exitAnimation = fadeOut(),
        verticalPadding = 12.dp,
        horizontalPadding = 12.dp
    )*/

    Card(
        modifier = Modifier
            .fillMaxWidth()
            //.padding(10.dp,0.dp,0.dp,10.dp)
            .padding(0.dp)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                shape = Flat(RoundedCorner(20.dp)),
                lightSource = LightSource.LEFT_TOP,
            ),
        elevation = 0.dp,
        shape = RoundedCornerShape(24.dp),
    ) {

        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(18.dp)
            ) {

                if (joke.type == "twopart") {
                    Text(
                        text = joke.lang + " - " + joke.category,
                        style = TextStyle(color = Color(0xFF1393E2))
                    )
                    Text(text = joke.setup)//pregunta
                    Text(text = joke.delivery, style = TextStyle(color = Color.Red),fontSize = 19.sp)//respuesta

                } else {
                    Text(
                        text = joke.lang + " - " + joke.category,
                        style = TextStyle(color = Color(0xFF1393E2))
                    )
                    Text(text = joke.joke)
                }
            }
        /*    SnackieError(state = error)
            SnackieCustom(
                state = custom,
                position = SnackiePosition.Float,
                duration = 3000L,
                icon = Icons.Default.Star,
                containerColor = Color.Gray,
                contentColor = Color.White,
                enterAnimation = fadeIn(),
                exitAnimation = fadeOut(),
                verticalPadding = 12.dp,
                horizontalPadding = 12.dp
            )*/
            Column(modifier = Modifier.align(Alignment.CenterVertically).padding(0.dp,0.dp,10.dp,0.dp)) {
                Card(
                    modifier = Modifier
                        .size(48.dp)
                        .neu(
                            lightShadowColor = AppColors.lightShadow(),
                            darkShadowColor = AppColors.darkShadow(),
                            shadowElevation = defaultElevation,
                            lightSource = LightSource.LEFT_TOP,
                            shape = Flat(Oval),
                        ),
                    elevation = 0.dp,
                    shape = RoundedCornerShape(24.dp),
                ) {

                    //twopart
                    val isJokeInDatabase = remember { mutableStateOf(false) }
                    LaunchedEffect(Unit) {
                        isJokeInDatabase.value = viewModel.isJokeInLocalDatabase(joke.setup + " " + joke.delivery)
                    }

                    //single
                    val isJokeInDatabaseSingle = remember { mutableStateOf(false) }
                    LaunchedEffect(Unit) {
                        isJokeInDatabaseSingle.value = viewModel.isJokeInLocalDatabase(joke.joke)
                    }

                    val iconTint = if (joke.type == "twopart") {
                        if (isJokeInDatabase.value) {
                            Color.Red
                        } else {
                            Color.Black
                        }
                    } else {
                        if (isJokeInDatabaseSingle.value) {
                            Color.Red
                        } else {
                            Color.Black
                        }
                    }



                    IconButton(
                        modifier = Modifier.padding(0.dp),

                        onClick = {
                            if (joke.type == "twopart") {
                                if (isJokeInDatabase.value) {
                                    run { error.addMessage(
                                        when (savedEmail.value.toString()) {
                                            "Es" -> "Broma ya guardada"
                                            "En" -> "Joke already recorded"
                                            "De" -> "Witz bereits aufgenommen"
                                            "Fr" -> "Blague enregistrée avec succès"
                                            else -> {"Joke already recorded"}
                                        }) }
                                } else {
                                    viewModel.saveJoke(joke.setup + " " + joke.delivery)
                                    run { success.addMessage(
                                        when (savedEmail.value.toString()) {
                                            "Es" -> "Broma guardada correctamente"
                                            "En" -> "Successfully recorded joke"
                                            "De" -> "Witz erfolgreich aufgenommen"
                                            "Fr" -> "Blague déjà enregistrée"
                                            else -> {"Successfully recorded joke"}
                                        }) }
                                  /*  coroutineScope.launch {
                                        scaffoldState.snackbarHostState.showSnackbar(
                                            message = "Broma guardada correctamente",
                                            duration = SnackbarDuration.Short
                                        )
                                    }*/
                                }

                            } else {
                                if (isJokeInDatabaseSingle.value) {
                                    run { error.addMessage(when (savedEmail.value.toString()) {
                                        "Es" -> "Broma ya guardada"
                                        "En" -> "Joke already recorded"
                                        "De" -> "Witz bereits aufgenommen"
                                        "Fr" -> "Blague enregistrée avec succès"
                                        else -> {"Joke already recorded"}
                                    }) }
                                } else {
                                    viewModel.saveJoke(joke.joke)
                                    run { success.addMessage(
                                        when (savedEmail.value.toString()) {
                                            "Es" -> "Broma guardada correctamente"
                                            "En" -> "Successfully recorded joke"
                                            "De" -> "Witz erfolgreich aufgenommen"
                                            "Fr" -> "Blague déjà enregistrée"
                                            else -> {"Successfully recorded joke"}
                                        }
                                    ) }
                                }

                            }


                        }
                    ) {
                        /*  Icon(
                              painter = painterResource(id = R.drawable.ic_baseline_emoji_favorite),
                              contentDescription = Destinations.Pantalla2.title,
                          )*/
                        //val coroutineScope = rememberCoroutineScope()

                        Icon(
                            modifier = Modifier.size(30.dp),
                            tint = iconTint,
                            painter = painterResource(id = R.drawable.ic_baseline_emoji_favorite),
                            contentDescription = Destinations.Pantalla2.title,
                        )


                    }

                }

            }
        }

    }
}

@Composable
fun ImageButton(
    modifier: Modifier,
    @DrawableRes drawableResId: Int,
    contentDescription: String = "",
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .size(48.dp)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Flat(Oval),
            ),
        elevation = 0.dp,
        shape = RoundedCornerShape(24.dp),
    ) {
        Image(
            modifier = Modifier.clickable(true, onClick = onClick),
            painter = painterResource(id = drawableResId),
            contentDescription = contentDescription,
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
    }
}
//SnackBar
/*
@Composable
fun SnackbarScreen() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
        FloatingActionButton(
            onClick = {
                //Important part here
                scope.launch {
                    snackbarHostState.showSnackbar("Hello there")
                }
                //
            },
            content = { Icon(imageVector = Icons.Default.Add, contentDescription = "") }
        )
    SnackbarHost(hostState = snackbarHostState)
}*/

@Composable
fun DisplaySnackbar() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) { padding ->
        Column(modifier = Modifier.padding(4.dp)) {
            Button(onClick = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "Messahe snackbar",
                        actionLabel = "undo",
                        duration = SnackbarDuration.Short
                    )
                }
            }) {
                Text(text = "Display Snack Bar")
            }
        }

    }
}