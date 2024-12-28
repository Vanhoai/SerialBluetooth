package org.ic.life.main.presentation.widgets

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

enum class DrawerNavigationState {
    OPEN,
    CLOSE
}

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun DrawerNavigation(
    drawerNavigationState: MutableState<DrawerNavigationState>,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val localConfiguration = LocalConfiguration.current
    val widthScreen = localConfiguration.screenWidthDp.dp.value
    val heightScreen = localConfiguration.screenHeightDp.dp.value

    Log.d("DrawerNavigation", "widthScreen: $widthScreen")
    Log.d("DrawerNavigation", "heightScreen: $heightScreen")

    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .width(widthScreen.dp)
                .graphicsLayer {}
        ) {
            content()
        }
    }
}