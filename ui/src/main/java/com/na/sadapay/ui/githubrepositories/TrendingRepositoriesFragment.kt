package com.na.sadapay.ui.githubrepositories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import androidx.recyclerview.widget.RecyclerView
import com.na.sadapay.presentation.githubrepositories.TrendingRepositoriesViewModel
import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryPresentationModel
import com.na.sadapay.ui.BuildConfig
import com.na.sadapay.ui.R
import com.na.sadapay.ui.core.BaseFragment
import com.na.sadapay.ui.githubrepositories.adapter.TrendingRepositoriesAdapter
import com.na.sadapay.ui.githubrepositories.mapper.GithubRepositoryPresentationToUiModelMapper
import com.na.sadapay.ui.githubrepositories.model.GithubRepositoryUiModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TrendingRepositoriesFragment : BaseFragment() {
    override val viewModel: TrendingRepositoriesViewModel by viewModels()
    override val layoutResource: Int = R.layout.fragment_trending_repositories

    private val trendingRepositoriesListingView: RecyclerView get() = requireView().findViewById(R.id.trendingRepositoriesListing)

    @Inject
    lateinit var githubRepositoryUiModelMapper: GithubRepositoryPresentationToUiModelMapper

    @Inject
    lateinit var repositoryAdapter: TrendingRepositoriesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        trendingRepositoriesListingView.adapter = repositoryAdapter
        observeData()
        viewModel.onFetchTrendingGithubRepositories()
    }

    private fun observeData() {
        lifecycleScope.launch {
            whenCreated {
                viewModel.trendingRepositories.collect { trendingRepositories ->
                    showTrendingRepositories(trendingRepositories.map(githubRepositoryUiModelMapper::mapToUi))
                }
            }
        }
    }

    private fun showTrendingRepositories(trendingRepositories: List<GithubRepositoryUiModel>) {
        repositoryAdapter.submitList(trendingRepositories)
    }
}
