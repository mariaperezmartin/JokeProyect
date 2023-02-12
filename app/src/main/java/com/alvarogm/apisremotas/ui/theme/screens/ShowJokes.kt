package com.alvarogm.apisremotas.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ShowJokes(){
    Column() {
        Text(text = "Jokes", style = MaterialTheme.typography.h1)
    }
}