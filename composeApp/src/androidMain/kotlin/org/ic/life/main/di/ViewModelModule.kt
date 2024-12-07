package org.ic.life.main.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.ic.life.main.presentation.views.swipe.SwipeViewModel

val viewModelModule = module {
    viewModelOf(::SwipeViewModel)
}