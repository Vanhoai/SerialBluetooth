package org.ic.life.main.di

import org.ic.life.main.domain.usecases.AddMessageUseCase
import org.ic.life.main.domain.usecases.ICAuthUseCase
import org.ic.life.main.domain.usecases.RemoveMessageUseCase
import org.ic.life.main.domain.usecases.SendMessageUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Declare use case module
 *
 * In this module, we can declare use case such as:
 * 1. SendMessageUseCase (use case for sending message)
 * 2. AddMessageUseCase (use case for adding message)
 * 3. RemoveMessageUseCase (use case for removing message)
 * 4. ICAuthUseCase (use case for authenticating IC)
 *
 * @see SendMessageUseCase
 * @see AddMessageUseCase
 * @see RemoveMessageUseCase
 * @see ICAuthUseCase
 */
val useCaseModule = module {
    singleOf(::SendMessageUseCase)
    singleOf(::AddMessageUseCase)
    singleOf(::RemoveMessageUseCase)
    singleOf(::ICAuthUseCase)
}