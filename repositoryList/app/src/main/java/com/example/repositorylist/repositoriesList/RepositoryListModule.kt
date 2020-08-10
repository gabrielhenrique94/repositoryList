package com.example.repositorylist.repositoriesList

import org.koin.core.qualifier.named
import org.koin.dsl.module

object RepositoryListModule {
    val module = module {
        single {
            RepositoryListViewModel(get())
        }
    }
}