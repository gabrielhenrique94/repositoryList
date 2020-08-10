package com.example.repositorylist.usecases

import org.koin.dsl.module

object UseCasesModule {
    val module = module {
        single<ListRepositoriesUseCase> { ListRepositoriesUseCaseImpl(get()) }
    }
}