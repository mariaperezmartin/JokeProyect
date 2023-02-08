package com.alvarogm.apisremotas.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alvarogm.apisremotas.R
import com.alvarogm.apisremotas.presentation.JokesScreenState
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.AppTextStyle
import com.alvarogm.apisremotas.ui.theme.components.ErrorBlock
import com.alvarogm.apisremotas.ui.theme.components.JokeCell
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.NeuAttrs
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.*

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
                    message = (screenState as JokesScreenState.Error).message
                ) { viewModel.getJokes() }
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
                    CircleActionButton()
                    //TwoColumnsWithButtons()
                }
            else -> {}
        }
    }
    LaunchedEffect(viewModel) {
        viewModel.getJokes()
    }
}

@Composable
fun defaultPressedNetAttrs() = NeuAttrs(
    lightShadowColor = AppColors.lightShadow(),
    darkShadowColor = AppColors.darkShadow(),
    shadowElevation = defaultElevation,
    lightSource = LightSource.LEFT_TOP,
    shape = Pressed(defaultCornerShape),
)
@Composable
fun DefaultSpacer() = Spacer(modifier = Modifier.size(8.dp))
val defaultWidgetPadding = 16.dp
val defaultElevation = 6.dp
val defaultCornerShape: CornerShape = RoundedCorner(12.dp)

//este metodo de TwoColumnsWithButtons es una prueba que he hecho, no funciona todavia
/*@Composable
fun TwoColumnsWithButtons() {
    Column {
        Column(modifier = Modifier.weight(1f)) {
            Button(
                onClick = { }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(defaultWidgetPadding)
                    .neu(defaultPressedNetAttrs()),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.surface,
                ),
                shape = RoundedCornerShape(12.dp),
                elevation = null

            ) {
                Text(text = "Button", style = AppTextStyle.button())
            }
            Button(
                onClick = { }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(defaultWidgetPadding)
                    .neu(defaultPressedNetAttrs()),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.surface,
                ),
                shape = RoundedCornerShape(12.dp),
                elevation = null

            ) {
                Text(text = "Button", style = AppTextStyle.button())
            }
            Button(
                onClick = { }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(defaultWidgetPadding)
                    .neu(defaultPressedNetAttrs()),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.surface,
                ),
                shape = RoundedCornerShape(12.dp),
                elevation = null

            ) {
                Text(text = "Button", style = AppTextStyle.button())
            }
        }
        Column(modifier = Modifier.weight(1f)) {
            Button(
                onClick = { }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(defaultWidgetPadding)
                    .neu(defaultPressedNetAttrs()),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.surface,
                ),
                shape = RoundedCornerShape(12.dp),
                elevation = null

            ) {
                Text(text = "Button", style = AppTextStyle.button())
            }
            Button(
                onClick = { }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(defaultWidgetPadding)
                    .neu(defaultPressedNetAttrs()),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.surface,
                ),
                shape = RoundedCornerShape(12.dp),
                elevation = null

            ) {
                Text(text = "Button", style = AppTextStyle.button())
            }
            Button(
                onClick = { }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(defaultWidgetPadding)
                    .neu(defaultPressedNetAttrs()),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.surface,
                ),
                shape = RoundedCornerShape(12.dp),
                elevation = null

            ) {
                Text(text = "Button", style = AppTextStyle.button())
            }
        }
    }
}*/

@Preview
@Composable
fun CircleActionButton() {
    val imageSize = 48.dp
    Row(

        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
    ) {
        Image(
            modifier = Modifier
                .size(imageSize)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Pressed(Oval),
                ),
            painter = painterResource(id = R.drawable.ic_baseline_emoji_events_24),
            contentDescription = "Pressed image 1",
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
        DefaultSpacer()

        //otra prueba que estaba haciendo
        /*       Image(
                   modifier = Modifier
                       .size(imageSize)
                       .neu(
                           lightShadowColor = AppColors.lightShadow(),
                           darkShadowColor = AppColors.darkShadow(),
                           shadowElevation = defaultElevation,
                           lightSource = LightSource.LEFT_TOP,
                           shape = Pressed(Oval),
                       ),
                   painter = painterResource(id = R.drawable.ic_baseline_thumb_up_24),
                   contentDescription = "Pressed image 2",
                   contentScale = ContentScale.Inside,
                   colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
               )*/
        Card(
            modifier = Modifier
                .size(imageSize)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Flat(RoundedCorner(24.dp)),
                ),
            elevation = 0.dp,
            shape = RoundedCornerShape(24.dp),
        ){
            Button(
                onClick = { }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(defaultWidgetPadding)



            ) {
                Column {

                }
            }
        }

        DefaultSpacer()

        Card(
            modifier = Modifier
                .size(imageSize)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Flat(Oval),
                ),
            elevation = 0.dp,
            shape = RoundedCornerShape(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_emoji_emotions_24),
                contentDescription = "Flat image 1",
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
            )
        }
        DefaultSpacer()
        Card(
            modifier = Modifier
                .size(imageSize)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Flat(Oval),
                ),
            elevation = 0.dp,
            shape = RoundedCornerShape(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_anchor_24),
                contentDescription = "Flat image 2",
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
            )
        }
    }
}





