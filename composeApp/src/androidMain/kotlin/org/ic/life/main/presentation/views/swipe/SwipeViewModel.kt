package org.ic.life.main.presentation.views.swipe

import android.util.Log
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.ic.life.main.core.base.BaseViewModel
import org.ic.life.main.core.handlers.BluetoothHandler
import org.koin.core.component.inject

open class SwipeViewModel : BaseViewModel() {
    // State view model
    private val _uiState: MutableStateFlow<SwipeUiState> = MutableStateFlow(SwipeUiState())
    val uiState: StateFlow<SwipeUiState> = _uiState.asStateFlow()

    // Handler
    val bluetoothHandler: BluetoothHandler by inject<BluetoothHandler>()

    /**
     * Check bluetooth availability
     *
     * This function will check bluetooth availability in android platform and show message
     * to user if bluetooth is not available
     *
     * @see BluetoothHandler
     */
    fun checkBluetooth(snackBarHostState: SnackbarHostState) {
        viewModelScope.launch(Dispatchers.IO) {
            // val isBluetoothAvailable = bluetoothHandler.isBluetoothAvailable()
            // if (isBluetoothAvailable) return@launch

            snackBarHostState.showSnackbar(
                message = "Bluetooth is not available",
                duration = SnackbarDuration.Short,
            )
        }
    }

    companion object {
        private val TAG = SwipeViewModel::class.java.simpleName
    }
}