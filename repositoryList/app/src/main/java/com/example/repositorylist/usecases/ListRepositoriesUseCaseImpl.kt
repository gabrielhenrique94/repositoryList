package com.example.repositorylist.usecases

import com.example.repositorylist.data.model.repository.Repository
import com.example.repositorylist.data.repositories.RepositoriesRepository
import io.reactivex.rxjava3.core.Single

class ListRepositoriesUseCaseImpl(private val repository: RepositoriesRepository) :
    ListRepositoriesUseCase {
    private var page: Int = 0

    override fun resetPageCount() {
        page = 0
    }

    override fun execute(): Single<List<Repository>> {
        page++
        return repository.listRepository(page)
    }
}