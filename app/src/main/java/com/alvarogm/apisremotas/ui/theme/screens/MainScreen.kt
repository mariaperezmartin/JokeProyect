import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.alvarogm.apisremotas.data.local.preferences.StoreUserLanguage
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

    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")

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

