package com.prikaro.spark

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform