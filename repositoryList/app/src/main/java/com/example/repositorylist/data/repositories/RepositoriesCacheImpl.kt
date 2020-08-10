package com.example.repositorylist.data.repositories

import com.example.repositorylist.data.model.repository.Repository
import io.reactivex.rxjava3.core.Single

 class RepositoriesCacheImpl : RepositoriesCache {
    private val repositories: MutableList<Repository> = mutableListOf()

    override fun getNextPage(page: Int, pageSize: Int): Single<List<Repository>> {
        return if (repositories.size >= page * pageSize) {
            val startList = (page - 1) * pageSize
            val endList = page * pageSize
            Single.just(repositories.subList(startList, endList))
        } else {
            Single.just(listOf())
        }
    }

    override fun addNextPage(list: List<Repository>) {
        repositories.addAll(list)
    }
}