package org.ic.life.main.core

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.cinterop.ExperimentalForeignApi
import org.ic.life.main.core.configs.AppConfig
import org.ic.life.main.data.database.AppDatabase
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

class NativeDatabase {
    companion object {
        fun getDatabase(): AppDatabase {
            val dbFilePath = documentDirectory() + "/${AppConfig.DATABASE_FILE_NAME}"
            return Room.databaseBuilder<AppDatabase>(
                name = dbFilePath,
            )
                .addMigrations()
                .setDriver(BundledSQLiteDriver())
                .build()
        }

        fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
            val dbFilePath = documentDirectory() + "/${AppConfig.DATABASE_FILE_NAME}"
            return Room.databaseBuilder<AppDatabase>(
                name = dbFilePath,
            )
        }

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
    }
}