package org.ic.life.main.domain.usecases

import org.ic.life.main.core.base.BaseUseCase
import org.ic.life.main.data.database.message.MessageEntity
import org.ic.life.main.domain.repositories.MessageRepository

class RemoveMessageUseCase(
    private val messageRepository: MessageRepository
) : BaseUseCase<MessageEntity, Boolean> {

    override suspend operator fun invoke(params: MessageEntity): Boolean {
        return messageRepository.removeMessage(params)
    }
}