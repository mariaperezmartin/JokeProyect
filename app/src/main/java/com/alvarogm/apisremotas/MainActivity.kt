package com.alvarogm.apisremotas

import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alvarogm.apisremotas.data.JokeRemoteDatasource
import com.alvarogm.apisremotas.data.RetrofitBuilder
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.ApisRemotasTheme
import com.alvarogm.apisremotas.data.local.JokesDatasource
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.AppTextStyle
import com.alvarogm.apisremotas.ui.theme.navigation.Destinations
/*import com.alvarogm.apisremotas.ui.theme.screens.ImageButton*/
import com.alvarogm.apisremotas.ui.theme.screens.defaultCornerShape
import com.alvarogm.apisremotas.ui.theme.screens.defaultElevation
import com.alvarogm.apisremotas.ui.theme.screens.defaultWidgetPadding
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.Oval
import com.gandiva.neumorphic.shape.RoundedCorner
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val apiDatasource = JokeRemoteDatasource(RetrofitBuilder.apiService)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dbDatasource = JokesDatasource(applicationContext)
        val viewModel = JokesViewModel(apiDatasource, dbDatasource)
        setContent {
            var isDarkTheme by remember {
                mutableStateOf(false)
            }
            ApisRemotasTheme(isDarkTheme = isDarkTheme) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen(
                        isDarkTheme,
                        viewModel = viewModel,
                        onThemeToggle = { isDarkTheme = !isDarkTheme })
                    Column(horizontalAlignment = Alignment.End) {
                        TitleWithThemeToggle(
                            title = getString(R.string.app_name),
                            isDarkTheme = isDarkTheme
                        ) {
                            isDarkTheme = !isDarkTheme
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TitleWithThemeToggle(title: String, isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
    Row(
        //verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(15.dp)
    ) {
/*        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = defaultWidgetPadding),
            text = title,
            style = AppTextStyle.body1(), maxLines = 1
        )*/
/*        ImageButton(
            modifier = Modifier.size(50.dp),
            drawableResId = if (isDarkTheme) R.drawable.ic_baseline_light_mode
            else R.drawable.baseline_home_24,
            contentDescription = "Toggle theme",
            onClick = onThemeToggle
        )*/
        Card(
            modifier = Modifier
                .size(40.dp)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                    shape = Flat(Oval),
                ),
            elevation = 0.dp,
            shape = RoundedCornerShape(24.dp),
        ) {
            IconButton(
                modifier = Modifier.padding(0.dp),
                onClick = onThemeToggle
            ) {
                Icon(
                    painter = painterResource(id =if (isDarkTheme) R.drawable.ic_baseline_light_mode
                            else R.drawable.ic_baseline_dark_mode_24,),
                    contentDescription = Destinations.Pantalla2.title,
                )
            }
        }
    }
}
