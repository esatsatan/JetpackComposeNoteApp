package com.example.jetpackcomposenoteapp.view.screens.taskscreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposenoteapp.data.models.Priority
import com.example.jetpackcomposenoteapp.data.models.ToDoTask
import com.example.jetpackcomposenoteapp.util.Action

@Composable
fun TaskAppBar(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    if (selectedTask == null) {
        NewTaskAppBar(navigateToListScreen = navigateToListScreen)
    } else {
        ExistingTaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen,
        )
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {

    TopAppBar(
       navigationIcon = {
           BackAction(onBackClicked = navigateToListScreen)
       },
       title = {
            Text(
                text = "Not Ekle",
                color = Color.White
            )
       },
       actions = {
           AddAction(onAddClicked = navigateToListScreen)
       },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Color.Blue
        )

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExistingTaskAppBar(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {

    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = selectedTask.title,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            DeleteAction(onDeleteClicked = navigateToListScreen)
            UpdateAction(onUpdateClicked = navigateToListScreen)
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Color.Blue
        )

    )
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit
) {
    IconButton(onClick = { onCloseClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "Close",
            tint = Color.White
        )
    }

}

@Composable
fun DeleteAction(
    onDeleteClicked: (Action) -> Unit
) {
    IconButton(onClick = { onDeleteClicked(Action.DELETE) }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
            tint = Color.White
        )
    }

}

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
) {
    IconButton(onClick = { onUpdateClicked(Action.UPDATE) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Check",
            tint = Color.White
        )
    }

}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = { onBackClicked(Action.NO_ACTION) }) {
       Icon(
           imageVector = Icons.Filled.ArrowBack,
           contentDescription = "Back Arrow",
           tint = Color.White
       )
    }

}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = { onAddClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = "Add Task",
            tint = Color.White
        )
    }

}

@Composable
@Preview
fun NewTaskAppBarPreview() {
    NewTaskAppBar(
        navigateToListScreen = {}
    )
}

@Composable
@Preview
fun ExistingAppBarPreview() {
    ExistingTaskAppBar(
        selectedTask = ToDoTask(
            id = 0,
            title = "Stedvadcs",
            description = "Some random text",
            priority = Priority.LOW
        ),
        navigateToListScreen = {}
    )
}