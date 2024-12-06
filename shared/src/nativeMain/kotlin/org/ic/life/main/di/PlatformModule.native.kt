package org.ic.life.main.di

import org.ic.life.main.core.NativeDatabase
import org.ic.life.main.data.database.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Declare platform module in native platform (IOS, MacOS)
 *
 * In this module, we can declare platform specific implementation such as:
 * 1. Database (for caching data or save data locally)
 * 2. Network (for fetching data from remote server)
 *
 * Note: In native platform, we can't use context for init database but need some native api
 *   to get document directory. So we need to declare this module, and declare platform
 *   specific implementation in platform module.
 *
 * @see org.ic.life.main.core.NativeDatabase
 * @see org.ic.life.main.data.database.AppDatabase
 */
actual fun platformModule(): Module = module {
    single<AppDatabase> { NativeDatabase.getDatabase() }
}