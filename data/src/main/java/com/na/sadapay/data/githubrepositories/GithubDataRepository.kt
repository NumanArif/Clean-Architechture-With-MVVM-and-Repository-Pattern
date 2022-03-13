package com.na.sadapay.data.githubrepositories

import com.na.sadapay.data.githubrepositories.datasource.remote.GithubRepositoriesRemoteSource
import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryDataToDomainModelMapper
import com.na.sadapay.domain.githubrepositories.GithubRepository
import kotlinx.coroutines.flow.flow

class GithubDataRepository(
    private val githubRepositoriesRemoteSource: GithubRepositoriesRemoteSource,
    private val githubRepositoryDataToDomainModelMapper: GithubRepositoryDataToDomainModelMapper
) : GithubRepository {
    override suspend fun trendingRepositories() = flow {
        emit(
            githubRepositoriesRemoteSource.getTrendingRepositories()
                .map(githubRepositoryDataToDomainModelMapper::mapToDomain)
        )
    }
}
