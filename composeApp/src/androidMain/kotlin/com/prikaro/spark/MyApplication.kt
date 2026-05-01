package com.prikaro.spark

import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KmmUtils.init(AndroidToastManager(this))
    }
}