package com.example.core.di.component

import com.example.core.di.module.DatabaseModule
import com.example.core_api.AppProvider
import com.example.core_api.DatabaseProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [DatabaseModule::class]
)
interface CoreComponent: DatabaseProvider {
}