import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.navigation.Destinations
import com.alvarogm.apisremotas.ui.theme.navigation.NavigationHost
import com.alvarogm.apisremotas.ui.theme.screens.BottomNavigationBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    darkMode: MutableState<Boolean>,
    viewModel: JokesViewModel
) {

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
        NavigationHost(navController, darkMode, viewModel,scaffoldState ,coroutineScope)
    }

 /*   fun miFuncion(snackbarHostState: SnackbarHostState) {
        scope.launch {
            snackbarHostState.showSnackbar("Mi mensaje de Snackbar")
        }
    }*/
   /* Dialog(showDialog = openDialog.value, dismissDialog = { openDialog.value = false })*/
}

