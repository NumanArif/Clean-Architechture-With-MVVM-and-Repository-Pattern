package com.na.sadapay.di.githubrepositories

import com.na.sadapay.ui.githubrepositories.adapter.TrendingRepositoriesAdapter
import com.na.sadapay.ui.githubrepositories.adapter.TrendingRepositoriesDiffUtils
import com.na.sadapay.ui.githubrepositories.mapper.GithubRepositoryPresentationToUiModelMapper
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object GithubRepositoriesUiModule {
    @Provides
    @Reusable
    fun providesTrendingRepositoriesAdapter(
        diffCallback: TrendingRepositoriesDiffUtils
    ): TrendingRepositoriesAdapter = TrendingRepositoriesAdapter(diffCallback)

    @Provides
    @Reusable
    fun providesTrendingRepositoriesDiffUtils(): TrendingRepositoriesDiffUtils =
        TrendingRepositoriesDiffUtils()

    @Provides
    @Reusable
    fun providesGithubRepositoryPresentationToUiModelMapper(): GithubRepositoryPresentationToUiModelMapper =
        GithubRepositoryPresentationToUiModelMapper()
}
