package org.ic.life.main

import android.app.Application
import org.ic.life.main.di.initKoin
import org.ic.life.main.di.viewModelModule
import org.koin.android.ext.koin.androidContext

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MainApplication)
            modules(viewModelModule)
        }
    }
}