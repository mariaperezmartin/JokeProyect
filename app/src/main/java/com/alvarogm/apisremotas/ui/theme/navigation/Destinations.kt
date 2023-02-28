package com.alvarogm.apisremotas.ui.theme.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Pantalla1: Destinations("pantalla1", "", Icons.Filled.Home)
    object Pantalla2: Destinations("pantalla2/?category={category}&lang={lang}&amount={amount}", "", Icons.Filled.Favorite) {
        fun createRoute(category: String,lang: String,amount: Int) = "pantalla2/?category=$category&lang=$lang&amount=$amount"
    }
    object Pantalla3: Destinations("SettingsScreen", "", Icons.Filled.Settings)
}
