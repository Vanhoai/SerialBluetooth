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
 * Platform module is a special module, it will be called in [org.ic.life.main.Platform.name]
 */
fun initKoin(declaration: KoinAppDeclaration = {}) {
    startKoin {
        declaration()
        modules(
            platformModule(),
            repositoryModule
        )
    }
}
