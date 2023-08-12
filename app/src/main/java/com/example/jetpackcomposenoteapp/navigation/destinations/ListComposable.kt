package com.example.jetpackcomposenoteapp.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetpackcomposenoteapp.util.Constants.LIST_ARGUMENT_KEY
import com.example.jetpackcomposenoteapp.util.Constants.LIST_SCREEN
import com.example.jetpackcomposenoteapp.view.screens.ListScreen

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ) {
        ListScreen(navigateToTaskScreen = navigateToTaskScreen)

    }
}