package com.na.sadapay.data.githubrepositories.dataSource.remote

import com.na.sadapay.data.githubrepositories.datasource.remote.GithubRepositoriesRemoteDataSource
import com.na.sadapay.data.githubrepositories.datasource.remote.GithubRepositoriesService
import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryApiToDataModelMapper
import com.na.sadapay.data.githubrepositories.model.GithubRepositoriesApiModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryApiModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryAuthorDataModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryDataModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryOwnerApiModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given

@RunWith(MockitoJUnitRunner::class)
class GithubRepositoriesRemoteDataSourceTest {
    private lateinit var classUnderTest: GithubRepositoriesRemoteDataSource

    @Mock
    lateinit var githubRepositoriesService: GithubRepositoriesService

    @Mock
    lateinit var githubRepositoryApiToDataModelMapper: GithubRepositoryApiToDataModelMapper

    @Before
    fun setup() {
        classUnderTest = GithubRepositoriesRemoteDataSource(
            githubRepositoriesService,
            githubRepositoryApiToDataModelMapper
        )
    }

    @Test
    fun `when getTrendingRepositories Then returns expected DataModels`(): Unit = runBlocking {
        val trendingRepositoriesApiModel = GithubRepositoriesApiModel(
            items = listOf(
                GithubRepositoryApiModel(
                    full_name = "test repo 1",
                    description = "test description",
                    html_url = "https://testRepo1/html_url",
                    language = "test language 1",
                    stargazers_count = 3,
                    owner = GithubRepositoryOwnerApiModel(
                        login = "test author 1",
                        avatar_url = "https://testAuthor/avatar1"
                    )
                ),
                GithubRepositoryApiModel(
                    full_name = "test repo 2",
                    description = "test description",
                    html_url = "https://testRepo2/html_url",
                    language = "test language 2",
                    stargazers_count = 2,
                    owner = GithubRepositoryOwnerApiModel(
                        login = "test author 2",
                        avatar_url = "https://testAuthor/avatar2"
                    )
                )
            )
        )
        val expectedResult = listOf(
            GithubRepositoryDataModel(
                fullName = "test repo 1",
                description = "test description",
                url = "https://testRepo1/html_url",
                language = "test language 1",
                score = 3,
                author = GithubRepositoryAuthorDataModel(
                    name = "test author 1",
                    avatarUrl = "https://testAuthor/avatar1"
                )
            ),
            GithubRepositoryDataModel(
                fullName = "test repo 2",
                description = "test description",
                url = "https://testRepo1/html_url",
                language = "test language 2",
                score = 42,
                author = GithubRepositoryAuthorDataModel(
                    name = "test author 2",
                    avatarUrl = "https://testAuthor/avatar2"
                )
            )
        )
        given(githubRepositoriesService.getTrendingRepositories())
            .willReturn(trendingRepositoriesApiModel)
        given(githubRepositoryApiToDataModelMapper.mapToData(trendingRepositoriesApiModel))
            .willReturn(expectedResult)

        val actualResult = classUnderTest.getTrendingRepositories()

        assertEquals(expectedResult, actualResult)
    }
}
