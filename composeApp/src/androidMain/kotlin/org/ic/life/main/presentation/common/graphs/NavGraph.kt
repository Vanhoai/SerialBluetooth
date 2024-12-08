package org.ic.life.main.presentation.common.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import org.ic.life.main.presentation.views.started.StartedView
import org.ic.life.main.presentation.views.swipe.SwipeView

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.STARTED.path,
    ) {
        composable(NavRoute.STARTED.path) {
            StartedView(navController)
        }

        composable(NavRoute.SWIPE.path) {
            SwipeView(navController)
        }
    }
}
