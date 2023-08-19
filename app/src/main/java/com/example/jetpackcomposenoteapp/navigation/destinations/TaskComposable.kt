package com.example.jetpackcomposenoteapp.navigation.destinations

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetpackcomposenoteapp.util.Action
import com.example.jetpackcomposenoteapp.util.Constants.LIST_ARGUMENT_KEY
import com.example.jetpackcomposenoteapp.util.Constants.LIST_SCREEN
import com.example.jetpackcomposenoteapp.util.Constants.TASK_ARGUMENT_KEY
import com.example.jetpackcomposenoteapp.util.Constants.TASK_SCREEN
import com.example.jetpackcomposenoteapp.view.screens.taskscreen.TaskScreen
import com.example.jetpackcomposenoteapp.viewmodels.SharedViewModel

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ) { navBackStackEntry ->

        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)

        // get selected todoTask
        sharedViewModel.getSelectedTask(taskId = taskId)

        val selectedTask by sharedViewModel.selectedTask.collectAsState()



        TaskScreen(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )


    }
}