package com.alvarogm.apisremotas.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.NeuAttrs
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.*

/*
@Composable
fun Pantalla1(
    navegarPantalla2: (String) -> Unit
) {
    var textValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PANTALLA 1",
            style = TextStyle(color = Color.Black, fontSize = 42.sp, fontWeight = FontWeight.Black)
        )

        TextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text("Introducir Texto") }
        )

        Button(onClick = { navegarPantalla2(textValue) }) {
            Text("Enviar")
        }
    }
}*/

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Pantalla1(
    navController: NavHostController,
    navegarPantalla2: (String, Int) -> Unit
) {
    val mContext = LocalContext.current
    val imageSize = 48.dp
    var textValue by remember { mutableStateOf("1") }

Column(modifier = Modifier
    .fillMaxSize()
    .padding(top = 55.dp)
    .padding(horizontal = 20.dp),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally,


) {
    Column(
        ) {
        Row {
            TextField(
                value = textValue,
                onValueChange = { textValue = it },
                label = { Text("Cantidad de Chistes") },
                modifier = Modifier
                    .width(270.dp)
                    .height(50.dp)
                    .neu(defaultPressedNetAttrs()),
                shape = RoundedCornerShape(20.dp),
                singleLine = false,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    backgroundColor =  MaterialTheme.colors.surface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.size(15.dp))
/*            Button(
                onClick = { navegarPantalla2(textValue) },
                modifier = Modifier
                    .width(100.dp)
                    .height(45.dp)
                    .padding(top = 2.dp)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(RoundedCorner(10.dp)),
                    ),shape = RoundedCornerShape(10.dp)
            ) {
                Text("Enviar")
            }*/
        }
    }
}


Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

    Row {
        Column {
            Card(
                modifier = Modifier

                    .width(150.dp)
                    .height(40.dp)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(RoundedCorner(10.dp)),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp),
                //onClick = { mContext.startActivity(Intent(mContext,ShowJokesActivity::class.java)) }
                // onClick = { navController.navigate(Destinations.Pantalla2.route) }
                onClick = { navegarPantalla2("Any",textValue.toInt()) }
            ) {
               /* Image(
                    painter = painterResource(id = R.drawable.ic_baseline_android_24),
                    contentDescription = "Flat image 1",
                    contentScale = ContentScale.Inside,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                )*/
                //Icon es el que vale
/*                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Destinations.Pantalla2.icon,
                    contentDescription = Destinations.Pantalla2.title
                    //tint = if(selected) Color.Blue else Color.Gray
                )*/
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("ANY")
                }
            }
            Spacer(modifier = Modifier.size(25.dp))
            Card(
                modifier = Modifier

                    .width(150.dp)
                    .height(40.dp)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(RoundedCorner(10.dp)),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp),
                //     onClick = { mContext.startActivity(Intent(mContext,ShowJokesActivity::class.java)) }
                //onClick = { navController.navigate(Destinations.Pantalla2.route) }
                onClick = { navegarPantalla2("Programming",textValue.toInt()) }
            ) {
                /* Image(
                     painter = painterResource(id = R.drawable.ic_baseline_android_24),
                     contentDescription = "Flat image 1",
                     contentScale = ContentScale.Inside,
                     colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                 )*/
                //Icon es el que vale
/*                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Destinations.Pantalla2.icon,
                    contentDescription = Destinations.Pantalla2.title
                    //tint = if(selected) Color.Blue else Color.Gray
                )*/
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("PROGRAMMING")
                }
            }
            Spacer(modifier = Modifier.size(25.dp))
            Card(
                modifier = Modifier

                    .width(150.dp)
                    .height(40.dp)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(RoundedCorner(10.dp)),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp),
                //     onClick = { mContext.startActivity(Intent(mContext,ShowJokesActivity::class.java)) }
                onClick = { navegarPantalla2("Christmas",textValue.toInt()) }
            ) {
                /* Image(
                     painter = painterResource(id = R.drawable.ic_baseline_android_24),
                     contentDescription = "Flat image 1",
                     contentScale = ContentScale.Inside,
                     colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                 )*/
                //Icon es el que vale
/*                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Destinations.Pantalla2.icon,
                    contentDescription = Destinations.Pantalla2.title
                    //tint = if(selected) Color.Blue else Color.Gray
                )*/
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("CHRISTMAS")
                }
            }
            Spacer(modifier = Modifier.size(25.dp))
            Card(
                modifier = Modifier

                    .width(150.dp)
                    .height(40.dp)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        shape = Flat(RoundedCorner(10.dp)),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp),
                //     onClick = { mContext.startActivity(Intent(mContext,ShowJokesActivity::class.java)) }
                //onClick = { navController.navigate(Destinations.Pantalla2.route) }
                onClick = { navegarPantalla2("Spooky",textValue.toInt()) }
            ) {
                /* Image(
                     painter = painterResource(id = R.drawable.ic_baseline_android_24),
                     contentDescription = "Flat image 1",
                     contentScale = ContentScale.Inside,
                     colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                 )*/
                //Icon es el que vale
/*                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Destinations.Pantalla2.icon,
                    contentDescription = Destinations.Pantalla2.title
                    //tint = if(selected) Color.Blue else Color.Gray
                )*/
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("SPOOKY")
                }
            }
        }
        Spacer(modifier = Modifier.size(50.dp))
        Column() {
            Card(
                modifier = Modifier

                    .width(150.dp)
                    .height(40.dp)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.RIGHT_TOP,
                        shape = Flat(RoundedCorner(10.dp)),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp),
                //     onClick = { mContext.startActivity(Intent(mContext,ShowJokesActivity::class.java)) }
                onClick = { navegarPantalla2("MisBromas",textValue.toInt()) }
            ) {
                /* Image(
                     painter = painterResource(id = R.drawable.ic_baseline_android_24),
                     contentDescription = "Flat image 1",
                     contentScale = ContentScale.Inside,
                     colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                 )*/
                //Icon es el que vale
/*                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Destinations.Pantalla2.icon,
                    contentDescription = Destinations.Pantalla2.title
                    //tint = if(selected) Color.Blue else Color.Gray
                )*/
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("MIS BROMAS")
                }
            }
            Spacer(modifier = Modifier.size(25.dp))
            Card(
                modifier = Modifier

                    .width(150.dp)
                    .height(40.dp)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.RIGHT_TOP,
                        shape = Flat(RoundedCorner(10.dp)),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp),
                //     onClick = { mContext.startActivity(Intent(mContext,ShowJokesActivity::class.java)) }
                onClick = { navegarPantalla2("Miscellaneous",textValue.toInt()) }
            ) {
                /* Image(
                     painter = painterResource(id = R.drawable.ic_baseline_android_24),
                     contentDescription = "Flat image 1",
                     contentScale = ContentScale.Inside,
                     colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                 )*/
                //Icon es el que vale
/*                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Destinations.Pantalla2.icon,
                    contentDescription = Destinations.Pantalla2.title
                    //tint = if(selected) Color.Blue else Color.Gray
                )*/
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("MISC")
                }
            }
            Spacer(modifier = Modifier.size(25.dp))
            Card(
                modifier = Modifier

                    .width(150.dp)
                    .height(40.dp)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.RIGHT_TOP,
                        shape = Flat(RoundedCorner(10.dp)),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp),
                //     onClick = { mContext.startActivity(Intent(mContext,ShowJokesActivity::class.java)) }
                onClick = { navegarPantalla2("Dark",textValue.toInt()) }
            ) {
                /* Image(
                     painter = painterResource(id = R.drawable.ic_baseline_android_24),
                     contentDescription = "Flat image 1",
                     contentScale = ContentScale.Inside,
                     colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                 )*/
                //Icon es el que vale
/*                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Destinations.Pantalla2.icon,
                    contentDescription = Destinations.Pantalla2.title
                    //tint = if(selected) Color.Blue else Color.Gray
                )*/
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("DARK")
                }
            }
            Spacer(modifier = Modifier.size(25.dp))
            Card(
                modifier = Modifier

                    .width(150.dp)
                    .height(40.dp)
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.RIGHT_TOP,
                        shape = Flat(RoundedCorner(10.dp)),
                    ),
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp),
                //     onClick = { mContext.startActivity(Intent(mContext,ShowJokesActivity::class.java)) }
                onClick = { navegarPantalla2("Pun",textValue.toInt()) }
            ) {
                /* Image(
                     painter = painterResource(id = R.drawable.ic_baseline_android_24),
                     contentDescription = "Flat image 1",
                     contentScale = ContentScale.Inside,
                     colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                 )*/
                //Icon es el que vale
/*                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Destinations.Pantalla2.icon,
                    contentDescription = Destinations.Pantalla2.title
                    //tint = if(selected) Color.Blue else Color.Gray
                )*/
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("PUN")
                }
            }
        }
}

    }

   /* Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PANTALLA 1",
            style = TextStyle(color = Color.Black, fontSize = 42.sp, fontWeight = FontWeight.Black)
        )

        TextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text("Introducir Texto") }
        )

        Button(onClick = { navegarPantalla2(textValue) }) {
            Text("Enviar")
        }
    }*/
}
@Composable
fun DefaultSpacer() = Spacer(modifier = Modifier.size(8.dp))
val defaultWidgetPadding = 16.dp
val defaultElevation = 6.dp
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
    shape = Flat(RoundedCorner(10.dp))
)