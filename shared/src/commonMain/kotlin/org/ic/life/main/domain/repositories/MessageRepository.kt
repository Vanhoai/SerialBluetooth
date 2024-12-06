package org.ic.life.main.domain.repositories

import org.ic.life.main.data.database.message.MessageEntity

interface MessageRepository {
    suspend fun addMessage(messageEntity: MessageEntity): Boolean
    suspend fun removeMessage(messageEntity: MessageEntity): Boolean
}