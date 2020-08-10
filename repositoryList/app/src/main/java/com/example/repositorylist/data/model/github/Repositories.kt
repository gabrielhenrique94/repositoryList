package com.example.repositorylist.data.model.github

import com.google.gson.annotations.SerializedName

data class Repositories(
    @SerializedName("name") val name: String,
    @SerializedName("owner") val owner: Owner,
    @SerializedName("description") val description: String?,
    @SerializedName("stargazers_count") val stargazersCount: Int
)