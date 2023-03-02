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
    navegarPantalla2: (String, String, Int) -> Unit
) {
    var textValue by remember { mutableStateOf("1") }
    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")
    val numberRegex = """^[1-9]|10$""".toRegex()
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
                            val newValue = it.replace(Regex("[,.]"), "")
                            if (numberRegex.matches(newValue)) {
                                textValue = newValue
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

                        .width(160.dp)
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

                        .width(160.dp)
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
                            when (savedEmail.value.toString()) {
                                "Es" -> "PROGRAMACIÓN"
                                "En" -> "PROGRAMMING"
                                //"De" -> "PROGRAMMIERUNG"
                                //"Fr" -> "PROGRAMMATION"
                                "De" -> "PROGRAMM"
                                "Fr" -> "PROGRAMM"
                                else -> {"PROGRAMMING"}
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(25.dp))
                Card(
                    modifier = Modifier

                        .width(160.dp)
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
                    onClick = { navegarPantalla2("Christmas", savedEmail.value.toString(),textValue.toInt()) }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            when (savedEmail.value.toString()) {
                                "Es" -> "NAVIDAD"
                                "En" -> "CHRISTMAS"
                                "De" -> "WEIHNACHTEN"
                                "Fr" -> "NOËL"
                                else -> {"CHRISTMAS"}
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(25.dp))
                Card(
                    modifier = Modifier

                        .width(160.dp)
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
                    onClick = { navegarPantalla2("Spooky", savedEmail.value.toString(),textValue.toInt()) }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            when (savedEmail.value.toString()) {
                                "Es" -> "ESPELUZNANTE"
                                "En" -> "SPOOKY"
                                "De" -> "GESPENSTISCH"
                                "Fr" -> "EFFRAYANT"
                                else -> {"SPOOKY"}
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.size(50.dp))
            Column() {
                Card(
                    modifier = Modifier

                        .width(160.dp)
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
                    onClick = { navegarPantalla2("MisBromas", savedEmail.value.toString(),textValue.toInt()) }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            when (savedEmail.value.toString()) {
                                "Es" -> "MIS BROMAS"
                                "En" -> "MY JOKES"
                                "De" -> "MEINE WITZE"
                                "Fr" -> "MES BLAGUES"
                                else -> {"MY JOKES"}
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(25.dp))
                Card(
                    modifier = Modifier

                        .width(160.dp)
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
                    onClick = { navegarPantalla2("Miscellaneous",savedEmail.value.toString(), textValue.toInt()) }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            when (savedEmail.value.toString()) {
                                "Es" -> "Varios"
                                "En" -> "MISC"
                                "De" -> "VERSCHIEDENES"
                                "Fr" -> "Plusieurs"
                                else -> {"MISC"}
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(25.dp))
                Card(
                    modifier = Modifier

                        .width(160.dp)
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
                    onClick = { navegarPantalla2("Dark",savedEmail.value.toString(), textValue.toInt()) }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            when (savedEmail.value.toString()) {
                                "Es" -> "OSCUROS"
                                "En" -> "DARK"
                                "De" -> "DUNKEL"
                                "Fr" -> "SOMBRE"
                                else -> {"DARK"}
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(25.dp))
                Card(
                    modifier = Modifier

                        .width(160.dp)
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
                    onClick = { navegarPantalla2("Pun",savedEmail.value.toString(), textValue.toInt()) }
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            when (savedEmail.value.toString()) {
                                "Es" -> "JUEGO PALABRAS"
                                "En" -> "PUN"
                                "De" -> "WORTSPIEL"
                                "Fr" -> "JEU DE MOTS"
                                else -> {"PUN"}
                            }
                        )
                    }
                }
            }
        }

    }
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