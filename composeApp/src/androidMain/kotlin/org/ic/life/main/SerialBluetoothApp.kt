package org.ic.life.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.ic.life.main.core.design.SerialBluetoothAppTheme
import org.ic.life.main.data.database.message.MessageEntity
import org.ic.life.main.features.MainViewModel
import org.ic.life.main.presentation.widgets.AppScaffold
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
@Composable
@Preview
fun SerialBluetoothApp() {
    SerialBluetoothAppTheme {

        val viewModel = koinViewModel<MainViewModel>()
        val mainUiState by viewModel.uiState.collectAsStateWithLifecycle()

        LaunchedEffect(mainUiState.messages) {
            Log.d("MainActivity", "Messages: ${mainUiState.messages}")
        }

        AppScaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    val newMessage = MessageEntity(
                        uuid = Uuid.random(),
                        message = "Hello, World!",
                        author = Uuid.random(),
                        channel = Uuid.random(),
                    )

                    viewModel.addMessage(newMessage)
                }) {
                    Text(
                        "Send Message To IC",
                        color = Color.White,
                    )
                }

                Button(onClick = {
                    val topMessage = mainUiState.messages.firstOrNull()
                    if (topMessage != null) {
                        viewModel.removeMessage(topMessage)
                    }
                }) {
                    Text(
                        "Remove Top Message From IC",
                        color = Color.White,
                    )
                }
            }
        }
    }
}