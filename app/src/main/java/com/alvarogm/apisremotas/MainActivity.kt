package com.alvarogm.apisremotas

import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.alvarogm.apisremotas.data.JokeRemoteDatasource
import com.alvarogm.apisremotas.data.RetrofitBuilder
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.ApisRemotasTheme

class MainActivity : ComponentActivity() {
    private val apiDatasource = JokeRemoteDatasource(RetrofitBuilder. apiService)
    private val viewModel = JokesViewModel( apiDatasource )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApisRemotasTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color =
                MaterialTheme. colors.background) {
                    MainScreen(remember { mutableStateOf(false) }, viewModel = viewModel)
                }
            }
        }
    }
}
