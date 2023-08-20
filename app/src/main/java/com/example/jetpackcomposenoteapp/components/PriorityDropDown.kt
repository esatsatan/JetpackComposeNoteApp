package com.example.jetpackcomposenoteapp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposenoteapp.data.models.Priority

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { expanded = true }
            .border(
                width = 1.dp,
                color = Color.Black
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        
        Canvas(
            modifier = Modifier
                .size(20.dp)
                .weight(1f)
        ) {
            drawCircle(color = priority.color)
        }
        Text(
            text = priority.name,
            modifier = Modifier.weight(8f),
            style = MaterialTheme.typography.titleMedium
        )
        IconButton(
            modifier = Modifier
                .alpha(1f)
                .rotate(0f)
                .weight(1.5f),
            onClick = { expanded = true}
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "Drop Down Icon"
            )
        }

        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.94f),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            DropdownMenuItem(
                text = {
                    Text(text = "Low")
                },
                onClick = {
                    expanded = false
                    onPrioritySelected(Priority.LOW)
                }
            )

            DropdownMenuItem(
                text = {
                    Text(text = "HIGH")
                },
                onClick = {
                    expanded = false
                    onPrioritySelected(Priority.HIGH)
                }
            )

            DropdownMenuItem(
                text = {
                    Text(text = "MEDIUM")
                },
                onClick = {
                    expanded = false
                    onPrioritySelected(Priority.MEDIUM)
                }
            )


        }
    }

}
