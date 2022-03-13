package com.na.sadapay.di.githubrepositories

import com.na.sadapay.presentation.githubrepositories.mapper.GithubRepositoryAuthorDomainToPresentationModelMapper
import com.na.sadapay.presentation.githubrepositories.mapper.GithubRepositoryDomainToPresentationModelMapper
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object GithubRepositoriesPresentationModule {
    @Provides
    @Reusable
    fun providesGithubRepositoryAuthorDomainToPresentationModelMapper(): GithubRepositoryAuthorDomainToPresentationModelMapper =
        GithubRepositoryAuthorDomainToPresentationModelMapper()

    @Provides
    @Reusable
    fun providesTrendingRepositoriesAdapter(
        githubRepositoryAuthorPresentationModelMapper: GithubRepositoryAuthorDomainToPresentationModelMapper
    ): GithubRepositoryDomainToPresentationModelMapper =
        GithubRepositoryDomainToPresentationModelMapper(
            githubRepositoryAuthorPresentationModelMapper
        )
}
