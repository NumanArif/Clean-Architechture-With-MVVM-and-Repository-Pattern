package com.na.sadapay.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.na.sadapay.domain.githubrepositories.GithubRepository
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryAuthorDomainModel
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryDomainModel
import com.na.sadapay.domain.githubrepositories.usecase.GetTrendingGithubRepositoriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given

@RunWith(MockitoJUnitRunner::class)
class GetTrendingGithubRepositoriesUseCaseTest {
    private lateinit var classUnderTest: GetTrendingGithubRepositoriesUseCase

    @Mock
    lateinit var githubRepository: GithubRepository

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        classUnderTest = GetTrendingGithubRepositoriesUseCase(githubRepository)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `When executeInBackground then start returning lists on trending repositories`() =
        runBlocking {
            val expectedResult: List<GithubRepositoryDomainModel> = listOf(
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
            var actualResult: List<GithubRepositoryDomainModel>? = null

            given(githubRepository.trendingRepositories()).willReturn(flowOf(expectedResult))

            classUnderTest.execute(MainScope(), Unit, { trendingRepositories ->
                actualResult = trendingRepositories
            }, {})

            assertEquals(expectedResult, actualResult)
        }
}
