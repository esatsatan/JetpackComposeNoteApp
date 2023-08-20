package com.example.jetpackcomposenoteapp.view.screens.taskscreen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.jetpackcomposenoteapp.data.models.Priority
import com.example.jetpackcomposenoteapp.data.models.ToDoTask
import com.example.jetpackcomposenoteapp.util.Action
import com.example.jetpackcomposenoteapp.viewmodels.SharedViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    sharedViewModel: SharedViewModel,
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority
    
    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {
             TaskContent(
                 title = title,
                 onTitleChange = {
                     sharedViewModel.updateTitle(it)
                 },
                 description = description,
                 onDescriptionChange = {
                     sharedViewModel.description.value = it
                 },
                 priority = priority,
                 onPrioritySelected = {
                     sharedViewModel.priority.value = it
                 }
             )
        },
    )
}