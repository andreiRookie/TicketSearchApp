package com.andreirookie.ticketsearch

import android.app.Application
import android.content.Context
import com.andreirookie.impl.AppContextProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent : AppContextProvider {

    companion object {
        private var appContextProvider: AppContextProvider? = null

        fun getComponent(application: Application): AppContextProvider {
            return  appContextProvider ?: DaggerAppComponent
                .builder()
                .bindContext(application.applicationContext)
                .build()
                .also { appContextProvider = it }

        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): AppComponent
    }
}