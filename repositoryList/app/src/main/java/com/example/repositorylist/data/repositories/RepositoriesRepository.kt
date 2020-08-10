package com.example.repositorylist.data.repositories

import com.example.repositorylist.api.GithubApi

import com.example.repositorylist.data.model.repository.Repository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoriesRepository(private val githubApi: GithubApi) {

    fun listRepository(page: Int = 1): Single<List<Repository>> {
        return githubApi.getRepositoryList(QUERY, STARS, page)
            .subscribeOn(Schedulers.io())
            .map {
                it.items.map { repo ->
                    Repository(
                        repo.name,
                        repo.owner.login,
                        repo.owner.avatarUrl,
                        repo.stargazersCount,
                        repo.description ?: ""
                    )
                }
            }
    }

    companion object {
        const val QUERY = "language:kotlin"
        const val STARS = "stars"
    }
}