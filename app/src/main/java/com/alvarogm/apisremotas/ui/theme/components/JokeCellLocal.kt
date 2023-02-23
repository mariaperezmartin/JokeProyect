package com.alvarogm.apisremotas.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.alvarogm.apisremotas.R
import com.alvarogm.apisremotas.data.local.Jokes
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
import kotlinx.coroutines.launch


@Composable
fun JokeCellLocal(joke: Jokes, viewModel: JokesViewModel) {
    val scaffoldState = rememberScaffoldState()
    val snackbarCoroutineScope = rememberCoroutineScope()
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
/*                ImageButton(
                    modifier = Modifier.padding(defaultWidgetPadding),
                    drawableResId = R.drawable.baseline_home_24,
                    contentDescription = "Like",
                ) {
                    viewModel.saveJoke(joke.joke)
                }
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = Destinations.Pantalla2.title,
                    //tint = if(selected) Color.Blue else Color.Gray

                )*/
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
                            snackbarCoroutineScope.launch{
                                scaffoldState.snackbarHostState.showSnackbar("Snacks in Compose")
                            }
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

/*
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
}*/
