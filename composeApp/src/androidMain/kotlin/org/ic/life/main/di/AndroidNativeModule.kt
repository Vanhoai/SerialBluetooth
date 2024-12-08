package org.ic.life.main.di

import org.ic.life.main.core.handlers.BluetoothHandler
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ic.life.main.core.handlers.AndroidBluetoothHandler
import org.koin.dsl.bind

/**
 * Declare platform module in native platform (IOS, MacOS)
 *
 * In this module, we can declare platform specific implementation such as:
 * 1. Bluetooth Handler (for handling with bluetooth)
 *
 * @see BluetoothHandler
 */
val androidNativeModule = module {
    singleOf(::AndroidBluetoothHandler).bind(BluetoothHandler::class)
}