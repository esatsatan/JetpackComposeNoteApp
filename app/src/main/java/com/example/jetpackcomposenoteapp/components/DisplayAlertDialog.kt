package com.example.jetpackcomposenoteapp.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun DisplayAlertDialog(
    title: String,
    message: String,
    openDialog: Boolean,
    closeDialog: () -> Unit,
    onYesClicked: () -> Unit
) {

    if (openDialog) {
        AlertDialog(
            title = {
                Text(
                    text = title,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = message,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    fontWeight = FontWeight.Normal
                )
            },
            confirmButton = {
                 Button(
                     onClick = {
                         onYesClicked()
                         closeDialog()
                     }
                 ) {
                    Text(text = "Evet")
                 }
            },
            dismissButton = {
                Button(
                    onClick = {
                        closeDialog()
                    }
                ) {
                    Text(text = "Hayır")
                }
            },
            onDismissRequest = { closeDialog }
        )
    }

}