package com.example.additemtask.di

import com.example.additemtask.presentation.AddItemFragment
import com.example.core_api.AppWithFacade
import com.example.core_api.ProvidersFacade
import dagger.Component

@Component(
    dependencies = [ProvidersFacade::class],
    modules = [AddItemModule::class]
)
interface AddItemComponent {

    companion object{
        fun create(providersFacade: ProvidersFacade): AddItemComponent {
            return DaggerAddItemComponent.builder()
                .providersFacade(providersFacade)
                .build()
        }

        fun injectFragment(fragment: AddItemFragment): AddItemComponent  {
            val component = create((fragment.activity?.application
                    as AppWithFacade).getFacade())
            component.inject(fragment)
            return component
        }
    }


    fun inject(fragment: AddItemFragment)
}