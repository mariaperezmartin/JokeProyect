package com.alvarogm.apisremotas.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alvarogm.apisremotas.data.local.preferences.StoreUserLanguage
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.NeuAttrs
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Pantalla1(
    navController: NavHostController,
    navegarPantalla2: (String, String, Int) -> Unit
) {
    val imageSize = 48.dp
    var textValue by remember { mutableStateOf("1") }
    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")
    Column(
        modifier = Modifier
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
                    onValueChange = {
                        if (it.isEmpty()) {
                            textValue = it
                        } else {
                            textValue = when (it.toDoubleOrNull()) {
                                null -> textValue //old value
                                else -> it   //new value
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = {
                        Text(

                            when (savedEmail.value.toString()) {
                                "Es" -> "Cantidad de bromas"
                                "En" -> "Amount of jokes"
                                "De" -> "Anzahl der Witze"
                                "Fr" -> "Nombre de blagues"
                                else -> {"Amount of jokes"}
                            }
                        )
                    },
                    modifier = Modifier
                        .width(270.dp)
                        .height(65.dp)
                        .neu(defaultPressedNetAttrs()),
                    shape = RoundedCornerShape(20.dp),
                    singleLine = false,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = MaterialTheme.colors.surface,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.size(15.dp))
            }
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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
                    onClick = { navegarPantalla2("Any",savedEmail.value.toString(),textValue.toInt())
                     }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            when (savedEmail.value.toString()) {
                                "Es" -> "CUALQUIERA"
                                "En" -> "ANY"
                                "De" -> "ALLE"
                                "Fr" -> "TOUS"
                                else -> {"ANY"}
                            }
                        )
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
                    //onClick = { mContext.startActivity(Intent(mContext,ShowJokesActivity::class.java)) }
                    //onClick = { navController.navigate(Destinations.Pantalla2.route) }

                    onClick = {
                        navegarPantalla2("Programming",savedEmail.value.toString(), textValue.toInt())
                    }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            if (savedEmail.value == "Es") {
                                "PROGRAMACION"
                            } else {
                                "PROGRAMMING"
                            }
                        )
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
                    onClick = { navegarPantalla2("Christmas", savedEmail.value.toString(),textValue.toInt()) }
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
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(
                            if (savedEmail.value == "Es") {
                                "NAVIDAD"
                            } else {
                                "CHRISTMAS"
                            }
                        )
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
                    onClick = { navegarPantalla2("Spooky", savedEmail.value.toString(),textValue.toInt()) }
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
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(
                            if (savedEmail.value == "Es") {
                                "ESPELUZNANTE"
                            } else {
                                "SPOOKY"
                            }
                        )
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
                    onClick = { navegarPantalla2("MisBromas", savedEmail.value.toString(),textValue.toInt()) }
                ) {
                    /*          Image(
                                  painter = painterResource(id = R.drawable.ic_baseline_android_24),
                                  contentDescription = "Flat image 1",
                                  contentScale = ContentScale.Inside,
                                  colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                              )*/
                    //Icon es el que vale
                    /*    Icon(
                              modifier = Modifier.size(32.dp),
                              imageVector = R.drawable.,
                              contentDescription = Destinations.Pantalla2.title
                              //tint = if(selected) Color.Blue else Color.Gray
                          )*/
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(
                            if (savedEmail.value == "Es") {
                                "MIS BROMAS"
                            } else {
                                "MY JOKES"
                            }
                        )
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
                    onClick = { navegarPantalla2("Miscellaneous",savedEmail.value.toString(), textValue.toInt()) }
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
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(
                            if (savedEmail.value == "Es") {
                                "Varios"
                            } else {
                                "MISC"
                            }
                        )
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
                    onClick = { navegarPantalla2("Dark",savedEmail.value.toString(), textValue.toInt()) }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(
                            if (savedEmail.value == "Es") {
                                "OSCUROS"
                            } else {
                                "DARK"
                            }
                        )
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
                    onClick = { navegarPantalla2("Pun",savedEmail.value.toString(), textValue.toInt()) }
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
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            if (savedEmail.value == "Es") {
                                "JU. PALABRAS"
                            } else {
                                "PUN"
                            }
                        )
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