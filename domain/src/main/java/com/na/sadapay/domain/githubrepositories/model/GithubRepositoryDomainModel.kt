package com.na.sadapay.domain.githubrepositories.model

data class GithubRepositoryDomainModel(
    val fullName: String,
    val description: String,
    val url: String,
    val language: String,
    val score: Long,
    val author: GithubRepositoryAuthorDomainModel
)
