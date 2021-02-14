package com.example.tasklist.data

import androidx.lifecycle.LiveData
import com.example.core.db.entites.TaskEntity

interface TaskRepository {

    suspend fun savedItemTask(taskEntity: TaskEntity)

    suspend fun deleteTask(taskEntity: TaskEntity)

    suspend fun updateTask(entity: TaskEntity)

    fun getTasks(): LiveData<List<TaskEntity>>
}