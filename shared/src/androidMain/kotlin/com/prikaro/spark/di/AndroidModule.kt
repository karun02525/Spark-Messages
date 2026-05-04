package com.prikaro.spark.di

import com.prikaro.spark.bridge.AndroidNativeBridge
import com.prikaro.spark.bridge.NativeBridge
import org.koin.dsl.module

val androidModule = module {
    single<NativeBridge> { AndroidNativeBridge() }
}