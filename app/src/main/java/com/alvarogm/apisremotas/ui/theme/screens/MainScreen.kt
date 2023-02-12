import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.navigation.Destinations
import com.alvarogm.apisremotas.ui.theme.navigation.NavigationHost
import com.alvarogm.apisremotas.ui.theme.screens.BottomNavigationBar

@Composable
fun MainScreen(
    darkMode: MutableState<Boolean>,
    viewModel: JokesViewModel
) {

    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
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
/*        floatingActionButton = { FloatingActionButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Fab Icon")
        } },
        isFloatingActionButtonDocked = false,
        floatingActionButtonPosition = FabPosition.End,*/
/*        topBar = {
            TopBar(
                scope,
                scaffoldState,
                openDialog = { openDialog.value = true  },
                displaySnackBar = {
                    scope.launch {
                        val resultado = scaffoldState.snackbarHostState.showSnackbar(
                            message = "Nuevo SnackBar!",
                            duration = SnackbarDuration.Short,
                            actionLabel = "Aceptar"
                        )

                        when(resultado){
                            SnackbarResult.ActionPerformed -> {
                                Log.d("MainActivity", "Snackbar Accionado")
                            }
                            SnackbarResult.Dismissed -> {
                                Log.d("MainActivity", "Snackbar Ignorado")
                            }
                        }
                    }
                }
            )
        },*/
      //  drawerContent = { Drawer(scope, scaffoldState, navController, items = navigationItems) },
      //  drawerGesturesEnabled = true
    ){
        NavigationHost(navController, darkMode, viewModel)
    }

   /* Dialog(showDialog = openDialog.value, dismissDialog = { openDialog.value = false })*/
}

