package com.example.repositorylist.usecases

import com.example.repositorylist.data.model.repository.Repository
import io.reactivex.rxjava3.core.Single

interface ListRepositoriesUseCase {
    fun resetPageCount()
    fun execute(): Single<List<Repository>>
}