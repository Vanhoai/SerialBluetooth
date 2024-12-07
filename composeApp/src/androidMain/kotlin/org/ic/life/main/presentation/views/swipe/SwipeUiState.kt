package org.ic.life.main.presentation.views.swipe

import org.ic.life.main.data.database.message.MessageEntity

data class SwipeUiState(
    val messages: List<MessageEntity> = emptyList(),
    val isLoading: Boolean = false
)