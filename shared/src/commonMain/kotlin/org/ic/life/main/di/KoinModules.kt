package org.ic.life.main.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

/**
 * Initialize Koin DI
 * @param declaration extra declaration
 * @see startKoin
 *
 * This function will be called in [org.ic.life.main.MainApplication.onCreate]
 * At here, we can declare some shared module, and declare platform module
 */
fun initKoin(declaration: KoinAppDeclaration = {}) {
    startKoin {
        declaration()
        modules(
            dataSourceModule,
            repositoryModule,
            useCaseModule,
            platformModule()
        )
    }
}

/**
 * Initialize Koin DI for ios platform
 *
 *
 * This function will called for init koin in ios platform. When this function called, it will
 * call [initKoin] function with platform module
 */
fun initKoin() = initKoin {}

