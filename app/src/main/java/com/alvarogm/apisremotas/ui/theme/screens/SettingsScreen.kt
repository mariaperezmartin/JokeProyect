package com.alvarogm.apisremotas.ui.theme.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.alvarogm.apisremotas.R
import com.alvarogm.apisremotas.ui.theme.AppColors
import com.alvarogm.apisremotas.ui.theme.AppTextStyle
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.*

//Título de actividad
@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun TitleApp(){
    Row(
        modifier = Modifier.padding( vertical = 5.dp),
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "JOKES",
            fontSize = 40.sp,
        )
    }
}

//Botón que controla apariencia
@Composable
fun PressedButton(isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
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
}


//Spinner de selección lenguaje
/*fun DropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset = DpOffset(0.dp, 0.dp),
    properties: PopupProperties = PopupProperties(focusable = true),
    content: @Composable ColumnScope.() -> Unit
) {
}*/


@Composable
fun PressedSppiner() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("En", "De", "Es", "Fr")
    val disabledValue = "En"
    var selectedIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(120.dp),
    ) {
        Text(
            text = "Language",
            fontSize = 25.sp,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
        )
        //Empieza Spinner
        Card(
            modifier = Modifier
                .padding(defaultWidgetPadding)
                .neu(
                    lightShadowColor = AppColors.lightShadow(),
                    darkShadowColor = AppColors.darkShadow(),
                    shadowElevation = defaultElevation,
                    lightSource = LightSource.LEFT_TOP,
                ),
            elevation = 0.dp,
            shape = RoundedCornerShape(24.dp),
        ) {
            Text(
                items[selectedIndex],
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, 5.dp)
                    .clickable(onClick = { expanded = true }))
            androidx.compose.material.DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.Gray
                    )

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
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Card(
                modifier = Modifier
                    .padding(defaultWidgetPadding)
                    .height(50.dp)
                    .fillMaxSize()
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        //shape = Flat(Oval),


                    )
                    .clickable(true, onClick = {}),
            elevation = 0.dp,
            shape = RoundedCornerShape(24.dp),
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    //horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "Android")
                    Text(text = "Problems" ,
                        modifier = Modifier.padding(12.dp))
                }
            }
        }
    }
}

//Botón de Versión
@Preview
@Composable
fun PressedButtonVersion() {
    Column(
        modifier = Modifier
            .height(120.dp),
    ) {
        Text(
            text = "Version",
            fontSize = 25.sp,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Card(
                modifier = Modifier
                    .padding(defaultWidgetPadding)
                    .height(50.dp)
                    .fillMaxSize()
                    .neu(
                        lightShadowColor = AppColors.lightShadow(),
                        darkShadowColor = AppColors.darkShadow(),
                        shadowElevation = defaultElevation,
                        lightSource = LightSource.LEFT_TOP,
                        //shape = Flat(Oval),


                    ),
                    //.clickable(true, onClick = {}),
                elevation = 0.dp,
                shape = RoundedCornerShape(24.dp),
            ){
                Text(text = "V.1" ,
                    modifier = Modifier.padding(12.dp))
            }
        }
    }
}