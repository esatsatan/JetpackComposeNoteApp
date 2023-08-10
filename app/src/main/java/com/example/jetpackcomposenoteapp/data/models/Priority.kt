package com.example.jetpackcomposenoteapp.data.models

import androidx.compose.ui.graphics.Color
import com.example.jetpackcomposenoteapp.ui.theme.HighPriorityColor
import com.example.jetpackcomposenoteapp.ui.theme.LowPriorityColor
import com.example.jetpackcomposenoteapp.ui.theme.MediumPriorityColor
import com.example.jetpackcomposenoteapp.ui.theme.NonePriorityColor


enum class Priority(val color : Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}