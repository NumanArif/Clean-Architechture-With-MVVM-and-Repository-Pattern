package com.na.sadapay.data.githubrepositories.datasource.remote

import com.na.sadapay.data.githubrepositories.model.GithubRepositoryDataModel

interface GithubRepositoriesRemoteSource {
    suspend fun getTrendingRepositories(): List<GithubRepositoryDataModel>
}
