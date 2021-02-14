package com.example.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.db.entites.TaskEntity


@Database(
    entities = [
        TaskEntity::class
    ], version = 2
)
abstract class TaskDB: RoomDatabase(),TaskDBContract {
}