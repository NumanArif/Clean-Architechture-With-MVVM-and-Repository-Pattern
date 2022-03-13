package com.na.sadapay.ui.githubrepositories.model

data class GithubRepositoryUiModel(
    var isExpanded: Boolean,
    val fullName: String,
    val description: String,
    val language: String,
    val score: String,
    val authorName: String,
    val authorAvatarUrl: String
)
