package com.prikaro.spark

import android.app.AlertDialog
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

class AndroidToastManager(private val context: Context) : ToastManager {

    override fun showToast(message: String) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(
                context.applicationContext,
                message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun showDialog( title: String, message: String, buttonText: String) {
            Handler(Looper.getMainLooper()).post {
               AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(buttonText) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
    }
}