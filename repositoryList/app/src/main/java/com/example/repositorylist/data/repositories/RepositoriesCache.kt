package com.example.repositorylist.data.repositories

import com.example.repositorylist.data.model.repository.Repository
import io.reactivex.rxjava3.core.Single

interface RepositoriesCache {
    fun getNextPage(page: Int, pageSize: Int): Single<List<Repository>>
    fun addNextPage(list: List<Repository>)
}