package org.ic.life.main.di

import org.ic.life.main.data.datasources.ICLocalDataSource
import org.ic.life.main.data.datasources.implemetations.ICLocalDataSourceImpl
import org.ic.life.main.data.datasources.MessageLocalDataSource
import org.ic.life.main.data.datasources.implemetations.MessageLocalDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModule = module {
    singleOf(::ICLocalDataSourceImpl).bind(ICLocalDataSource::class)
    singleOf(::MessageLocalDataSourceImpl).bind(MessageLocalDataSource::class)
}