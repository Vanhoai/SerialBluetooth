package org.ic.life.main.presentation.views.started

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.ic.life.main.presentation.widgets.AppScaffold

@Composable
fun StartedView() {
    AppScaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Button(onClick = {}) {
                Text("Started View")
            }
        }
    }
}