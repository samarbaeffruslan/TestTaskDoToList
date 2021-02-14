package com.example.testtaskdotolist

import android.app.Application
import com.example.core_api.AppWithFacade
import com.example.core_api.ProvidersFacade
import com.example.testtaskdotolist.di.FacadeComponent


class BaseApp: Application(), AppWithFacade {

    companion object {
        private var facadeComponent: FacadeComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
    }

    override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it }
    }
}