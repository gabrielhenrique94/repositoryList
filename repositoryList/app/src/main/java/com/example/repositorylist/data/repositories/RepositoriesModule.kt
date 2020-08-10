package com.example.repositorylist.data.repositories

import org.koin.dsl.module

object RepositoriesModule {
    val module = module {
        single<RepositoriesCache> { RepositoriesCacheImpl() }
        single<RepositoriesRepository> { RepositoriesRepositoryImpl(get(), get()) }
    }
}