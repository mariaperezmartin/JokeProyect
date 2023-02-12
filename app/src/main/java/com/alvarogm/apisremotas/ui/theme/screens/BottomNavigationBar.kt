package com.alvarogm.apisremotas.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.AppColors.Light.Background
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
        Modifier.height(80.dp).shadow(elevation = 10.dp, clip = true).background(Color.Black),
        backgroundColor = Background,
        contentColor = Color.Black,

    ) {
        items.forEach { screen ->
            BottomNavigationItem(
               // icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
                icon = {    Card(
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
                /*     Image(
                         painter = painterResource(id = screen.icon),
                         contentDescription = "Flat image 1",
                         contentScale = ContentScale.Inside,
                         colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary)
                     )*/
                    Icon(
                        modifier = Modifier.size(32.dp),
                        imageVector = screen.icon,
                        contentDescription = screen.title
                        //tint = if(selected) Color.Blue else Color.Gray
                    )
                } },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                      navController.navigate(screen.route) {
                          popUpTo(navController.graph.findStartDestination().id){
                              saveState = true
                          }

                          launchSingleTop = true
                      }
                },
                alwaysShowLabel = false
            )
        }
    }
}