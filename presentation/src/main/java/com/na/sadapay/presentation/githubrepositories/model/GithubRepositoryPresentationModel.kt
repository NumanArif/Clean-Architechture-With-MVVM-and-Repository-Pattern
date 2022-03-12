package com.na.sadapay.presentation.githubrepositories.model

data class GithubRepositoryPresentationModel(
    val fullName: String,
    val description: String,
    val url: String,
    val language: String,
    val score: Float,
    val author: GithubRepositoryAuthorPresentationModel
)
