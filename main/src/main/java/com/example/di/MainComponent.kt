package com.example.di

import com.example.core_api.ProvidersFacade
import com.example.main.MainActivity
import dagger.Component

@Component(
    dependencies = [ProvidersFacade::class],
    modules = [MainModule::class]
)
interface MainComponent {

    companion object {

        fun create(providersFacade: ProvidersFacade): MainComponent {
            return DaggerMainComponent
                .builder()
                .providersFacade(providersFacade)
                .build()
        }
    }

    fun inject(activity: MainActivity)
}