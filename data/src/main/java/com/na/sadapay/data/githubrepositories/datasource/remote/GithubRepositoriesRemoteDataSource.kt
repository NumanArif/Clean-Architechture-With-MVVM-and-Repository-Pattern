package com.na.sadapay.data.githubrepositories.datasource.remote

import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryApiToDataModelMapper

class GithubRepositoriesRemoteDataSource(
    private val githubRepositoriesService: GithubRepositoriesService,
    private val githubRepositoryApiToDataModelMapper: GithubRepositoryApiToDataModelMapper
) : GithubRepositoriesRemoteSource {
    override suspend fun getTrendingRepositories() =
        githubRepositoryApiToDataModelMapper.mapToData(githubRepositoriesService.getTrendingRepositories())
}
