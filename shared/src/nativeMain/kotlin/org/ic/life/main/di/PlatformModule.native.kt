package org.ic.life.main.di

import androidx.room.Room
import kotlinx.cinterop.ExperimentalForeignApi
import org.ic.life.main.data.database.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}

actual fun platformModule(): Module = module {
    single<AppDatabase> {
        val dbFile = documentDirectory() + "/app.db"
        Room.databaseBuilder<AppDatabase>(
            name = dbFile,
        ).build()
    }
}