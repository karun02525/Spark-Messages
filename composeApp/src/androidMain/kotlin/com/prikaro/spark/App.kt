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
import com.prikaro.spark.bridge.NativeBridge
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    val context = LocalContext.current
    val msg: NativeBridge = koinInject()
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = {
                msg.share("Hello from KMMToast!")
            }) {
                Text("Click me Share!")
            }

            Button(onClick = {

                msg.showToast("Hello from KMMToast! Dialog")

            }) {
                Text("Click me! Dialog")
            }
        }
    }
}