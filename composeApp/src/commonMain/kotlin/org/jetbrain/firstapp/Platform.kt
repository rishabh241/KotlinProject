package org.jetbrain.firstapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform