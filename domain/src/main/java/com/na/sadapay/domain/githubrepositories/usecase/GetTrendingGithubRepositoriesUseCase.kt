package com.na.sadapay.domain.githubrepositories.usecase

import com.na.sadapay.domain.core.usecase.ContinuousExecuteUseCase
import com.na.sadapay.domain.githubrepositories.GithubRepository
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryDomainModel
import kotlinx.coroutines.flow.collect

class GetTrendingGithubRepositoriesUseCase(
    private val githubRepository: GithubRepository
) : ContinuousExecuteUseCase<Unit, List<GithubRepositoryDomainModel>>() {
    override suspend fun executeInBackground(
        request: Unit,
        onResponse: (List<GithubRepositoryDomainModel>) -> Unit
    ) {
        githubRepository.trendingRepositories().collect { trendingRepositories ->
            onResponse(trendingRepositories)
        }
    }
}
