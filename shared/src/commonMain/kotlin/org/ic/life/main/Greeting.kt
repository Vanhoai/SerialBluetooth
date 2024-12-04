package org.ic.life.main

class Greeting {
    private val platform = getPlatform()
    private val version: Int = getVersion()

    fun greet(): String {
        return "Hello, ${platform.name}! and version: $version"
    }
}