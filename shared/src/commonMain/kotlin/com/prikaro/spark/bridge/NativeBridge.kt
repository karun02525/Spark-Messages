package com.prikaro.spark.bridge

interface NativeBridge {
    fun showToast(message: String)
    fun share(message: String)
}

