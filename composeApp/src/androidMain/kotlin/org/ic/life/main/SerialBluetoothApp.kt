package org.ic.life.main


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.ic.life.main.core.design.SerialBluetoothAppTheme
import org.ic.life.main.presentation.common.graphs.NavGraph
import org.ic.life.main.presentation.common.graphs.NavRoute
import org.ic.life.main.presentation.views.started.StartedView
import org.ic.life.main.presentation.views.swipe.SwipeView
import org.ic.life.main.presentation.widgets.AssistiveTouch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun SerialBluetoothApp() {
    SerialBluetoothAppTheme {
        NavGraph()
    }
}