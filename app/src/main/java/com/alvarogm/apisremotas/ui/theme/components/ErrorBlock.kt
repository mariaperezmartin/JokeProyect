package com.alvarogm.apisremotas.ui.theme.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alvarogm.apisremotas.data.local.preferences.StoreUserLanguage
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.screens.defaultElevation
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.RoundedCorner

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ErrorBlock(message: String, onRetryClick: () -> Unit) {
    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(text = message, style = TextStyle(color = Color.Red, textAlign = TextAlign.Center))
        Card(
            modifier = Modifier

                .width(150.dp)
                .height(40.dp)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Flat(RoundedCorner(10.dp)),
                ),
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp),
            onClick = {onRetryClick()}
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    when (savedEmail.value.toString()) {
                        "Es" -> "Reintentar"
                        "En" -> "Retry"
                        "De" -> "Wiederholung"
                        "Fr" -> "Réessayer"
                        else -> {"Retry"}
                    }
                )
            }
        }
    }
}