package org.ic.life.main.core.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import org.ic.life.main.core.serials.SerialListener
import org.ic.life.main.core.serials.SerialSocket

class AndroidSerialService : Service(), SerialListener {

    class SerialBinder : Binder() {
        fun getService() = AndroidSerialService()
    }

    class QueueItem(
        private val type: QueueType,
        private var datas: ArrayDeque<ByteArray>? = null,
        private var exception: Exception? = null
    ) {

        init {
            if (type == QueueType.Read) initQueue()
        }

        private fun initQueue() {
            this.datas = ArrayDeque()
        }
    }

    enum class QueueType { Connect, ConnectError, Read, IoError }

    private val binder: IBinder? = null
    private val mainLooper: Handler? = null
    private val queue1 = ArrayDeque<QueueItem>()
    private val queue2 = ArrayDeque<QueueItem>()
    private val lastRead = QueueItem(QueueType.Read)

    private val listener: SerialListener? = null
    private var socket: SerialSocket? = null
    private var connected: Boolean = false

    override fun onBind(intent: Intent?): IBinder? = binder

    override fun onSerialConnect() {
        TODO("Not yet implemented")
    }

    override fun onSerialConnectError(exception: Exception) {
        TODO("Not yet implemented")
    }

    override fun onSerialRead(data: ByteArray) {
        TODO("Not yet implemented")
    }

    override fun onSerialRead(data: ArrayDeque<ByteArray>) {
        TODO("Not yet implemented")
    }

    override fun onSerialIoError(exception: Exception) {
        TODO("Not yet implemented")
    }

    private fun disconnect() {
        connected = false
        if (socket == null) return
        socket?.disconnect()
        socket = null
    }

    override fun onDestroy() {
        disconnect()
        super.onDestroy()
    }
}