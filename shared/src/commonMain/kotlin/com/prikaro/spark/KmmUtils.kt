package com.prikaro.spark

import kotlin.experimental.ExperimentalObjCName
import kotlin.native.ObjCName

// In your library: shared/src/commonMain/kotlin/.../KmmUtils.kt
object KmmUtils {
    private var manager: ToastManager? = null

    // Use a default value of null to support the 'No value passed' fix for iOS
    @OptIn(ExperimentalObjCName::class)
    @ObjCName("initialize")
    fun init(manager: ToastManager? = null) {
        this.manager = manager
    }

    fun show(message: String) {
        val currentManager = manager
        if (currentManager == null) {
            // Log a warning instead of throwing an exception to prevent crashes
            println("KMMToast Warning: show() called before init. Message: $message")
            return
        }
        currentManager.showToast(message)
    }

    fun showDialog(title: String, message: String, buttonText: String) {
        val currentManager = manager
        if (currentManager == null) {
            println("KMMToast Warning: showDialog() called before init.")
            return
        }
        currentManager.showDialog(title, message, buttonText)
    }
}