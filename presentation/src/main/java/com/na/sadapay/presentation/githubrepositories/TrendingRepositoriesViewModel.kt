package com.na.sadapay.presentation.githubrepositories

import androidx.lifecycle.viewModelScope
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryDomainModel
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
    private val githubRepositoryPresentationModelMapper: GithubRepositoryDomainToPresentationModelMapper
) : BaseViewModel() {
    private val _trendingRepositories by lazy {
        MutableStateFlow<List<GithubRepositoryPresentationModel>>(emptyList())
    }
    val trendingRepositories: StateFlow<List<GithubRepositoryPresentationModel>>
        get() = _trendingRepositories

    private fun updateTrendingRepositories(trendingRepos: List<GithubRepositoryDomainModel>) {
        _trendingRepositories.value =
            trendingRepos.map(githubRepositoryPresentationModelMapper::mapToPresentation)
    }

    private fun handleError(exception: Exception) {
        _useCaseExecutionError.value = exception
    }

    fun onFetchTrendingGithubRepositories() {
        githubRepositoriesUseCase.execute(
            coroutineScope = viewModelScope,
            request = Unit,
            onResponse = ::updateTrendingRepositories,
            onError = ::handleError
        )
    }

    fun onRetryAction() {
        onFetchTrendingGithubRepositories()
    }
}
