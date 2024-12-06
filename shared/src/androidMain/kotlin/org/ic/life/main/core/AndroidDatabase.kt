package org.ic.life.main.core

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import org.ic.life.main.core.configs.AppConfig
import org.ic.life.main.data.database.AppDatabase

class AndroidDatabase {
    companion object {
        fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<AppDatabase> {
            val appContext = ctx.applicationContext
            val dbFile = appContext.getDatabasePath(AppConfig.DATABASE_FILE_NAME)
            return Room.databaseBuilder<AppDatabase>(
                context = appContext,
                name = dbFile.absolutePath
            )
        }

        fun getDatabase(ctx: Context): AppDatabase {
            val dbFile = ctx.getDatabasePath(AppConfig.DATABASE_FILE_NAME)
            return Room.databaseBuilder<AppDatabase>(
                context = ctx,
                name = dbFile.absolutePath
            )
                .setDriver(BundledSQLiteDriver())
                .setQueryCoroutineContext(Dispatchers.IO)
                .build()
        }
    }
}