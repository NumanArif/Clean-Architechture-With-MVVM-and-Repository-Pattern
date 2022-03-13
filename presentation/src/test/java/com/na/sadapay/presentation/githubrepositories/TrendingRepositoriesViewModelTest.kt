package com.na.sadapay.presentation.githubrepositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryAuthorDomainModel
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryDomainModel
import com.na.sadapay.domain.githubrepositories.usecase.GetTrendingGithubRepositoriesUseCase
import com.na.sadapay.presentation.githubrepositories.mapper.GithubRepositoryDomainToPresentationModelMapper
import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryAuthorPresentationModel
import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryPresentationModel
import com.na.sadapay.presentation.usecasetestutil.givenNoArgumentSuccessfulUseCaseExecution
import com.na.sadapay.presentation.usecasetestutil.givenNoArgumentUnSuccessfulUseCaseExecution
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given

@RunWith(MockitoJUnitRunner::class)
class TrendingRepositoriesViewModelTest {

    private lateinit var classUnderTest: TrendingRepositoriesViewModel

    @Mock
    lateinit var githubRepositoriesUseCase: GetTrendingGithubRepositoriesUseCase

    @Mock
    lateinit var githubRepositoryPresentationModelMapper: GithubRepositoryDomainToPresentationModelMapper

    private val trendingRepositoriesDomainModels = listOf(
        GithubRepositoryDomainModel(
            fullName = "test repo 1",
            description = "test description",
            url = "https://testRepo1/html_url",
            language = "test language 1",
            score = 3f,
            author = GithubRepositoryAuthorDomainModel(
                name = "test author 1",
                avatarUrl = "https://testAuthor/avatar1"
            )
        ),
        GithubRepositoryDomainModel(
            fullName = "test repo 2",
            description = "test description",
            url = "https://testRepo1/html_url",
            language = "test language 2",
            score = 4.2f,
            author = GithubRepositoryAuthorDomainModel(
                name = "test author 2",
                avatarUrl = "https://testAuthor/avatar2"
            )
        )
    )

    private val trendingRepositoriesPresentationModel = listOf(
        GithubRepositoryPresentationModel(
            fullName = "test repo 1",
            description = "test description",
            url = "https://testRepo1/html_url",
            language = "test language 1",
            score = 3f,
            author = GithubRepositoryAuthorPresentationModel(
                name = "test author 1",
                avatarUrl = "https://testAuthor/avatar1"
            )
        ),
        GithubRepositoryPresentationModel(
            fullName = "test repo 2",
            description = "test description",
            url = "https://testRepo1/html_url",
            language = "test language 2",
            score = 4.2f,
            author = GithubRepositoryAuthorPresentationModel(
                name = "test author 2",
                avatarUrl = "https://testAuthor/avatar2"
            )
        )
    )

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        classUnderTest = TrendingRepositoriesViewModel(
            githubRepositoriesUseCase,
            githubRepositoryPresentationModelMapper
        )
    }

    @Test
    fun `given successful useCase execution When onFetchTrendingGithubRepositories Then updateTrendingRepositories`() {
        githubRepositoriesUseCase.givenNoArgumentSuccessfulUseCaseExecution(
            trendingRepositoriesDomainModels
        )
        trendingRepositoriesDomainModels.forEachIndexed{index, repository ->
            given(githubRepositoryPresentationModelMapper.mapToPresentation(repository))
                .willReturn(trendingRepositoriesPresentationModel[index])
        }
        classUnderTest.onFetchTrendingGithubRepositories()
        val actualResult = classUnderTest.trendingRepositories.value
        val expectedResult = trendingRepositoriesPresentationModel
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `given successful useCase execution When onRetryAction Then updateTrendingRepositories`() {
        githubRepositoriesUseCase.givenNoArgumentSuccessfulUseCaseExecution(
            trendingRepositoriesDomainModels
        )
        trendingRepositoriesDomainModels.forEachIndexed{index, repository ->
            given(githubRepositoryPresentationModelMapper.mapToPresentation(repository))
                .willReturn(trendingRepositoriesPresentationModel[index])
        }
        classUnderTest.onRetryAction()
        val actualResult = classUnderTest.trendingRepositories.value
        val expectedResult = trendingRepositoriesPresentationModel
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `given usSuccessful useCase execution When onFetchTrendingGithubRepositories Then returns expectedResults`() {
        val expectedResult = Exception()
        githubRepositoriesUseCase.givenNoArgumentUnSuccessfulUseCaseExecution(expectedResult)
        classUnderTest.onFetchTrendingGithubRepositories()
        val actualResult = classUnderTest.useCaseExecutionError.value
        assertEquals(expectedResult, actualResult)
    }
}
