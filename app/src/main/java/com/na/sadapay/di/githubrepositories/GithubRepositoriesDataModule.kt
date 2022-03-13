package com.na.sadapay.di.githubrepositories

import com.na.sadapay.data.githubrepositories.GithubDataRepository
import com.na.sadapay.data.githubrepositories.datasource.remote.GithubRepositoriesRemoteDataSource
import com.na.sadapay.data.githubrepositories.datasource.remote.GithubRepositoriesRemoteSource
import com.na.sadapay.data.githubrepositories.datasource.remote.GithubRepositoriesService
import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryApiToDataModelMapper
import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryAuthorDataToDomainModelMapper
import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryDataToDomainModelMapper
import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryOwnerApiToAuthorDataModelMapper
import com.na.sadapay.domain.githubrepositories.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object GithubRepositoriesDataModule {
    @Provides
    @Reusable
    fun providesGithubRepositoriesService(retrofit: Retrofit): GithubRepositoriesService =
        retrofit.create(GithubRepositoriesService::class.java)

    @Provides
    @Reusable
    fun providesGithubRepositoriesRemoteDataSource(
        githubRepositoriesService: GithubRepositoriesService,
        githubRepositoryApiToDataModelMapper: GithubRepositoryApiToDataModelMapper
    ): GithubRepositoriesRemoteSource = GithubRepositoriesRemoteDataSource(
        githubRepositoriesService,
        githubRepositoryApiToDataModelMapper
    )

    @Provides
    @Reusable
    fun providesGithubRepositoryApiToDataModelMapper(
        githubRepositoryAuthorDomainModelMapper: GithubRepositoryOwnerApiToAuthorDataModelMapper
    ): GithubRepositoryApiToDataModelMapper =
        GithubRepositoryApiToDataModelMapper(githubRepositoryAuthorDomainModelMapper)

    @Provides
    @Reusable
    fun providesGithubRepositoryOwnerApiToAuthorDataModelMapper(): GithubRepositoryOwnerApiToAuthorDataModelMapper =
        GithubRepositoryOwnerApiToAuthorDataModelMapper()

    @Provides
    @Reusable
    fun providesGithubRepository(
        githubRepositoriesRemoteSource: GithubRepositoriesRemoteSource,
        githubRepositoryDataToDomainModelMapper: GithubRepositoryDataToDomainModelMapper
    ): GithubRepository = GithubDataRepository(
        githubRepositoriesRemoteSource,
        githubRepositoryDataToDomainModelMapper
    )

    @Provides
    @Reusable
    fun providesGithubRepositoryDataToDomainModelMapper(
        githubRepositoryAuthorDomainModelMapper: GithubRepositoryAuthorDataToDomainModelMapper
    ): GithubRepositoryDataToDomainModelMapper =
        GithubRepositoryDataToDomainModelMapper(githubRepositoryAuthorDomainModelMapper)

    @Provides
    @Reusable
    fun providesGithubRepositoryAuthorDataToDomainModelMapper(): GithubRepositoryAuthorDataToDomainModelMapper =
        GithubRepositoryAuthorDataToDomainModelMapper()
}
