package com.example.repositorylist.utils

import com.example.repositorylist.data.model.github.Owner
import com.example.repositorylist.data.model.github.Repositories
import com.example.repositorylist.data.model.github.RepositoryListResponse
import com.example.repositorylist.data.model.repository.Repository

fun getRepositoryPage(pageSize: Int): List<Repository> {
    val list: MutableList<Repository> = mutableListOf()
    repeat(pageSize) {
        list.add(Repository("name", "ownerName", "ownerImgUrl", 1500, "description"))
    }
    return list.toList()
}

fun getRepositoryApiPage(pageSize: Int): RepositoryListResponse {
    val list: MutableList<Repositories> = mutableListOf()

    repeat(pageSize) {
        list.add(Repositories("name", Owner("ownerName", "ownerImgUrl"), "description", 1500))
    }

    return RepositoryListResponse(pageSize, list)
}

