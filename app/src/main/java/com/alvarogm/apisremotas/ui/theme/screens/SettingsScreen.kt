package com.alvarogm.apisremotas.ui.theme.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import com.alvarogm.apisremotas.data.local.preferences.StoreUserLanguage
import com.alvarogm.apisremotas.presentation.JokesViewModel
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.AppTextStyle
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import kotlinx.coroutines.launch


/*

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }
}


@Preview(showBackground = true,
    name ="prueba 1",
    widthDp = 400,
    heightDp = 100,)
@Composable
fun PressedButton() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Appearance",
            fontSize = 25.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Button(
            onClick = { }, modifier = Modifier
                .fillMaxWidth()
                .padding(defaultWidgetPadding)
                .neu(defaultPressedNetAttrs()),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.surface,
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = null

        ) {
            Text(text = "Button", style = AppTextStyle.button())
        }
    }
}

//Botón que controla apariencia
@Composable
fun TitleWithThemeToggle(isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = defaultWidgetPadding),
            text = "Jokes",
            style = AppTextStyle.body1(), maxLines = 1
        )
        ImageButton(
            modifier = Modifier.padding(defaultWidgetPadding),
            drawableResId = if (isDarkTheme) R.drawable.ic_baseline_light_mode
            else R.drawable.ic_baseline_dark_mode_24,
            contentDescription = "Toggle theme",
            onClick = onThemeToggle
        )
    }
}

@Composable
fun ImageButton(
    modifier: Modifier,
    @DrawableRes drawableResId: Int,
    contentDescription: String = "",
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .size(48.dp)
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                shape = Flat(Oval),
            ),
        elevation = 0.dp,
        shape = RoundedCornerShape(24.dp),
    ) {
        Image(
            modifier = Modifier.clickable(true, onClick = onClick),
            painter = painterResource(id = drawableResId),
            contentDescription = contentDescription,
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
    }
}*/
@Composable
fun SettingsScreen() {
    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")

    Column() {
        Text(


            if (savedEmail.value == "Es") {
                "Ajustes"
            } else {
                "Settings"
            }, style = MaterialTheme.typography.h1
        )
    }
}


//Título de actividad
@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun TitleApp() {
    Row(
        modifier = Modifier.padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "JOKESAPP",
            fontSize = 40.sp,
        )
    }
}

//Spinner de selección lenguaje
@Composable
fun PressedSppiner(context: Context, viewModel: JokesViewModel) {
    var expanded by remember { mutableStateOf(false) }
    var s by remember { mutableStateOf(viewModel.getMyPreference()) }
    val items = listOf("En", "De", "Es", "Fr")
    val disabledValue = "En"
    var selectedIndex by remember { mutableStateOf(0) }

    val scope = rememberCoroutineScope()
    // datastore Email
    val dataStore = StoreUserLanguage(context)
    // get saved email
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")

    var language by remember { mutableStateOf("") }

    val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    val selectedLanguage = sharedPreferences.getString("selectedLanguage", "en")
    // Definimos la variable que guardará el idioma seleccionado
    var languageSelection by remember { mutableStateOf(selectedLanguage) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp),
    ) {
        Text(
            if (savedEmail.value == "Es") {
                "Lenguaje"
            } else {
                "Language"
            } ,
            fontSize = 25.sp,
            modifier = Modifier.padding(vertical = 7.dp)
        )
        /* Text(
             text = "pruebaaaa"+savedEmail.value!!,
             color = Color.Black,
             fontSize = 18.sp
         )*/
        //Empieza Spinner
        Card(
            modifier = Modifier
                .fillMaxSize()
                //.padding(defaultWidgetPadding)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                ),
            elevation = 0.dp,
            shape = RoundedCornerShape(9.dp),
        ) {
            Text(
                //items[selectedIndex],
                savedEmail.value.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize().padding(top=8.dp)
                    //.padding(horizontal = 20.dp, 7.dp)
                    .clickable(onClick = { expanded = true })
            )
            androidx.compose.material.DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.padding(defaultWidgetPadding),
            ) {
                items.forEachIndexed { index, s ->
                    DropdownMenuItem(onClick = {
                        selectedIndex = index
                        expanded = false
                        /*                 with(sharedPreferences.edit()) {
                                             putString("selectedLanguage", s)
                                             apply()
                                         }*/

                        scope.launch {
                            dataStore.saveLanguage(s)
                        }
                    }) {
                        val disabledText = if (s == disabledValue) {
                            " (Disabled)"
                        } else {
                            ""
                        }
                        Text(text = s + disabledText)
                    }
                }
            }
        }


    }
    LaunchedEffect(viewModel) {
        if (!s.equals("")) {
            viewModel.setMyPreference(s)
        }
    }

}


