package com.prikaro.spark


object KmmUtils {
    private var manager: ToastManager? = null

    fun init(manager: ToastManager) {
        this.manager = manager
    }

    fun show(message: String) {
        checkNotNull(manager) {
            "KMMToast not initialized! Call KMMToast.init(manager) before using show()."
        }.showToast(message)
    }

    fun showDialog(title: String, message: String, buttonText: String) {
        checkNotNull(manager) {
            "KMMToast not initialized! Call KMMToast.init(manager) before using showDialog()."
        }.showDialog(title, message, buttonText)
    }
}