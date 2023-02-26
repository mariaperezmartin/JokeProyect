package com.alvarogm.apisremotas.ui.theme.screens

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.AppTextStyle
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


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
    Column() {
        Text(text = "Settings", style = MaterialTheme.typography.h1)
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
            text = "JOKES",
            fontSize = 40.sp,
        )
    }
}

//Botón que controla apariencia
/*@Composable
fun PressedButton(darkMode: Boolean, onThemeToggle: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(120.dp),
    ) {
        Text(
            text = "Appearance",
            fontSize = 25.sp,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
        )
        ImageButton(
            modifier = Modifier.padding(defaultWidgetPadding),
            drawableResId = if (darkMode) R.drawable.ic_baseline_light_mode
            else R.drawable.ic_baseline_dark_mode_24,
            contentDescription = "Toggle theme",
            onClick = onThemeToggle
        )
    }

}*/
/*@Composable
fun TitleWithThemeToggle(title: String, isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = defaultWidgetPadding),
            text = title,
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
}*/

/*@Composable
fun ImageButton(
    modifier: Modifier,
    @DrawableRes drawableResId: Int,
    contentDescription: String = "",
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            //.size(48.dp)
            .height(50.dp)
            .fillMaxSize()
            .neu(
                lightShadowColor = AppColors.lightShadow(),
                darkShadowColor = AppColors.darkShadow(),
                shadowElevation = defaultElevation,
                lightSource = LightSource.LEFT_TOP,
                //shape = Flat(Oval),
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
/*@Composable
fun Button(){
    Column(modifier = Modifier
        .fillMaxSize()
        .height(120.dp)) {
        Button(onClick = {TitleWithThemeToggle}){

        }
    }
}*/

//Spinner de selección lenguaje
@Composable
fun PressedSppiner() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("En", "De", "Es", "Fr")
    val disabledValue = "En"
    var selectedIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp),
    ) {
        Text(
            text = "Language",
            fontSize = 25.sp,
            modifier = Modifier.padding( vertical = 7.dp)
        )
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
                items[selectedIndex],
                textAlign =TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
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

}

//Botón de errores
@Preview
@Composable
fun PressedButtonError() {
    Column(
        modifier = Modifier
            .height(120.dp),
    ) {
        Text(
            text = "Error",
            fontSize = 25.sp,
            modifier = Modifier.padding( vertical = 5.dp)
        )
        var dialogoVisible by rememberSaveable { mutableStateOf(false) }
        Button(
            onClick = { dialogoVisible = true }, modifier = Modifier
                .defaultMinSize(minHeight = 20.dp)
                .fillMaxWidth()

                .neu(defaultFlatNeuAttrs()),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.surface
            ), shape = RoundedCornerShape(9.dp)
        ) {
            Text(
                text = "Problems", style = AppTextStyle.button()
            )
        }
        DialogoAlerta(dialogoVisible, { dialogoVisible = false })
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
    onDismiss: () -> Unit
) {
    val emailBody = remember { //propio mensaje del correo
        mutableStateOf(TextFieldValue())
    }

    val ctx = LocalContext.current
    if (dialogoVisible) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            modifier = Modifier.height(280.dp)
            ,
            title = {
                Text(text = "Problems")
            },
            text = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Write the problem and we will try to solve it")
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        value = emailBody.value,
                        onValueChange = { emailBody.value = it },
                       /* keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),*/
                        label = { Text("Enter email body") },
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
                            backgroundColor =  MaterialTheme.colors.surface,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Row() {

                        Button(
                            onClick = {  onDismiss() }, modifier = Modifier
                                .neu(defaultFlatNeuAttrs())
                            ,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.surface
                            ), shape = RoundedCornerShape(9.dp)
                        ) {
                            Text("Cancel")
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                        Button(onClick = {

                            // on below line we are creating
                            // an intent to send an email
                            val i = Intent(Intent.ACTION_SEND)

                            // on below line we are passing email address,
                            // email subject and email body
                            val emailAddress = arrayOf("soporteappjokes@gmail.com")
                            i.putExtra(Intent.EXTRA_EMAIL,emailAddress)
                            i.putExtra(Intent.EXTRA_SUBJECT,"JokesAPP - Reporte Error")//asunto
                            i.putExtra(Intent.EXTRA_TEXT,emailBody.value.text)

                            // on below line we are
                            // setting type of intent
                            i.setType("message/rfc822")

                            // on the below line we are starting our activity to open email application.
                            ctx.startActivity(Intent.createChooser(i,"Choose an Email client : "))

                        },colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.surface),modifier = Modifier
                            .neu(defaultFlatNeuAttrs())) {
                            // on the below line creating a text for our button.
                            Text("Send")
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
    if (dialogoVisible) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            title = {
                Text(text = "Trabajo Realizado por:")
            },
            text = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Álvaro Gómez Méndez\nFelipe Alejandro Borjas de los Dolores\nMaría Esperanza Pérez Martín")
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = {onDismiss()},colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.surface),modifier = Modifier
                        .neu(defaultFlatNeuAttrs()).fillMaxWidth()) {
                        Text("Great!!")
                    }
                }
            },
            shape = RoundedCornerShape(30.dp),
            confirmButton = {},
            dismissButton = {}
        )
    }
}

/*
@Composable
fun DialogoAlertabn(dialogoVisible: Boolean) {
    Column {
        var dialogoVisible by remember { mutableStateOf(true) }
        if (dialogoVisible) {
            AlertDialog(
                onDismissRequest = {
                    dialogoVisible = false
                },
                title = {
                    Text(text = "Problems")
                },
                text = {
                    Text("Write the problem and we will try to solve it")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            dialogoVisible = false
                        }) {
                        Text("Send")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            dialogoVisible = false
                        }) {
                        Text("Cancel")
                    }
                }
            )
        }

    }
}

@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        */
/*AlertDialog(onDismiss ={onDismiss},

            confirmButton={
                TextButton(onClick = {onConfirm}) {
                    Text(text = "ConfirmButton")
                }
            },
        )*//*

    }
}*/
