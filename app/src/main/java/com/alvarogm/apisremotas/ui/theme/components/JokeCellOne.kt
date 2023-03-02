package com.alvarogm.apisremotas.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.alvarogm.apisremotas.R
import com.alvarogm.apisremotas.data.local.database.Jokes
import com.alvarogm.apisremotas.data.local.preferences.StoreUserLanguage
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
import com.mathroda.snackie.BrightGreen
import com.mathroda.snackie.SnackieError
import com.mathroda.snackie.SnackieSuccess
import com.mathroda.snackie.rememberSnackieState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun JokeCellOne(
    type: String,
    delivery:  String,
    setup:  String,
    joke: String,
    category: String,
    viewModel: JokesViewModel,
) {
    val success = rememberSnackieState()
    val error = rememberSnackieState()
    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")

    SnackieSuccess(state = success, containerColor = BrightGreen)
    SnackieError(state = error)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp,0.dp,0.dp,10.dp)
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

                if (type == "twopart") {
                    Text(
                        text = savedEmail.value.toString() + " - " + category,
                        style = TextStyle(color = Color(0xFF1393E2))
                    )
                    Text(text = setup)//pregunta
                    Text(text = delivery, style = TextStyle(color = Color.Red),fontSize = 19.sp)//respuesta

                } else {
                    Text(
                        text = savedEmail.value.toString() + " - " + category,
                        style = TextStyle(color = Color(0xFF1393E2))
                    )
                    Text(text = joke)
                }
            }

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
                        isJokeInDatabase.value = viewModel.isJokeInLocalDatabase(setup + " " + delivery)
                    }

                    //single
                    val isJokeInDatabaseSingle = remember { mutableStateOf(false) }
                    LaunchedEffect(Unit) {
                        isJokeInDatabaseSingle.value = viewModel.isJokeInLocalDatabase(joke)
                    }

                    val iconTint = if (type == "twopart") {
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
                            if (type == "twopart") {
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
                                    viewModel.saveJoke(setup + " " + delivery)
                                    run { success.addMessage(
                                        when (savedEmail.value.toString()) {
                                            "Es" -> "Broma guardada correctamente"
                                            "En" -> "Successfully recorded joke"
                                            "De" -> "Witz erfolgreich aufgenommen"
                                            "Fr" -> "Blague déjà enregistrée"
                                            else -> {"Successfully recorded joke"}
                                        }) }
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
                                    viewModel.saveJoke(joke)
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