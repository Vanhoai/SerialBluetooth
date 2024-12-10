package org.ic.life.main.presentation.common.graphs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import org.ic.life.main.presentation.views.swipe.devices.DevicesView
import org.ic.life.main.presentation.views.swipe.settings.SettingsView
import org.ic.life.main.presentation.views.swipe.terminal.TerminalView

@Composable
fun SwipeBottomBar(
    tab: SwipeRoute,
    setTab: (SwipeRoute) -> Unit
) {
    BottomNavigation {
        val bottomNavItems = listOf(
            BottomNavItem.Terminal,
            BottomNavItem.Devices,
            BottomNavItem.Settings
        )

        bottomNavItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(item.label) },
                selected = tab == item.route,
                onClick = { setTab(item.route) },
            )
        }
    }
}

@Composable
fun SwipeContent(
    tab: SwipeRoute,
    innerPadding: PaddingValues
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        when (tab) {
            SwipeRoute.TERMINAL -> TerminalView()
            SwipeRoute.DEVICES -> DevicesView()
            SwipeRoute.SETTINGS -> SettingsView()
        }
    }
}