package org.ic.life.main.core.base

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import kotlinx.coroutines.cancel
import org.koin.core.component.KoinComponent

abstract class BaseViewModel : KMMViewModel(), KoinComponent {
    override fun onCleared() {
        viewModelScope.coroutineScope.cancel()
        super.onCleared()
    }
}