package org.ic.life.main


import androidx.compose.runtime.*
import org.ic.life.main.core.design.SerialBluetoothAppTheme
import org.ic.life.main.presentation.common.graphs.NavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun SerialBluetoothApp() {
    SerialBluetoothAppTheme {
        NavGraph()
    }
}