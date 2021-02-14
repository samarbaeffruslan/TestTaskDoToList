package com.example.testtaskdotolist.di

import android.app.Application
import com.example.core.di.component.DaggerCoreComponent
import com.example.core_api.AppProvider
import com.example.core_api.DatabaseProvider
import com.example.core_api.ProvidersFacade
import com.example.testtaskdotolist.BaseApp
import dagger.Component

@Component(
    dependencies = [
        AppProvider::class,
        DatabaseProvider::class],
    modules = [NavigationModule::class]
)
interface FacadeComponent : ProvidersFacade {

    companion object {
        fun init(application: Application): FacadeComponent =
            DaggerFacadeComponent.builder()
                .appProvider(AppComponent.create(application))
                .databaseProvider(DaggerCoreComponent.builder().appProvider(AppComponent.create(application)).build())
                .build()
    }

    fun inject(app: BaseApp)

}