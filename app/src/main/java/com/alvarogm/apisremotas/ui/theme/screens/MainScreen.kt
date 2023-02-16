import android.annotation.SuppressLint
import android.provider.Settings.Global.getString
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.alvarogm.apisremotas.R
import com.alvarogm.apisremotas.TitleWithThemeToggle
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.navigation.Destinations
import com.alvarogm.apisremotas.ui.theme.navigation.NavigationHost
import com.alvarogm.apisremotas.ui.theme.screens.BottomNavigationBar
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    darkMode: Boolean,
    viewModel: JokesViewModel,
    onThemeToggle: () -> Unit
) {
   /* var isDarkTheme by remember { mutableStateOf(darkMode) }
    isDarkTheme = darkMode*/
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val openDialog = remember { mutableStateOf(false) }

    val navigationItems = listOf(
        Destinations.Pantalla2,
        Destinations.Pantalla1,
        Destinations.Pantalla3
    )

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { BottomNavigationBar(navController = navController, items = navigationItems) },
    ){
/*         Column(horizontalAlignment = Alignment.End, modifier = Modifier.shadow(0.dp)) {
                       TitleWithThemeToggle(
                           title = "etString(R.string.app_name)",
                           isDarkTheme = darkMode
                       )
                   }*/
        NavigationHost(navController, darkMode, viewModel,scaffoldState ,coroutineScope)
    }

 /*   fun miFuncion(snackbarHostState: SnackbarHostState) {
        scope.launch {
            snackbarHostState.showSnackbar("Mi mensaje de Snackbar")
        }
    }*/
   /* Dialog(showDialog = openDialog.value, dismissDialog = { openDialog.value = false })*/
}

