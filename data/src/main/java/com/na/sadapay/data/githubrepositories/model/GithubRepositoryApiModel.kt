package com.na.sadapay.data.githubrepositories.model


data class GithubRepositoryApiModel(
    val full_name: String,
    val owner: GithubRepositoryOwnerApiModel,
    val description: String,
    val html_url: String,
    val language: String?,
    val stargazers_count: Long
)
