package org.ic.life.main.features

import org.ic.life.main.data.database.message.MessageEntity

data class MainUiState(
    val messages: List<MessageEntity> = emptyList(),
    val isLoading: Boolean = false
)