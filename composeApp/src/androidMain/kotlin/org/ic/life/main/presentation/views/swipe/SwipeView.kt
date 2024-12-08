package org.ic.life.main.presentation.views.swipe

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.ic.life.main.presentation.common.graphs.SwipeBottomBar
import org.ic.life.main.presentation.common.graphs.SwipeContent
import org.ic.life.main.presentation.common.graphs.SwipeRoute
import org.ic.life.main.presentation.widgets.AppScaffold
import org.koin.androidx.compose.koinViewModel

@Composable
fun SwipeView(navHostController: NavController) {
    val (currentTab, setCurrentTab) = rememberSaveable {
        mutableStateOf(SwipeRoute.TERMINAL)
    }

    val viewModel: SwipeViewModel = koinViewModel<SwipeViewModel>()
    val mainUiState: State<SwipeUiState> = viewModel.uiState.collectAsState()

    Crossfade(currentTab, label = "SwipeView") { tab ->
        AppScaffold(
            modifier = Modifier
                .safeDrawingPadding()
                .fillMaxSize(),
            bottomBar = {
                SwipeBottomBar(tab, setCurrentTab)
            },
            content = { innerPadding ->
                SwipeContent(tab, innerPadding)
            }
        )
    }
}