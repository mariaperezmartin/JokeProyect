package com.alvarogm.apisremotas.ui.theme.screens

import android.content.Intent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alvarogm.apisremotas.PreferencesActivity
import com.alvarogm.apisremotas.ShowJokesActivity
import com.alvarogm.apisremotas.presentation.JokesScreenState
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.AppTextStyle
import com.alvarogm.apisremotas.ui.theme.components.ErrorBlock
import com.alvarogm.apisremotas.ui.theme.components.JokeCell
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.NeuAttrs
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.Oval

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun ShowJokes(viewModel: JokesViewModel) {
    val screenState by viewModel.uiState.collectAsStateWithLifecycle()
    val mContext = LocalContext.current
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
                        JokeCell(it,viewModel)
                    }


                }
            else -> {}
        }
    }
    LaunchedEffect(viewModel) {
        viewModel.getJokes()
    }


}

