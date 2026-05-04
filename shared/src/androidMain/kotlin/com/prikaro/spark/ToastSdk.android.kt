package com.prikaro.spark

import android.content.Context
import com.prikaro.spark.di.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform


actual object ToastSdk {
    private var started = false

    actual fun start(context: Any?) {
        if (started) return

        val appContext = context as? Context
            ?: throw IllegalArgumentException("ToastSdk.start(this) requires a valid Android Context")

        val currentKoin = KoinPlatform.getKoinOrNull()

        if (currentKoin == null) {
            // Koin not yet started → start it and provide context
            startKoin {
                androidContext(appContext)
                modules(androidModule)
            }
        } else {
            // ✅ FIX: Koin already started → declare context + load SDK modules
            currentKoin.declare<Context>(appContext)
            currentKoin.loadModules(listOf(androidModule))
        }

        started = true
    }
}