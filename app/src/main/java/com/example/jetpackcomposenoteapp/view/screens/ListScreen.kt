package com.example.jetpackcomposenoteapp.view.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import com.example.jetpackcomposenoteapp.components.ListAppBar
import com.example.jetpackcomposenoteapp.components.ListContent
import com.example.jetpackcomposenoteapp.util.Action
import com.example.jetpackcomposenoteapp.util.SearchAppBarState
import com.example.jetpackcomposenoteapp.viewmodels.SharedViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {

    LaunchedEffect(key1 = true) {
        sharedViewModel.getAllTasks()
    }

    val snackbarHostState = remember { SnackbarHostState() }

    val action by sharedViewModel.action

    val allTasks by sharedViewModel.allTasks.collectAsState()

    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState

    val searchTextState: String by sharedViewModel.searchTextState

    sharedViewModel.handleDatabaseActions(action = action)
    
    DisplaySnackBar(
        handleDatabaseActions = { sharedViewModel.handleDatabaseActions(action = action)},
        tastTitle = sharedViewModel.title.value,
        action = action,
        snackbarHostState = snackbarHostState
    )


    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        },
        content = {
            ListContent(
                tasks = allTasks,
                navigateToTaskScreen = navigateToTaskScreen
            )
        },
    )

}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Button",
            tint = Color.Blue
        )
    }
}

@Composable
fun DisplaySnackBar(
    snackbarHostState: SnackbarHostState,
    handleDatabaseActions: () -> Unit,
    tastTitle: String,
    action: Action
) {
    handleDatabaseActions()

    val scope = rememberCoroutineScope()

    val channel = remember { Channel<Int>(Channel.CONFLATED) }

    LaunchedEffect(key1 = action) {
        if (action != Action.NO_ACTION) {
            channel.receiveAsFlow().collect {
                val result = snackbarHostState.showSnackbar(
                    message = "deneme",
                    "ok"
                )
            }
        }
    }

}






















