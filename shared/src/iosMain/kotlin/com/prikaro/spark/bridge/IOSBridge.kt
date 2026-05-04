package com.prikaro.spark.bridge



interface IOSBridge : NativeBridge
/** Single entry-point set from iOSApp.swift before Koin starts. */
var iosBridge: IOSBridge? = null

