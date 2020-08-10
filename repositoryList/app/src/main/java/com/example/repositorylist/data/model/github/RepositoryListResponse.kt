package com.example.repositorylist.data.model.github

import com.google.gson.annotations.SerializedName

data class RepositoryListResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("items") val items: List<Repositories>
)