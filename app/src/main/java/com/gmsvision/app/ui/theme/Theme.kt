package com.gmsvision.app.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


private val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp)
)


data class CustomColorScheme(
    val navigationBarColor: Color,

    val linkColor: Color,
    val grayVariant: Color,
    val textVariant1: Color,
    val grayTextVariant1: Color,

    val colorScheme: ColorScheme
)

private val DarkColorPalette = darkColorScheme(
    primary = Color(0xFF027EB0),
    secondary = Color(0xFF027EB0),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    surfaceContainer = Color(0xFF121212),
    primaryContainer = Color(0xFF027EB0),
    secondaryContainer = Color(0xFF1E1E1E),
    onSecondaryContainer = Color.White,
    onSurface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    error = Color.Red,
    surfaceContainerLow = Color(0xFF1E1E1E),
    surfaceContainerHighest = Color(0xFF1E1E1E),
    surfaceContainerHigh = Color(0xFF1E1E1E),
    surfaceVariant = Color(0xFF1E1E1E)
)

private val LightColorPalette = lightColorScheme(
    primary = Color(0xFF027EB0),
    secondary = Color(0xFF027EB0),
    background = Color.White,
    surface = Color.White,
    surfaceContainer = Color.White,
    secondaryContainer = Color(red = 232, green = 222, blue = 248),
    primaryContainer = Color(0xFF027EB0),
    onSecondaryContainer = Color(0xFF027EB0),
    onSurface = Color.Black,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    error = Color.Red,
    surfaceContainerLow = Color.White,
    surfaceContainerHighest = Color.White,
    surfaceContainerHigh = Color.White,
    surfaceVariant = Color(0xFF1E1E1E)

)


val CustomDarkColorScheme = CustomColorScheme(
    navigationBarColor = Color.Black,

    linkColor = Color(0xFFBBDEFB),
    grayVariant = Color(0xFF1E1E1E),
    textVariant1 = Color.White,
    grayTextVariant1 = Color.White,

    colorScheme = DarkColorPalette
)

val CustomLightColorScheme = CustomColorScheme(
    navigationBarColor = Color.White,

    linkColor = Color(0xFF1E88E5),
    grayVariant = Color(0xFFF1F3F4),

    textVariant1 = Color(0xFF4F5563),
    grayTextVariant1 = Color.DarkGray,

    colorScheme = LightColorPalette
)


val LocalCustomColorScheme = staticCompositionLocalOf { CustomLightColorScheme }


/*
val CustomFontFamily = FontFamily(
    Font(Res.font.roboto),
    Font(Res.font.roboto_bold, FontWeight.Bold)
)
*/


/*
val customTypography = Typography(
    displayLarge = Typography().displayLarge.copy(fontFamily = CustomFontFamily),
    displayMedium = Typography().displayMedium.copy(fontFamily = CustomFontFamily),
    displaySmall = Typography().displaySmall.copy(fontFamily = CustomFontFamily),
    headlineLarge = Typography().headlineLarge.copy(fontFamily = CustomFontFamily),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = CustomFontFamily),
    headlineSmall = Typography().headlineSmall.copy(fontFamily = CustomFontFamily),
    titleLarge = Typography().titleLarge.copy(fontFamily = CustomFontFamily),
    titleMedium = Typography().titleMedium.copy(fontFamily = CustomFontFamily),
    titleSmall = Typography().titleSmall.copy(fontFamily = CustomFontFamily),
    bodyLarge = Typography().bodyLarge.copy(fontFamily = CustomFontFamily),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = CustomFontFamily),
    bodySmall = Typography().bodySmall.copy(fontFamily = CustomFontFamily),
    labelLarge = Typography().labelLarge.copy(fontFamily = CustomFontFamily),
    labelMedium = Typography().labelMedium.copy(fontFamily = CustomFontFamily),
    labelSmall = Typography().labelSmall.copy(fontFamily = CustomFontFamily)
)
*/


@Composable
fun AppTheme(
    themeMode:Int,
    content: @Composable () -> Unit
) {

    val darkTheme = when (themeMode) {
        1 -> true
        0 -> false
        else -> isSystemInDarkTheme()
    }


    val customColorScheme = if (darkTheme) CustomDarkColorScheme else CustomLightColorScheme

    CompositionLocalProvider(
        LocalCustomColorScheme provides customColorScheme,
    ) {
        MaterialTheme(
            colorScheme = customColorScheme.colorScheme,
            shapes = Shapes,
            /*
                        typography = customTypography,
            */
            content = content
        )
    }
}


val MaterialTheme.customColorScheme: CustomColorScheme
    @Composable
    @ReadOnlyComposable
    get() = LocalCustomColorScheme.current

