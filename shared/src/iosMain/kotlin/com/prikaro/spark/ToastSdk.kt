package com.prikaro.spark
import com.prikaro.spark.bridge.IOSBridge
import com.prikaro.spark.bridge.NativeBridge
import com.prikaro.spark.bridge.iosBridge
import com.prikaro.spark.di.iosModule
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform


actual object ToastSdk {
    private var started = false

    actual fun start(context: Any?) {
        if (started) return
        startKoin {
            modules(iosModule)
        }
        started = true
    }

    fun setup(bridge: IOSBridge) {
        iosBridge = bridge
        start(null)
    }

    fun getNativeBridge(): NativeBridge = KoinPlatform.getKoin().get()
}