package com.example.additemtask.data

import com.example.core.db.entites.TaskEntity

interface AddItemRepository {

    suspend fun savedItemTask(taskEntity: TaskEntity)

    suspend fun update(taskEntity: TaskEntity)
}