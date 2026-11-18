package com.example.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.model.ThemePreference

private val LightColorScheme = lightColorScheme(
    primary = CrimsonPrimary,
    onPrimary = Color.White,
    primaryContainer = CrimsonPrimaryContainer,
    onPrimaryContainer = OnCrimsonPrimaryContainer,
    secondary = OxfordNavy,
    onSecondary = Color.White,
    secondaryContainer = OxfordNavyContainer,
    onSecondaryContainer = OnOxfordNavyContainer,
    tertiary = WarmAmber,
    onTertiary = Color.White,
    tertiaryContainer = WarmAmberContainer,
    onTertiaryContainer = OnWarmAmberContainer,
    background = IvoryBackground,
    onBackground = InkText,
    surface = WarmPaperSurface,
    onSurface = InkText,
    surfaceVariant = WarmPaperVariant,
    onSurfaceVariant = InkTextMuted,
    outline = InkOutline,
    outlineVariant = InkOutline.copy(alpha = 0.6f),
    error = GrammarErrorLight,
    onError = Color.White,
    errorContainer = GrammarErrorBgLight,
    onErrorContainer = Color(0xFF7F1D1D)
)

private val DarkColorScheme = darkColorScheme(
    primary = CrimsonDarkPrimary,
    onPrimary = Color(0xFF690005),
    primaryContainer = CrimsonDarkContainer,
    onPrimaryContainer = OnCrimsonDarkContainer,
    secondary = OxfordDarkSecondary,
    onSecondary = Color(0xFF00315F),
    secondaryContainer = OxfordDarkContainer,
    onSecondaryContainer = OnOxfordDarkContainer,
    tertiary = AmberDarkTertiary,
    onTertiary = Color(0xFF421D00),
    tertiaryContainer = AmberDarkContainer,
    onTertiaryContainer = OnAmberDarkContainer,
    background = CharcoalBackground,
    onBackground = ChalkText,
    surface = CharcoalSurface,
    onSurface = ChalkText,
    surfaceVariant = CharcoalSurfaceVariant,
    onSurfaceVariant = ChalkTextMuted,
    outline = CharcoalOutline,
    outlineVariant = CharcoalOutline.copy(alpha = 0.6f),
    error = GrammarErrorDark,
    onError = Color(0xFF690005),
    errorContainer = GrammarErrorBgDark,
    onErrorContainer = Color(0xFFFFDAD6)
)

val AppShapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(22.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

@Composable
fun MurphyGrammarTheme(
    themePreference: ThemePreference = ThemePreference.SYSTEM,
    content: @Composable () -> Unit
) {
    val darkTheme = when (themePreference) {
        ThemePreference.SYSTEM -> isSystemInDarkTheme()
        ThemePreference.LIGHT -> false
        ThemePreference.DARK -> true
    }

    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            if (window != null) {
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
