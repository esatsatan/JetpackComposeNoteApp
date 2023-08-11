package com.example.jetpackcomposenoteapp.data.repositories

import com.example.jetpackcomposenoteapp.data.ToDoDao
import com.example.jetpackcomposenoteapp.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(
    private val toDoDao : ToDoDao
) {

    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int) : Flow<ToDoTask> {
        return toDoDao.getSelectedTask(taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addNewTask(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        toDoDao.updateTask(toDoTask = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoDao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTask() {
        toDoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery : String): Flow<List<ToDoTask>> {
        return toDoDao.searchDatabase(searchQuery = searchQuery)
    }





}