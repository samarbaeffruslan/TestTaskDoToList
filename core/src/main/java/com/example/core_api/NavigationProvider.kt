package com.example.core_api

import com.example.core.navigation.AddItemTaskNavigator
import com.example.core.navigation.TaskListNavigator

interface NavigationProvider {

    fun provideAddItemNavigator(): TaskListNavigator

    fun providerAddItemTaskNavigator(): AddItemTaskNavigator
    
}