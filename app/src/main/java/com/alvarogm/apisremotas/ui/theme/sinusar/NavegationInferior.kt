package com.alvarogm.apisremotas.ui.theme.sinusar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.NeuAttrs
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.*

/*@Composable
fun NavegationInferior(navController: NavHostController, menu_items: List<Items_menu>) {
    BottomAppBar(Modifier.height(80.dp)) {
        BottomNavigation(Modifier.height(80.dp)) {
            val currentRoute = currentRoute(navController = navController)
            menu_items.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.route,
                    onClick = { navController.navigate(item.route) },
                    icon = {
                        Card(
                            modifier = Modifier
                                .size(48.dp)
                                .padding(5.dp)
                                .neu(
                                    lightShadowColor = AppColors.lightShadow(),
                                    darkShadowColor = AppColors.darkShadow(),
                                    shadowElevation = defaultElevation,
                                    lightSource = LightSource.LEFT_TOP,
                                    shape = Flat(Oval),
                                ),
                            elevation = 0.dp,
                            shape = RoundedCornerShape(24.dp)
                        ) {
                            Image(
                                painter = painterResource(id = item.icon),
                                contentDescription = "Flat image 1",
                                contentScale = ContentScale.Inside,
                                colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary)
                            )
                        }
                    },
                    label = { Text(text = item.title)}
                    , alwaysShowLabel = false
                )
            }
        }
    }
}*/


/*
@Composable
fun DefaultSpacer() = Spacer(modifier = Modifier.size(8.dp))
val defaultWidgetPadding = 16.dp
val defaultElevation = 2.dp
val defaultCornerShape: CornerShape = RoundedCorner(12.dp)

@Composable
fun defaultPressedNetAttrs() = NeuAttrs(
    lightShadowColor = AppColors.lightShadow(),
    darkShadowColor = AppColors.darkShadow(),
    shadowElevation = defaultElevation,
    lightSource = LightSource.LEFT_TOP,
    shape = Pressed(defaultCornerShape),
)

@Composable
fun defaultFlatNeuAttrs() = NeuAttrs(
    lightShadowColor = AppColors.lightShadow(),
    darkShadowColor = AppColors.darkShadow(),
    shadowElevation = defaultElevation,
    lightSource = LightSource.LEFT_TOP,
    shape = Flat(RoundedCorner(0.dp))
)

@Composable
fun currentRoute(navController: NavHostController): String? {
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}*/
