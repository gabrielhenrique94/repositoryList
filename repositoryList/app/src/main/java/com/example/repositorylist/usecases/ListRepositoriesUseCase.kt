package com.example.repositorylist.usecases

import com.example.repositorylist.data.model.repository.Repository
import com.example.repositorylist.data.repositories.RepositoriesRepository
import io.reactivex.rxjava3.core.Single

class ListRepositoriesUseCase(private val repository: RepositoriesRepository) {
    fun execute(page: Int = 1): Single<List<Repository>> {
        return repository.listRepository(page)
    }
}