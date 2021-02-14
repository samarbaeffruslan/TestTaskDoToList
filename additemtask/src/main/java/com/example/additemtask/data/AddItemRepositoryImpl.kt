package com.example.additemtask.data

import com.example.core.db.dao.TaskDao
import com.example.core.db.entites.TaskEntity
import javax.inject.Inject

class AddItemRepositoryImpl @Inject constructor(
    private val dao: TaskDao
): AddItemRepository {

    override suspend fun savedItemTask(taskEntity: TaskEntity) {
        dao.insert(taskEntity)
    }

    override suspend fun update(taskEntity: TaskEntity) {
        dao.update(taskEntity)
    }
}