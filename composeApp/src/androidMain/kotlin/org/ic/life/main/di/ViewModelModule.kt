package org.ic.life.main.di


import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.ic.life.main.presentation.views.swipe.SwipeViewModel

/**
 * Declare view model module
 *
 * In this module, we can declare view model such as:
 * 1. SwipeViewModel (view model for swipe view screen - bottom navigation)
 *
 * @see SwipeViewModel
 */
val viewModelModule = module {
    viewModelOf(::SwipeViewModel)
}