package com.example.repositorylist

import android.app.Application
import com.example.repositorylist.api.ApiModule
import com.example.repositorylist.data.repositories.RepositoriesModule
import com.example.repositorylist.repositoriesList.RepositoryListModule
import com.example.repositorylist.usecases.UseCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // use AndroidLogger as Koin Logger - default Level.INFO
            androidLogger()

            // use the Android context given there
            androidContext(this@App)

            // load properties from assets/koin.properties file
            androidFileProperties()

            // module list
            modules(
                RepositoryListModule.module,
                ApiModule.module,
                UseCasesModule.module,
                RepositoriesModule.module
            )
        }
    }
}