package com.alvarogm.apisremotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alvarogm.apisremotas.ui.theme.ApisRemotasTheme
import com.alvarogm.apisremotas.ui.theme.screens.*

class PreferencesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember {
                mutableStateOf(true)
            }
            ApisRemotasTheme(isDarkTheme = isDarkTheme) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        TitleApp()
                        PressedButton(isDarkTheme = isDarkTheme) {
                            isDarkTheme = !isDarkTheme
                        }
                        PressedSppiner()
                        PressedButtonError()
                        PressedButtonVersion()
                    }
                }
            }
        }
    }

}

