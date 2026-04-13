package com.example.template.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = TealPrimary,
    onPrimary = OnDarkPrimary,
    primaryContainer = TealPrimaryContainer,

    secondary = AmberSecondary,
    onSecondary = Color.Black,
    secondaryContainer = AmberSecondaryContainer,

    tertiary = PurpleTertiary,
    tertiaryContainer = PurpleTertiaryContainer,

    background = DarkBackground,
    onBackground = OnDarkSurface,

    surface = DarkSurface,
    onSurface = OnDarkSurface,

    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = OnDarkSurfaceVariant,

    outline = Color(0xFF4A4F55)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00796B),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFB2DFDB),

    secondary = Color(0xFFF9A825),
    onSecondary = Color.Black,

    tertiary = Color(0xFF7B1FA2),

    background = Color(0xFFFAFAFA),
    onBackground = Color(0xFF1C1B1F),

    surface = Color.White,
    onSurface = Color(0xFF1C1B1F),

    surfaceVariant = Color(0xFFE7E7E7),
    onSurfaceVariant = Color(0xFF4A4A4A),

    outline = Color(0xFF8A8A8A)
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}