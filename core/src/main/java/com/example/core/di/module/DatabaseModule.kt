package com.example.core.di.module

import android.content.Context
import androidx.room.Room
import com.example.core.db.TaskDB
import com.example.core.db.TaskDBContract
import com.example.core.db.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class DatabaseModule {
    companion object{
        @Provides
        @Singleton
        fun provideLoftMovieDatabase(context: Context): TaskDBContract{
            return Room.databaseBuilder(
                context,
                TaskDB::class.java,
                "task_db"
            ).fallbackToDestructiveMigration().build()
        }

        @Provides
        @Reusable
        fun provideFilmDao(taskDBContract: TaskDBContract): TaskDao{
            return taskDBContract.taskDao()
        }
    }
}