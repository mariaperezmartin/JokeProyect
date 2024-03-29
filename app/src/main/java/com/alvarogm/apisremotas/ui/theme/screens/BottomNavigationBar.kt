package com.alvarogm.apisremotas.ui.theme.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.navigation.Destinations
import com.alvarogm.apisremotas.ui.theme.navigation.currentRoute
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.Oval

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<Destinations>
) {
    val currentRoute = currentRoute(navController)

    BottomNavigation(
        Modifier.height(80.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = Color.Black,

        ) {
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Card(
                        modifier = Modifier
                            .size(48.dp)
                            .padding(5.dp)
                            .neu(
                                lightShadowColor = AppColors.lightShadow(),
                                darkShadowColor = AppColors.darkShadow(),
                                shadowElevation = 2.dp,
                                lightSource = LightSource.LEFT_TOP,
                                shape = Flat(Oval),
                            ),
                        elevation = 0.dp,
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Icon(
                            modifier = Modifier.size(1.dp),
                            imageVector = screen.icon,
                            contentDescription = screen.title,
                        )
                    }
                },
                label = {
                    Text(
                        screen.title,
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = false,
            )
        }
    }
}