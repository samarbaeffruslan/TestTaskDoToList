package com.example.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.db.entites.Task


@Database(
    entities = [
        Task::class
    ],
    version = 1
)
abstract class TaskDB: RoomDatabase(),TaskDBContract {
}