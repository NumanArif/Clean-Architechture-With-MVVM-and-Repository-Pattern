package com.na.sadapay.data.githubrepositories.datasource.remote

import com.na.sadapay.data.githubrepositories.model.GithubRepositoriesApiModel
import retrofit2.http.GET

interface GithubRepositoriesService {
    @GET("search/repositories?q=language=+sort:stars")
    suspend fun getTrendingRepositories(): GithubRepositoriesApiModel
}
