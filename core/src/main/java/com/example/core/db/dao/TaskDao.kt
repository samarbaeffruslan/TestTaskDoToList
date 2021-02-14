package com.example.core.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.core.db.entites.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getTasks(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)
}