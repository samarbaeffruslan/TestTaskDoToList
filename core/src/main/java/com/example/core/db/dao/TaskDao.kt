package com.example.core.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.core.db.entites.TaskEntity

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getTasks(): LiveData<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(taskEntity: TaskEntity)

    @Update
    suspend fun update(taskEntity: TaskEntity)

    @Delete
    suspend fun delete(taskEntity: TaskEntity)
}