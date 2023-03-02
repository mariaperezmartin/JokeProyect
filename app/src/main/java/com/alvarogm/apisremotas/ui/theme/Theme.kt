package com.alvarogm.apisremotas.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.alvarogm.apisremotas.ui.theme.AppColors.Purple200

private val DarkColorPalette = darkColors(
    primary = Purple200,
    onPrimary = Color.White,
    secondary = AppColors.Purple500,
    background = AppColors.Dark.Background,
    onBackground = Color.White,
    surface = AppColors.Dark.Background,
    onSurface = Color.White,
)

private val LightColorPalette = lightColors(
    primary = Purple200,
    onPrimary = Color.Black,
    secondary = AppColors.Purple500,
    background = AppColors.Light.Background,
    onBackground = Color.Black,
    surface = AppColors.Light.Background,
    onSurface = Color.Black,
)

@Composable
fun ApisRemotasTheme(isDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (isDarkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = getTypography(isDarkTheme),
        shapes = Shapes,
        content = content
    )
}