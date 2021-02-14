package com.example.core_api

import com.example.core.navigation.AddItemNavigator

interface NavigationProvider {

    fun provideAddItemNavigator(): AddItemNavigator
    
}