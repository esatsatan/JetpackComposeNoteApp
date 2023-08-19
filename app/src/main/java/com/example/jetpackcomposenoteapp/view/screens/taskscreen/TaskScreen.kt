package com.example.jetpackcomposenoteapp.view.screens.taskscreen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.jetpackcomposenoteapp.data.models.ToDoTask
import com.example.jetpackcomposenoteapp.util.Action

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    
    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {},
    )
}