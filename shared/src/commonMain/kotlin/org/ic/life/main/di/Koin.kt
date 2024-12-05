package org.ic.life.main.di

import org.ic.life.main.data.database.AppDatabase
import org.ic.life.main.data.repositories.ICRepositoryImpl
import org.ic.life.main.data.repositories.MessageRepositoryImpl
import org.ic.life.main.domain.repositories.ICRepository
import org.ic.life.main.domain.repositories.MessageRepository
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

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

val repositoryModule = module {
    single<MessageRepository> {
        val appDatabase = get<AppDatabase>()
        MessageRepositoryImpl(appDatabase.messageDao())
    }

    single<ICRepository> {
        val appDatabase = get<AppDatabase>()
        ICRepositoryImpl(appDatabase.icDao())
    }
}
