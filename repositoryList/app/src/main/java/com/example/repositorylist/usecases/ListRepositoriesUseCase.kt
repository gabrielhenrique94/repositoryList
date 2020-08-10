package com.example.repositorylist.usecases

import com.example.repositorylist.data.model.repository.Repository
import com.example.repositorylist.data.repositories.RepositoriesRepository
import io.reactivex.rxjava3.core.Single

class ListRepositoriesUseCase(private val repository: RepositoriesRepository) {
    var page: Int = 0

    fun execute(): Single<List<Repository>> {
        page++
        return repository.listRepository(page)
    }
}