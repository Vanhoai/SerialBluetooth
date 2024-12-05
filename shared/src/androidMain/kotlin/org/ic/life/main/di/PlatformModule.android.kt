package org.ic.life.main.di

import androidx.room.Room
import org.ic.life.main.data.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

actual fun platformModule(): Module = module {
    single<AppDatabase> {
        val dbFile = androidContext().getDatabasePath("app.db")
        Room.databaseBuilder<AppDatabase>(
            context = androidContext(),
            name = dbFile.absolutePath
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}