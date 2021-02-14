package com.example.core.db.entites

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "task_table")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val completed: Boolean = false,
)