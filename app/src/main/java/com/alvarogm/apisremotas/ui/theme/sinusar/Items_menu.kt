package com.alvarogm.apisremotas.ui.theme.sinusar

import com.alvarogm.apisremotas.R

sealed class Items_menu(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Jokes : Items_menu(
        route = "Jokes",
        title = "ShowJokes",
        icon = R.drawable.baseline_assignment_24
    )

    object Home : Items_menu(
        route = "Home",
        title = "MainScreen",
        icon = R.drawable.baseline_home_24
    )

    object Settings : Items_menu(
        route = "Settings",
        title = "SettingsScreen",
        icon = R.drawable.baseline_settings_24
    )
}