package org.ic.life.main.presentation.views.swipe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.ic.life.main.presentation.widgets.AppScaffold
import org.koin.androidx.compose.koinViewModel

@Composable
fun SwipeView() {
    val viewModel: SwipeViewModel = koinViewModel<SwipeViewModel>()
    val mainUiState: State<SwipeUiState> = viewModel.uiState.collectAsState()

    AppScaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Button(onClick = {}) {
                Text("Swipe View")
            }
        }
    }
}