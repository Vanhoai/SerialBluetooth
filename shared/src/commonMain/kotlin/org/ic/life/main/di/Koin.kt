package org.ic.life.main.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(declaration: KoinAppDeclaration = {}) =
    startKoin {
        declaration()

        modules(
            httpClientModule,
            networkServiceModule,
            daoModule,
            localServiceModule,
            repoModule,
            useCaseModule,
            platformModule()
        )
    }

fun initKoin() = initKoin {}