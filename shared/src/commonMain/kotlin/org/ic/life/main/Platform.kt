package org.ic.life.main

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform