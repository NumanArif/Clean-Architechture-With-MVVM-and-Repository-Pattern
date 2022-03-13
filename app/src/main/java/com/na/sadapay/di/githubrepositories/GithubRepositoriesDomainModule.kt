package com.na.sadapay.di.githubrepositories

import com.na.sadapay.domain.githubrepositories.GithubRepository
import com.na.sadapay.domain.githubrepositories.usecase.GetTrendingGithubRepositoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GithubRepositoriesDomainModule {
    @Provides
    @Reusable
    fun providesGetTrendingGithubRepositoriesUseCase(
        githubRepository: GithubRepository
    ): GetTrendingGithubRepositoriesUseCase = GetTrendingGithubRepositoriesUseCase(githubRepository)
}
