package org.ic.life.main.core.design

import androidx.annotation.RequiresPermission
import androidx.compose.material.Colors
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val serialBluetoothColorPalette = SerialBluetoothColors(
    uiBackgroundPrimary = white,
    textPrimary = black
)

@Composable
fun SerialBluetoothAppTheme(
    content: @Composable () -> Unit
) {
    val colors = serialBluetoothColorPalette

    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)

//    CompositionLocalProvider(
//        LocalSpacing provides Spacing,
//        LocalColors provides colorPalette,
//        LocalTypography provides Typography
//    ) {
//        MaterialTheme(
//            typography = debugTypography(),
//            shapes = Shapes,
//            colors = debugColors(true),
//            content = content
//        )
//    }

    MaterialTheme(
        typography = MaterialTheme.typography.copy(),
        shapes = Shapes,
        colors = MaterialTheme.colors.copy(),
        content = content
    )
}

object AppTheme {
    val colors: SerialBluetoothColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val spacing: MoviesSpacing
        @Composable
        @RequiresPermission.Read
        get() = LocalSpacing.current

    val typography: MoviesTypography
        @Composable
        @RequiresPermission.Read
        get() = LocalTypography.current
}

@Stable
class SerialBluetoothColors(
    uiBackgroundPrimary: Color,
    textPrimary: Color,
) {
    var uiBackgroundPrimary by mutableStateOf(uiBackgroundPrimary)
        private set

    var textPrimary by mutableStateOf(textPrimary)
        private set

    fun update(other: SerialBluetoothColors) {
        uiBackgroundPrimary = other.uiBackgroundPrimary
        textPrimary = other.textPrimary
    }

    fun copy(): SerialBluetoothColors = SerialBluetoothColors(
        uiBackgroundPrimary = uiBackgroundPrimary,
        textPrimary = textPrimary,
    )
}

val LocalColors = staticCompositionLocalOf<SerialBluetoothColors> {
    error("No MoviesColorPalette provided")
}

/**
 * A Material [Colors] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colors] in preference to [SerialBluetoothAppTheme.colors].
 */
fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)

fun debugTypography() = Typography(
    h1 = TextStyle(fontSize = 0.sp),
    h2 = TextStyle(fontSize = 0.sp),
    h3 = TextStyle(fontSize = 0.sp),
    h4 = TextStyle(fontSize = 0.sp),
    h5 = TextStyle(fontSize = 0.sp),
    h6 = TextStyle(fontSize = 0.sp),
    subtitle1 = TextStyle(fontSize = 0.sp),
    subtitle2 = TextStyle(fontSize = 0.sp),
    body1 = TextStyle(fontSize = 0.sp),
    body2 = TextStyle(fontSize = 0.sp),
    button = TextStyle(fontSize = 0.sp),
    // This is changed since BottomNavigationItem has hardcoded the style for
    // `label` to be `MaterialTheme.typography.caption` setting this 0.dp will make it invisible to the user
    caption = TextStyle(fontSize = 10.sp),
    overline = TextStyle(fontSize = 0.sp)
)


/**
 * This function tries to match the provided [backgroundColor] to a 'background' color in this
 * [SerialBluetoothColors], and then will return the corresponding color used for content. For example, when
 * [backgroundColor] is [SerialBluetoothColors.uiBackgroundPrimary], this will return [SerialBluetoothColors.textPrimary].
 *
 * @return the matching content color for [backgroundColor]. If [backgroundColor] is not present in
 * the theme's [Colors], then returns [Color.Unspecified].
 *
 * @see contentColorFor
 */
fun SerialBluetoothColors.contentColorFor(backgroundColor: Color): Color {
    return when (backgroundColor) {
        uiBackgroundPrimary -> textPrimary
        else -> Color.Unspecified
    }
}

/**
 * This function tries to match the provided [backgroundColor] to a 'background' color in this
 * [SerialBluetoothColors], and then will return the corresponding color used for content. For example, when
 * [backgroundColor] is [SerialBluetoothColors.uiBackgroundPrimary], this will return [SerialBluetoothColors.textPrimary].
 *
 * @return the matching content color for [backgroundColor]. If [backgroundColor] is not present in
 * the theme's [Colors], then returns the current value of [LocalContentColor] as a best-effort color.
 *
 * @see SerialBluetoothColors.contentColorFor
 */

@Composable
@ReadOnlyComposable
fun contentColorFor(backgroundColor: Color) =
    AppTheme.colors.contentColorFor(backgroundColor)
        .takeOrElse { LocalContentColor.current }
