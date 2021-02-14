package com.example.tasklist.di

import com.example.core_api.AppWithFacade
import com.example.core_api.ProvidersFacade
import com.example.tasklist.presentation.TaskFragment
import dagger.Component


@Component(
    dependencies = [ProvidersFacade::class],
    modules = [TaskFragmentModule::class]
)
interface TaskFragmentComponent {

    companion object {

        fun create(providersFacade: ProvidersFacade): TaskFragmentComponent {
            return DaggerTaskFragmentComponent.builder()
                .providersFacade(providersFacade)
                .build()
        }

        fun injectFragment(fragment: TaskFragment): TaskFragmentComponent  {
            val component = create((fragment.activity?.application
                    as AppWithFacade).getFacade())
            component.inject(fragment)
            return component
        }
    }

    fun inject(fragment: TaskFragment)
}