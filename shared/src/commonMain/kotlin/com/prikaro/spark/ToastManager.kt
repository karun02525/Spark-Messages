package com.prikaro.spark

interface ToastManager {
    fun showToast(message: String)

    fun showDialog(title: String, message: String, buttonText: String)
}