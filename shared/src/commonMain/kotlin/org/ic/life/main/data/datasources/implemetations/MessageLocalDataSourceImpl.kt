package org.ic.life.main.data.datasources.implemetations

import org.ic.life.main.data.database.AppDatabase
import org.ic.life.main.data.database.message.MessageEntity
import org.ic.life.main.data.datasources.MessageLocalDataSource

class MessageLocalDataSourceImpl  (
    private val appDatabase: AppDatabase
): MessageLocalDataSource {
    private val messageDao = appDatabase.messageDao()

    override suspend fun addMessage(messageEntity: MessageEntity): Boolean {
        val response = messageDao.insert(messageEntity)
        return response > 0L
    }

    override suspend fun removeMessage(messageEntity: MessageEntity): Boolean {
        val response = messageDao.delete(messageEntity)
        return response > 0
    }
}