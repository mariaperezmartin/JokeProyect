package com.alvarogm.apisremotas.ui.theme.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.navigation.Destinations.*
import com.alvarogm.apisremotas.ui.theme.screens.*
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavigationHost(

    navController: NavHostController,
    darkMode: Boolean,
    viewModel: JokesViewModel,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope

) {
    var isDarkTheme by remember { mutableStateOf(darkMode) }
    isDarkTheme = darkMode

    NavHost(navController = navController, startDestination = Pantalla1.route) {

        composable(Pantalla1.route) {
            Pantalla1(
                navegarPantalla2 = { newText,newTextLang,newText2 ->navController.navigate(Pantalla2.createRoute(newText,newTextLang,newText2)) },
            navController = navController
            )
        }

        composable(
            Pantalla2.route,
            arguments = listOf(
                navArgument("category"){ defaultValue = "Any" },
                navArgument("lang"){ defaultValue = "En" },
                navArgument("amount"){ defaultValue = 1 }
            )
        ) { navBackStackEntry ->
            var category = navBackStackEntry.arguments?.getString("category")
            var lang = navBackStackEntry.arguments?.getString("lang")
            var amount = navBackStackEntry.arguments?.getInt("amount")
            requireNotNull(category)
            requireNotNull(amount)
            requireNotNull(lang)
            Pantalla2(category,lang,amount, darkMode, viewModel,scaffoldState,coroutineScope)
            //ShowJokes()
        }

        composable(Pantalla3.route) {
            // Pantalla3()
            //SettingsScreen()
            Column (
                modifier = Modifier
                    .padding(horizontal = 23.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ){
                //PressedButton(darkMode) { }
                TitleApp()
                //LanguageSelectionSpinner(context = LocalContext.current)
                PressedSppiner(LocalContext.current, viewModel)
                PressedButtonError()
                PressedButtonVersion()
            }
        }
    }
}