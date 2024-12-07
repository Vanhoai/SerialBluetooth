package org.ic.life.main.di

import androidx.room.RoomDatabase
import org.ic.life.main.data.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import org.ic.life.main.core.AndroidDatabase

/**
 * Declare platform module
 *
 * In this module, we can declare platform specific implementation such as:
 * 1. Database (for caching data or save data locally)
 * 2. Network (for fetching data from remote server)
 *
 * Note: We can't declare platform specific implementation in common module, because we can't get
 *   Context in common module. So we need to declare this module, and declare platform
 *   specific implementation in platform module.
 *
 * @see org.ic.life.main.core.AndroidDatabase
 * @see org.ic.life.main.data.database.AppDatabase
 */
actual fun platformModule(): Module = module {
    single<AppDatabase> {
        val builder = AndroidDatabase.getDatabaseBuilder(get())
        AppDatabase.buildRoomDatabase(builder)
    }
}