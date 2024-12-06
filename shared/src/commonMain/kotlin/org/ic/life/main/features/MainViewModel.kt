package org.ic.life.main.features

import com.rickclephas.kmm.viewmodel.KMMViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.ic.life.main.core.base.BaseViewModel
import org.ic.life.main.data.database.message.MessageEntity
import org.ic.life.main.domain.usecases.AddMessageUseCase
import org.ic.life.main.domain.usecases.RemoveMessageUseCase
import org.koin.core.component.inject
import com.rickclephas.kmm.viewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

open class MainViewModel : KMMViewModel(), KoinComponent {
    private val removeMessageUseCase: RemoveMessageUseCase by inject<RemoveMessageUseCase>()
    private val addMessageUseCase: AddMessageUseCase by inject<AddMessageUseCase>()

    private val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState())

    @NativeCoroutinesState
    val uiState: StateFlow<MainUiState> = _uiState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        MainUiState()
    )

    fun addMessage(messageEntity: MessageEntity) {
        viewModelScope.coroutineScope.launch {
            val response = addMessageUseCase(messageEntity)
            if (response) {
                _uiState.update { it.copy(messages = it.messages + messageEntity) }
            }
        }
    }

    fun removeMessage(messageEntity: MessageEntity) {
        viewModelScope.coroutineScope.launch {
            val response = removeMessageUseCase(messageEntity)
            if (response) {
                _uiState.update { it.copy(messages = it.messages - messageEntity) }
            }
        }
    }

    override fun onCleared() {
        viewModelScope.coroutineScope.cancel()
        super.onCleared()
    }
}