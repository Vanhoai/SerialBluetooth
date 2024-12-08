package org.ic.life.main

import android.app.Application
import org.ic.life.main.di.androidNativeModule
import org.ic.life.main.di.initKoin
import org.ic.life.main.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(androidNativeModule, viewModelModule)
        }
    }
}