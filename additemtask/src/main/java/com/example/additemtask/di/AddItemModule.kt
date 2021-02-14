package com.example.additemtask.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.additemtask.data.AddItemRepository
import com.example.additemtask.data.AddItemRepositoryImpl
import com.example.additemtask.presentation.AddItemFragmentViewModel
import com.example.core.di.viewmodelkey.ViewModelKey
import com.example.core.viewmodelfactory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface AddItemModule {
    @Binds
    @IntoMap
    @ViewModelKey(AddItemFragmentViewModel::class)
    fun bindViewModel(viewModel: AddItemFragmentViewModel): ViewModel

    @Binds
    fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun providePopularRepository(repository: AddItemRepositoryImpl): AddItemRepository
}