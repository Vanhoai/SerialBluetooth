package org.ic.life.main.data.repositories

import org.ic.life.main.data.database.message.MessageEntity
import org.ic.life.main.data.datasources.MessageLocalDataSource
import org.ic.life.main.domain.repositories.MessageRepository

class MessageRepositoryImpl(
    private val messageLocalDataSource: MessageLocalDataSource
) : MessageRepository {

    override suspend fun addMessage(messageEntity: MessageEntity): Boolean {
        return messageLocalDataSource.addMessage(messageEntity)
    }

    override suspend fun removeMessage(messageEntity: MessageEntity): Boolean {
        return messageLocalDataSource.removeMessage(messageEntity)
    }
}