package org.ic.life.main.core

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.ic.life.main.core.configs.AppConfig
import org.ic.life.main.data.database.AppDatabase

class AndroidDatabase {
    companion object {
        fun getDatabase(ctx: Context): AppDatabase {
            val dbFile = ctx.getDatabasePath(AppConfig.DATABASE_FILE_NAME)
            return Room.databaseBuilder<AppDatabase>(
                context = ctx,
                name = dbFile.absolutePath
            )
                .addMigrations()
                .allowMainThreadQueries()
                .setDriver(BundledSQLiteDriver())
                .build()
        }
    }
}