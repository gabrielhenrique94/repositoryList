package com.example.repositorylist.data.repositories

import com.example.repositorylist.data.model.repository.Repository
import io.reactivex.rxjava3.core.Single

interface RepositoriesRepository {
    fun listRepository(page: Int = 1): Single<List<Repository>>
}