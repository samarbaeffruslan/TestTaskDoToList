package com.example.testtaskdotolist.di

import com.example.core.navigation.AddItemNavigator
import com.example.navigation.AddItemNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable


@Module
interface NavigationModule {

    @Reusable
    @Binds
    fun addItemNavigator(navigator: AddItemNavigatorImpl): AddItemNavigator
}