package com.example.repositorylist.data.repositories

import com.example.repositorylist.data.model.repository.Repository
import io.reactivex.rxjava3.core.Single

class RepositoriesCache {
    private val repositories: MutableList<Repository> = mutableListOf()

    fun getNextPage(page: Int, pageSize: Int): Single<List<Repository>> {
        return if (repositories.size >= page * pageSize) {
            val startList = (page - 1) * pageSize
            val endList = page * pageSize - 1
            Single.just(repositories.subList(startList, endList))
        } else {
            Single.just(listOf())
        }
    }

    fun addNextPage(list: List<Repository>) {
        repositories.addAll(list)
    }
}