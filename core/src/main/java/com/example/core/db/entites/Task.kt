package com.example.core.db.entites

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val important: Boolean = false,
    val completed: Boolean = false,
    //val created: Long =
)