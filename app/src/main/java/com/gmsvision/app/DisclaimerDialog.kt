package com.gmsvision.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisclaimerDialog(onAccept: () -> Unit, onDismiss: () -> Unit,) {
    AlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        ),
        title = {
            Text(
                text = "Important Disclaimer",
                style = MaterialTheme.typography.headlineSmall
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "TNPSC Current Affairs by GMS Vision is NOT an official government application or website. This app provides educational content related to the Tamil Nadu Public Service Commission (TNPSC) exams. GMS Vision is not affiliated with, endorsed, or sponsored by the Tamil Nadu Public Service Commission or any other government entity. All information displayed in this app is collected from publicly available sources such as news agencies and official press releases. This app is intended solely for educational and informational purposes and does not guarantee the accuracy or completeness of the content. Use this app at your own discretion.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        },
        confirmButton = {
            Button(
                onClick = onAccept,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("I Understand - Continue", color = Color.White)
            }
        },
        dismissButton = {}
    )
}