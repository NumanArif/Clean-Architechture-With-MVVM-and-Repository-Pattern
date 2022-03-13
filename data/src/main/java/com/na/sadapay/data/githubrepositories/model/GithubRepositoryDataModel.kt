package com.na.sadapay.data.githubrepositories.model

data class GithubRepositoryDataModel(
    val fullName: String,
    val description: String,
    val url: String,
    val language: String,
    val score: Long,
    val author: GithubRepositoryAuthorDataModel
)
