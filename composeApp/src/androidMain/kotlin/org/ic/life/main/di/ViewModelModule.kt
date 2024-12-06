package org.ic.life.main.di

import org.ic.life.main.core.AndroidDatabase
import org.ic.life.main.data.database.AppDatabase
import org.ic.life.main.features.EncryptionViewModel
import org.ic.life.main.features.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<MainViewModel> { MainViewModel() }
    viewModel<EncryptionViewModel> { EncryptionViewModel() }
}