package com.prikaro.spark

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val context = LocalContext.current
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = {
                KmmUtils.show("Hello from KMMToast!")
            }) {
                Text("Click me!")
            }

            Button(onClick = {
                KmmUtils.init(AndroidToastManager(context))
                KmmUtils.showDialog(
                    title = "KMMToast Dialog",
                    message = "This is a dialog from KMMToast!",
                    buttonText = "OK"
                )

            }) {
                Text("Click me! Dialog")
            }
        }
    }
}