package org.ic.life.main.core.handlers

interface BluetoothHandler {
    fun isBluetoothAvailable(): Boolean
    fun isBluetoothEnabled(): Boolean
}