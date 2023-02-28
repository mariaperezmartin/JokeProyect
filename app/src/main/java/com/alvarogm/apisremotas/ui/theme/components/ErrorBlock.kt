package com.alvarogm.apisremotas.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
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

@Composable
fun ErrorBlock(message: String, onRetryClick: () -> Unit) {
    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(text = message, style = TextStyle(color = Color.Red, textAlign = TextAlign.Center))
        Button(onClick = { onRetryClick() }) {
            Text(
                when (savedEmail.value.toString()) {
                    "Es" -> "Error"
                    "En" -> "Error"
                    "De" -> "Fehler"
                    "Fr" -> "Erreur"
                    else -> {"Error"}
                }
            )
        }
    }
}