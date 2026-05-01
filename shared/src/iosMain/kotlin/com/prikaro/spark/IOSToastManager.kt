package com.prikaro.spark

class IOSToastManager : ToastManager {
    var onShowToast: ((String) -> Unit)? = null
    var onShowDialog: ((String, String, String) -> Unit)? = null

    override fun showToast(message: String) {
        onShowToast?.invoke(message)   // just fire callback
    }

    override fun showDialog(title: String, message: String, buttonText: String) {
        onShowDialog?.invoke(title, message, buttonText)
    }
}