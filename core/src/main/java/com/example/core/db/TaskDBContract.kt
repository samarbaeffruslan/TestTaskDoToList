package com.example.core.db

import com.example.core.db.dao.TaskDao

interface TaskDBContract {
    fun taskDao(): TaskDao
}