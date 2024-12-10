package org.ic.life.main.core.serials

import java.lang.Exception

interface SerialListener {
    fun onSerialConnect()
    fun onSerialConnectError(exception: Exception)
    fun onSerialRead(data: ByteArray)
    fun onSerialRead(data: ArrayDeque<ByteArray>)
    fun onSerialIoError(exception: Exception)
}