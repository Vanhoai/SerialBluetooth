package org.ic.life.main.data.datasources

import org.ic.life.main.data.database.message.MessageEntity

interface MessageLocalDataSource {
    suspend fun addMessage(messageEntity: MessageEntity): Boolean
    suspend fun removeMessage(messageEntity: MessageEntity): Boolean
}