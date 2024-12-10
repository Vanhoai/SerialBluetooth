package org.ic.life.main.core.serials

import android.Manifest
import android.app.Activity
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.ic.life.main.core.constants.Constants
import java.io.IOException
import java.security.InvalidParameterException
import java.util.UUID
import java.util.concurrent.Executors

class SerialSocket(
    private val context: Context,
    private val bluetoothDevice: BluetoothDevice,
) : Runnable {
    private var disconnectBroadcastReceiver: BroadcastReceiver? = null
    private var listener: SerialListener? = null
    private var socket: BluetoothSocket? = null
    private var connected: Boolean = false

    init {
        if (context is Activity) throw InvalidParameterException("Expected non UI Context")
        this.disconnectBroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                listener?.onSerialIoError(IOException("Background disconnect"))
                disconnect()
            }
        }
    }

    companion object {
        private val BLUETOOTH_SPP = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    }

    @Throws
    fun connect(listener: SerialListener) {
        this.listener = listener
        ContextCompat.registerReceiver(
            context,
            disconnectBroadcastReceiver,
            IntentFilter(Constants.INTENT_ACTION_DISCONNECT),
            ContextCompat.RECEIVER_NOT_EXPORTED
        )
        Executors.newSingleThreadExecutor().submit(this)
    }

    @Throws
    fun disconnect() {
        listener = null
        if (socket == null) return
        socket?.close()
        socket = null

        context.unregisterReceiver(disconnectBroadcastReceiver);
    }

    @Throws(IOException::class)
    fun write(data: ByteArray) {
        if (!connected) throw IOException("Not connected")
        socket?.outputStream?.write(data)
    }

    @Throws(Exception::class)
    override fun run() {
        try {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) != PackageManager.PERMISSION_GRANTED
            ) throw Exception("Bluetooth permission not granted")
            socket = bluetoothDevice.createRfcommSocketToServiceRecord(BLUETOOTH_SPP)
            socket?.connect()

            if (listener != null) listener?.onSerialConnect()
        } catch (exception: Exception) {
            if (listener != null) listener?.onSerialConnectError(exception)
            socket?.close()
            socket = null
            return
        }

        connected = true
        try {
            val buffer = ByteArray(1024)
            var len: Int
            while (true) {
                len = socket!!.inputStream.read(buffer)
                val data = buffer.copyOf(len)
                if (listener != null) listener?.onSerialRead(data)
            }
        } catch (exception: Exception) {
            connected = false
            if (listener != null) listener?.onSerialIoError(exception)
            socket?.close()
            socket = null
        }
    }
}