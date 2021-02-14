package com.example.tasklist.data

import androidx.lifecycle.LiveData
import com.example.core.db.dao.TaskDao
import com.example.core.db.entites.TaskEntity
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val dao: TaskDao
) : TaskRepository {

    override suspend fun savedItemTask(taskEntity: TaskEntity) {
        dao.insert(taskEntity)
    }

    override suspend fun deleteTask(taskEntity: TaskEntity) {
        dao.delete(taskEntity)
    }

    override suspend fun updateTask(entity: TaskEntity) {
        dao.update(entity)
    }

    override fun getTasks(): LiveData<List<TaskEntity>> =
        dao.getTasks()




}