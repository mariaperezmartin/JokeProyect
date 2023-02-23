package com.alvarogm.apisremotas.ui.theme.components

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.alvarogm.apisremotas.R
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
   // val isDuplicate by rememberFlowWithLifecycle(viewModel.isJokeDuplicate(joke.joke)).collectAsState(initial = false)


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp,0.dp,0.dp,10.dp)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                shape = Flat(RoundedCorner(24.dp)),
                lightSource = LightSource.LEFT_TOP,
            ),
        elevation = 0.dp,
        shape = RoundedCornerShape(24.dp),
    ) {

        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(start = 17.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
            ) {

                if (joke.type == "twopart") {
                    Text(
                        text = joke.lang + " - " + joke.category,
                        style = TextStyle(color = Color(0xFF87CEFA))
                    )
                    Text(text = joke.setup)//pregunta
                    Text(text = joke.delivery, style = TextStyle(color = Color.Red))//respuesta

                } else {
                    Text(
                        text = joke.lang + " - " + joke.category,
                        style = TextStyle(color = Color(0xFF87CEFA))
                    )
                    Text(text = joke.joke)
                }

                /*  Text(text = joke.category)
                    Text(text = joke.lang, style = TextStyle(color = Color.LightGray))*/
                //Text(text = joke.toString(), fontWeight = FontWeight.Bold)
                //Text(text = joke.setup.toString(), fontWeight = FontWeight.Bold)
            }
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
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

                    IconButton(
                        modifier = Modifier.padding(0.dp),

                        onClick = {
                            if (joke.type == "twopart") {
                                viewModel.saveJoke(joke.setup + " " + joke.delivery)
                            } else {
                                viewModel.saveJoke(joke.joke)
                            }

                            coroutineScope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Broma guardada correctamente",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }
                    ) {
                        /*  Icon(
                              painter = painterResource(id = R.drawable.ic_baseline_emoji_favorite),
                              contentDescription = Destinations.Pantalla2.title,
                          )*/

                        Icon(

                            modifier = Modifier.size(30.dp),
                 /*           tint = (

                                    *//*    if (isDuplicate && joke.type == "single") {
                                            Color.Red
                                        } else {
                                            Color.Black
                                        }*//*

                                   *//* if (joke.type == "twopart") {
                                        if (viewModel.isJokeDuplicate(joke.setup + " " + joke.delivery)) {
                                            Color.Red
                                        } else {
                                            Color.Black
                                        }
                                    } else {
                                        if (isDuplicate) {
                                            Color.Red
                                        } else {
                                            Color.Black
                                        }
                                    }*//*
                                    ),*/
                            painter = painterResource(id =  R.drawable.ic_baseline_emoji_favorite

                            ),
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
