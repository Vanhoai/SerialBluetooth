package org.ic.life.main.presentation.common.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: SwipeRoute,
    val icon: ImageVector,
    val label: String
) {
    data object Terminal : BottomNavItem(SwipeRoute.TERMINAL, Icons.Default.Build, "Terminal")
    data object Devices : BottomNavItem(SwipeRoute.DEVICES, Icons.Default.Build, "Devices")
    data object Settings : BottomNavItem(SwipeRoute.SETTINGS, Icons.Default.Build, "Setting")
}
