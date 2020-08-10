package com.example.repositorylist.data.model.repository

import com.example.repositorylist.data.model.github.Owner
import com.example.repositorylist.data.model.github.Repositories

data class Repository(
    val repositoryName: String,
    val ownerName: String,
    val ownerImgUrl: String,
    val stars: Int,
    val description: String
) {
    companion object {
        fun fromRepository(repo: Repositories): Repository {
            return Repository(
                repo.name,
                repo.owner.login,
                repo.owner.avatarUrl,
                repo.stargazersCount,
                repo.description ?: ""
            )
        }
    }
}