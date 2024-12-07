package org.ic.life.main.di

import org.ic.life.main.domain.repositories.MessageRepository
import org.ic.life.main.domain.usecases.AddMessageUseCase
import org.ic.life.main.domain.usecases.ICAuthUseCase
import org.ic.life.main.domain.usecases.RemoveMessageUseCase
import org.ic.life.main.domain.usecases.SendMessageUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::SendMessageUseCase)
    singleOf(::AddMessageUseCase)
    singleOf(::RemoveMessageUseCase)
    singleOf(::ICAuthUseCase)
}