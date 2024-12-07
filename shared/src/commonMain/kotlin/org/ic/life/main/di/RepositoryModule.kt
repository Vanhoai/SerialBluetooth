package org.ic.life.main.di

import org.ic.life.main.data.database.AppDatabase
import org.ic.life.main.data.repositories.ICRepositoryImpl
import org.ic.life.main.data.repositories.MessageRepositoryImpl
import org.ic.life.main.domain.repositories.ICRepository
import org.ic.life.main.domain.repositories.MessageRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Declare repository module
 *
 * This module will be registered to koin di container. In repository layer, we can declare
 * some repository use data layer such as:
 * 1. Database (for caching data or save data locally, database module will register in platform module)
 * 2. Network (for fetching data from remote server)
 *
 * @see AppDatabase
 * @see ICRepositoryImpl
 * @see MessageRepositoryImpl
 */
val repositoryModule = module {
    singleOf(::MessageRepositoryImpl).bind(MessageRepository::class)
    singleOf(::ICRepositoryImpl).bind(ICRepository::class)
}