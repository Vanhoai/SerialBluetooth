package org.ic.life.main.data.repositories

import org.ic.life.main.data.database.message.MessageDao
import org.ic.life.main.domain.repositories.MessageRepository

class MessageRepositoryImpl(
    private val messageDao: MessageDao
) : MessageRepository {}