package com.example.repositorylist.data.model.repository

data class Repository(
    val repositoryName: String,
    val ownerName: String,
    val ownerImgUrl: String,
    val stars: Int,
    val description: String
)