//esto es otra prueba que estaba haciendo, para poner las cosas de manera vertical y demas
/*
@Preview
@Composable
fun CircleActionButton() {
    val imageSize = 48.dp
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(defaultWidgetPadding)
    ) {
        Column(

            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(defaultWidgetPadding)
        ) {
            Image(
                modifier = Modifier
                    .size(imageSize)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Pressed(Oval),
                    ),
                painter = painterResource(id = R.drawable.ic_baseline_emoji_events_24),
                contentDescription = "Pressed image 1",
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
            )
            DefaultSpacer()
            /*       Image(
                       modifier = Modifier
                           .size(imageSize)
                           .neu(
                               lightShadowColor = AppColors.lightShadow(),
                               darkShadowColor = AppColors.darkShadow(),
                               shadowElevation = defaultElevation,
                               lightSource = LightSource.LEFT_TOP,
                               shape = Pressed(Oval),
                           ),
                       painter = painterResource(id = R.drawable.ic_baseline_thumb_up_24),
                       contentDescription = "Pressed image 2",
                       contentScale = ContentScale.Inside,
                       colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                   )*/
            Card(
                modifier = Modifier
                    .size(imageSize)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(RoundedCorner(24.dp)),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(24.dp),
            ) {
                Button(
                    onClick = { }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(defaultWidgetPadding)


                ) {

                }
            }

            DefaultSpacer()

            Card(
                modifier = Modifier
                    .size(imageSize)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(Oval),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_emoji_emotions_24),
                    contentDescription = "Flat image 1",
                    contentScale = ContentScale.Inside,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                )
            }
            DefaultSpacer()
            Card(
                modifier = Modifier
                    .size(imageSize)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(Oval),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_anchor_24),
                    contentDescription = "Flat image 2",
                    contentScale = ContentScale.Inside,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                )
            }
        }

        Column(

            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(defaultWidgetPadding)
        ) {
            Image(
                modifier = Modifier
                    .size(imageSize)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Pressed(Oval),
                    ),
                painter = painterResource(id = R.drawable.ic_baseline_emoji_events_24),
                contentDescription = "Pressed image 1",
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
            )
            DefaultSpacer()
            /*       Image(
                       modifier = Modifier
                           .size(imageSize)
                           .neu(
                               lightShadowColor = AppColors.lightShadow(),
                               darkShadowColor = AppColors.darkShadow(),
                               shadowElevation = defaultElevation,
                               lightSource = LightSource.LEFT_TOP,
                               shape = Pressed(Oval),
                           ),
                       painter = painterResource(id = R.drawable.ic_baseline_thumb_up_24),
                       contentDescription = "Pressed image 2",
                       contentScale = ContentScale.Inside,
                       colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                   )*/
            Card(
                modifier = Modifier
                    .size(imageSize)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(RoundedCorner(24.dp)),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(24.dp),
            ) {
                Button(
                    onClick = { }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(defaultWidgetPadding)


                ) {

                }
            }

            DefaultSpacer()

            Card(
                modifier = Modifier
                    .size(imageSize)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(Oval),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_emoji_emotions_24),
                    contentDescription = "Flat image 1",
                    contentScale = ContentScale.Inside,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                )
            }
            DefaultSpacer()
            Card(
                modifier = Modifier
                    .size(imageSize)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(Oval),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_anchor_24),
                    contentDescription = "Flat image 2",
                    contentScale = ContentScale.Inside,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                )
            }
        }
    }
}
*/