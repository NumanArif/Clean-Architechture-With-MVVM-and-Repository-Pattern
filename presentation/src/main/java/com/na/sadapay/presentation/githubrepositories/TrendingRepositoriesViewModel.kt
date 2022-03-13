package com.na.sadapay.presentation.githubrepositories

import com.na.sadapay.domain.githubrepositories.usecase.GetTrendingGithubRepositoriesUseCase
import com.na.sadapay.presentation.core.BaseViewModel
import com.na.sadapay.presentation.githubrepositories.mapper.GithubRepositoryDomainToPresentationModelMapper
import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TrendingRepositoriesViewModel @Inject constructor(
    private val githubRepositoriesUseCase: GetTrendingGithubRepositoriesUseCase,
    private val gGithubRepositoryPresentationModelMapper: GithubRepositoryDomainToPresentationModelMapper
) : BaseViewModel() {
    private val _trendingRepositories by lazy {
        MutableStateFlow<List<GithubRepositoryPresentationModel>>(emptyList())
    }
    val trendingRepositories: StateFlow<List<GithubRepositoryPresentationModel>>
        get() = _trendingRepositories

    fun onFetchTrendingGithubRepositories() {
        // TODO("Not yet implemented")
    }

    private fun updateTrendingRepositories(trendingRepos: List<GithubRepositoryPresentationModel>) {
    }

    private fun handleError(exception: Exception) {
        // TODO("Not yet implemented")
    }

    fun onRetryAction() {
        // TODO("Not yet implemented")
    }
}
