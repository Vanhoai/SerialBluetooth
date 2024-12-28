package org.ic.life.main.presentation.common.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import org.ic.life.main.presentation.views.started.StartedView
import org.ic.life.main.presentation.views.swipe.SwipeView

@Composable
fun NavGraph(
    navHostController: NavHostController,
    onOpenDrawer: () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = NavRoute.STARTED.path,
    ) {
        composable(NavRoute.STARTED.path) {
            StartedView(navHostController, onOpenDrawer)
        }

        composable(NavRoute.SWIPE.path) {
            SwipeView(navHostController)
        }
    }
}
