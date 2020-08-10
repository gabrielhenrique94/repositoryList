package com.example.repositorylist.data.repositories

import com.example.repositorylist.api.GithubApi

import com.example.repositorylist.data.model.repository.Repository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

open class RepositoriesRepositoryImpl(
    private val githubApi: GithubApi,
    private val repositoryCache: RepositoriesCache

) : RepositoriesRepository {
    override fun listRepository(page: Int): Single<List<Repository>> {
        return repositoryCache.getNextPage(page, PAGE_SIZE)
            .subscribeOn(Schedulers.io())
            .flatMap { list ->
                if (list.isEmpty()) {
                    githubApi.getRepositoryList(QUERY, STARS, page, PAGE_SIZE)
                        .subscribeOn(Schedulers.io())
                        .map {
                            it.items.map { repo ->
                                Repository.fromRepository(repo)
                            }
                        }
                        .doOnSuccess { repositoryCache.addNextPage(it) }
                } else {
                    Single.just(list)
                }
            }
    }

    companion object {
        const val QUERY = "language:kotlin"
        const val STARS = "stars"
        const val PAGE_SIZE = 50
    }
}