package com.example.core_api

import com.example.core.db.TaskDBContract
import com.example.core.db.dao.TaskDao

interface DatabaseProvider {

    fun provideTaskDao(): TaskDao

    fun provideDatabase(): TaskDBContract
}