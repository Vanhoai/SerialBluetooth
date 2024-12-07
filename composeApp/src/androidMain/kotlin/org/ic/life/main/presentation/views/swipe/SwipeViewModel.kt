package org.ic.life.main.presentation.views.swipe

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ic.life.main.core.base.BaseViewModel
import org.ic.life.main.data.database.message.MessageEntity
import org.ic.life.main.domain.usecases.AddMessageUseCase
import org.ic.life.main.domain.usecases.RemoveMessageUseCase
import org.koin.core.component.inject

open class SwipeViewModel : BaseViewModel() {
    private val removeMessageUseCase: RemoveMessageUseCase by inject<RemoveMessageUseCase>()
    private val addMessageUseCase: AddMessageUseCase by inject<AddMessageUseCase>()

    private val _uiState: MutableStateFlow<SwipeUiState> = MutableStateFlow(SwipeUiState())
    val uiState: StateFlow<SwipeUiState> = _uiState.asStateFlow()

    fun addMessage(message: MessageEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = addMessageUseCase(message)
            if (response) {
                _uiState.update { it.copy(messages = it.messages + message) }
            }
        }
    }

    fun removeMessage(message: MessageEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = removeMessageUseCase(message)
            if (response) {
                _uiState.update { it.copy(messages = it.messages - message) }
            }
        }
    }
}