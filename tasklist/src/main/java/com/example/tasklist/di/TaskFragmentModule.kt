package com.example.tasklist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.di.viewmodelkey.ViewModelKey
import com.example.core.viewmodelfactory.ViewModelFactory
import com.example.tasklist.data.TaskRepository
import com.example.tasklist.data.TaskRepositoryImpl
import com.example.tasklist.presentation.TaskFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface TaskFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(TaskFragmentViewModel::class)
    fun bindDetailViewModel(viewModel: TaskFragmentViewModel): ViewModel


    @Binds
    fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun providePopularRepository(repository: TaskRepositoryImpl): TaskRepository

}