//Botón de errores
@Preview
@Composable
fun PressedButtonError() {
    val emailBody = remember { //propio mensaje del correo
        mutableStateOf(TextFieldValue(""))
    }
    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")
    Column(
        modifier = Modifier
            .height(120.dp),
    ) {
        Text(
            if (savedEmail.value == "Es") {
                "Errores"
            } else {
                "Error"
            },
            fontSize = 25.sp,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        var dialogoVisible by rememberSaveable { mutableStateOf(false) }
        Button(
            onClick = { dialogoVisible = true; emailBody.value = TextFieldValue(" ") },
            modifier = Modifier
                .defaultMinSize(minHeight = 20.dp)
                .fillMaxWidth()

                .neu(defaultFlatNeuAttrs()),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
            shape = RoundedCornerShape(9.dp)
        ) {
            Text(
                if (savedEmail.value == "Es") {
                    "Problemas"
                } else {
                    "Problems"
                }, style = AppTextStyle.button()
            )
        }
        DialogoAlerta(dialogoVisible, { dialogoVisible = false }, emailBody)
    }
}

//Botón de Versión
@Preview
@Composable
fun PressedButtonVersion() {
    Column(
        modifier = Modifier
            .height(150.dp),
    ) {
        Text(
            text = "Version",
            fontSize = 25.sp,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        var dialogoVisibleVersion by rememberSaveable { mutableStateOf(false) }
        Button(
            onClick = { dialogoVisibleVersion = true }, modifier = Modifier
                .defaultMinSize(minHeight = 20.dp)
                .fillMaxWidth()

                .neu(defaultFlatNeuAttrs()),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.surface
            ), shape = RoundedCornerShape(9.dp)
        ) {
            Box(
                modifier = Modifier.padding(0.dp),
                Alignment.CenterStart
            ) {
                Text("1.0")
            }
        }
        DialogoAlertaVersion(dialogoVisibleVersion, { dialogoVisibleVersion = false })
    }
}

//Ventana emergente /diálogo

@Composable
fun DialogoAlerta(
    dialogoVisible: Boolean,
    onDismiss: () -> Unit,
    emailBody: MutableState<TextFieldValue>
) {

    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")

    val ctx = LocalContext.current
    if (dialogoVisible) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            modifier = Modifier.height(280.dp),
            title = {
                Text( if (savedEmail.value == "Es") {
                    "Problemas"
                } else {
                    "Problems"
                })
            },
            text = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(if (savedEmail.value == "Es") {
                        "Escribe el problema y lo resolveremos"
                    } else {
                        "Write down the problem and we will solve it"
                    })
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        value = emailBody.value,
                        onValueChange = { emailBody.value = it },
                        /* keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),*/
                        label = { Text(if (savedEmail.value == "Es") {
                            "Introduzca el mensaje"
                        } else {
                            "Enter email body"
                        }) },
                        modifier = Modifier
                            /* .width(270.dp)
                            .height(65.dp)*/
                            .height(55.dp)
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
                    Spacer(modifier = Modifier.height(25.dp))
                    Row() {

                        Button(
                            onClick = { onDismiss() }, modifier = Modifier
                                .neu(defaultFlatNeuAttrs()),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.surface
                            ), shape = RoundedCornerShape(9.dp)
                        ) {
                            Text(if (savedEmail.value == "Es") {
                                "Cancelar"
                            } else {
                                "Cancel"
                            })
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                        Button(
                            onClick = {

                                // on below line we are creating
                                // an intent to send an email
                                val i = Intent(Intent.ACTION_SEND)

                                // on below line we are passing email address,
                                // email subject and email body
                                val emailAddress = arrayOf("soporteappjokes@gmail.com")
                                i.putExtra(Intent.EXTRA_EMAIL, emailAddress)
                                i.putExtra(Intent.EXTRA_SUBJECT, "JokesAPP - Reporte Error")//asunto
                                i.putExtra(Intent.EXTRA_TEXT, emailBody.value.text)

                                // on below line we are
                                // setting type of intent
                                i.setType("message/rfc822")

                                // on the below line we are starting our activity to open email application.
                                ctx.startActivity(
                                    Intent.createChooser(
                                        i,
                                        "Choose an Email client : "
                                    )
                                )
                                // onDismiss() //Dependiendo de como se vea, se pone o se quita el Dismiss

                            }, colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.surface
                            ), modifier = Modifier
                                .neu(defaultFlatNeuAttrs())
                        ) {
                            // on the below line creating a text for our button.
                            Text(if (savedEmail.value == "Es") {
                                "Enviar"
                            } else {
                                "Send"
                            })
                        }
                    }

                }
            },
            shape = RoundedCornerShape(24.dp),
            confirmButton = {},
            dismissButton = {}
        )
    }
}

@Composable
fun DialogoAlertaVersion(
    dialogoVisible: Boolean,
    onDismiss: () -> Unit,
) {

    val mContext = LocalContext.current
    val dataStore = StoreUserLanguage(mContext)
    val savedEmail = dataStore.getLanguage.collectAsState(initial = "")
    if (dialogoVisible) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            title = {
                Text(if (savedEmail.value == "Es") {
                    "Trabajo realizado por:"
                } else {
                    "Work done by:"
                })
            },
            text = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Álvaro Gómez Méndez\nFelipe Alejandro Borjas de los Dolores\nMaría Esperanza Pérez Martín")
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { onDismiss() }, colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.surface
                        ), modifier = Modifier
                            .neu(defaultFlatNeuAttrs())
                            .fillMaxWidth()
                    ) {
                        Text(if (savedEmail.value == "Es") {
                            "Genial!!"
                        } else {
                            "Great!!"
                        })
                    }
                }
            },
            shape = RoundedCornerShape(30.dp),
            confirmButton = {},
            dismissButton = {}
        )
    }
}