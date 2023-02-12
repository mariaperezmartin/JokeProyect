package com.alvarogm.apisremotas.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.screens.SettingsScreen
import com.alvarogm.apisremotas.ui.theme.navigation.Destinations.*
import com.alvarogm.apisremotas.ui.theme.screens.Pantalla1
import com.alvarogm.apisremotas.ui.theme.screens.Pantalla2

@Composable
fun NavigationHost(
    navController: NavHostController,
    darkMode: MutableState<Boolean>,
    viewModel: JokesViewModel
) {
    NavHost(navController = navController, startDestination = Pantalla1.route) {
        composable(Pantalla1.route) {
            Pantalla1(
                navegarPantalla2 = { newText,newText2 ->navController.navigate(Pantalla2.createRoute(newText,newText2)) },
            navController = navController
            )
        }

        composable(
            Pantalla2.route,
            arguments = listOf(
                navArgument("category"){ defaultValue = "Any" },
                navArgument("amount"){ defaultValue = 1 }
            )
        ) { navBackStackEntry ->
            var category = navBackStackEntry.arguments?.getString("category")
            var amount = navBackStackEntry.arguments?.getInt("amount")
            requireNotNull(category)
            requireNotNull(amount)
            Pantalla2(category,amount, darkMode, viewModel)
            //ShowJokes()
        }

        composable(Pantalla3.route) {
           // Pantalla3()
            SettingsScreen()
        }
    }
}