package com.na.sadapay.domain.githubrepositories

import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryDomainModel
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    suspend fun trendingRepositories() : Flow<List<GithubRepositoryDomainModel>>
}
