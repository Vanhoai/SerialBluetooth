package org.ic.life.main


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController

import org.ic.life.main.core.design.SerialBluetoothAppTheme
import org.ic.life.main.presentation.common.graphs.NavGraph
import org.ic.life.main.presentation.widgets.DrawerNavigation
import org.ic.life.main.presentation.widgets.DrawerNavigationState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun SerialBluetoothApp() {

    SerialBluetoothAppTheme {
        val navHostController = rememberNavController()
        val drawerNavigationState = remember { mutableStateOf(DrawerNavigationState.CLOSE) }

        DrawerNavigation(
            drawerNavigationState = drawerNavigationState,
            modifier = Modifier.fillMaxSize(),
        ) {
            NavGraph(
                navHostController,
                onOpenDrawer = {
                    drawerNavigationState.value = DrawerNavigationState.OPEN
                }
            )
        }
    }
}