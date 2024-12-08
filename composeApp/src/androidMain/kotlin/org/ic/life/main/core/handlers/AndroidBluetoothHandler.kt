package org.ic.life.main.core.handlers

import android.app.Application
import android.bluetooth.BluetoothManager
import android.content.Context

/**
 * Bluetooth Handler
 *
 * This class will handle with bluetooth in android platform
 */
class AndroidBluetoothHandler(private val context: Context) : BluetoothHandler {

    private var bluetoothManager: BluetoothManager? = null
    private var isBluetoothAvailable = false
    private var isBluetoothEnabled = false

    init {
        val service = context.getSystemService(Application.BLUETOOTH_SERVICE)
        bluetoothManager = service as BluetoothManager

        isBluetoothAvailable = bluetoothManager?.adapter != null
        isBluetoothEnabled = bluetoothManager?.adapter?.isEnabled ?: false
    }

    override fun isBluetoothAvailable(): Boolean {
        return isBluetoothAvailable
    }

    override fun isBluetoothEnabled(): Boolean {
        return isBluetoothEnabled
    }
}