package com.example.testtaskdotolist.di

import com.example.core.navigation.AddItemTaskNavigator
import com.example.core.navigation.TaskListNavigator
import com.example.navigation.AddItemTaskNavigatorImpl
import com.example.navigation.TaskListNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable


@Module
interface NavigationModule {

    @Reusable
    @Binds
    fun addItemNavigator(taskNavigator: AddItemTaskNavigatorImpl): AddItemTaskNavigator

    @Reusable
    @Binds
    fun listNavigator(listNavigator: TaskListNavigatorImpl): TaskListNavigator
}