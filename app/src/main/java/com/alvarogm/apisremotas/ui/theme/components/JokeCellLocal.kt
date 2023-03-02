package com.alvarogm.apisremotas.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
import com.mathroda.snackie.SnackieSuccess
import com.mathroda.snackie.rememberSnackieState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun JokeCellLocal(
    joke: Jokes,
    viewModel: JokesViewModel,
) {
    val success = rememberSnackieState()
    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")
    SnackieSuccess(state = success, containerColor = BrightGreen)
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
                Text(text = joke.joke)
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

                    IconButton(modifier = Modifier.padding(defaultWidgetPadding),
                        onClick = {
                            viewModel.deleteJoke(joke)
                            run { success.addMessage(
                                when (savedEmail.value.toString()) {
                                    "Es" -> "Broma borrada con éxito"
                                    "En" -> "Delete joke successfully"
                                    "De" -> "Witz erfolgreich löschen"
                                    "Fr" -> "Blague supprimée avec succès"
                                    else -> {"Delete joke successfully"}
                                }) }
/*                            coroutineScope.launch{
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = when (savedEmail.value.toString()) {
                                        "Es" -> "Broma borrada con éxito"
                                        "En" -> "Delete joke successfully"
                                        "De" -> "Witz erfolgreich löschen"
                                        "Fr" -> "Blague supprimée avec succès"
                                        else -> {"Delete joke successfully"}
                                    },
                                    actionLabel = when (savedEmail.value.toString()) {
                                        "Es" -> "¡ Gracias !"
                                        "En" -> "Thanks!"
                                        "De" -> "Danke!"
                                        "Fr" -> "Merci !"
                                        else -> {"Thanks!"}
                                    },
                                    duration = SnackbarDuration.Short)
                            }*/
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_delete_24),
                            contentDescription = Destinations.Pantalla2.title,
                        )
                    }
                }
            }
        }
    }
}