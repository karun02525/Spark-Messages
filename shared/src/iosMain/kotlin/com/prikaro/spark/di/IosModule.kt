package com.prikaro.spark.di


import com.prikaro.spark.bridge.NativeBridge
import com.prikaro.spark.bridge.iosBridge
import org.koin.dsl.module

val iosModule = module {

    single<NativeBridge> {
        iosBridge ?: error("iosBridge not set. Call IOSBridgeKt.iosBridge = IOSBridgeImpl() before startKoinApp.")
    }
}