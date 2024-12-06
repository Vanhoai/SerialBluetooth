package org.ic.life.main.data.repositories

import org.ic.life.main.data.database.message.MessageDao
import org.ic.life.main.data.database.message.MessageEntity
import org.ic.life.main.domain.repositories.MessageRepository

class MessageRepositoryImpl(
    private val messageDao: MessageDao
) : MessageRepository {

    override suspend fun addMessage(messageEntity: MessageEntity): Boolean {
        val response = messageDao.insert(messageEntity)
        return response > 0L
    }

    override suspend fun removeMessage(messageEntity: MessageEntity): Boolean {
        val response = messageDao.delete(messageEntity)
        return response > 0
    }
}