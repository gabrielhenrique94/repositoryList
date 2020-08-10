package com.example.repositorylist.api

import com.example.repositorylist.data.model.github.RepositoryListResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("/search/repositories")
    fun getRepositoryList(
        @Query("q") query: String,
        @Query("sort") sortBy: String,
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): Single<RepositoryListResponse>
}