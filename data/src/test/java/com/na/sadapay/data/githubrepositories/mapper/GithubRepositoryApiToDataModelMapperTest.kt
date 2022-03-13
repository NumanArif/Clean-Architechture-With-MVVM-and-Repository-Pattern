package com.na.sadapay.data.githubrepositories.mapper

import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryApiToDataModelMapper
import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryAuthorDataToDomainModelMapper
import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryDataToDomainModelMapper
import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryOwnerApiToAuthorDataModelMapper
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryApiModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryAuthorDataModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryDataModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryOwnerApiModel
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryAuthorDomainModel
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryDomainModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.given

@RunWith(Parameterized::class)
class GithubRepositoryApiToDataModelMapperTest(
    private val OwnerApiModel: GithubRepositoryOwnerApiModel,
    private val authorDataModel: GithubRepositoryAuthorDataModel,
    private val input: GithubRepositoryApiModel,
    private val expectedResult: GithubRepositoryDataModel
) {
    private lateinit var classUnderTest: GithubRepositoryApiToDataModelMapper

    companion object {
        @JvmStatic
        @Parameters(name = "Given {0} When mapToData Thn returns {1}")
        fun params() = listOf(
            arrayOf(
                GithubRepositoryOwnerApiModel(
                    login = "test author 1",
                    avatar_url = "https://testAuthor/avatar1"
                ),
                GithubRepositoryAuthorDataModel(
                    name = "test author 1",
                    avatarUrl = "https://testAuthor/avatar1"
                ),
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
                )
            ),
            arrayOf(
                GithubRepositoryOwnerApiModel(
                    login = "test author 2",
                    avatar_url = "https://testAuthor/avatar2"
                ),
                GithubRepositoryAuthorDataModel(
                    name = "test author 2",
                    avatarUrl = "https://testAuthor/avatar2"
                ),
                GithubRepositoryApiModel(
                    full_name = "test repo 2",
                    description = "test description",
                    html_url = "https://testRepo1/html_url",
                    language = "test language 2",
                    stargazers_count = 42,
                    owner = GithubRepositoryOwnerApiModel(
                        login = "test author 2",
                        avatar_url = "https://testAuthor/avatar2"
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
        )
    }

    @Mock
    lateinit var githubRepositoryAuthorDataModelMapper: GithubRepositoryOwnerApiToAuthorDataModelMapper

    @get:Rule
    val mockRules: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setup() {
        classUnderTest = GithubRepositoryApiToDataModelMapper(githubRepositoryAuthorDataModelMapper)
    }

    @Test
    fun `Given GithubRepositoryApiModel as input When mapToData Then returns expected GithubRepositoryDataModel`() {
        given(githubRepositoryAuthorDataModelMapper.mapToData(OwnerApiModel))
            .willReturn(authorDataModel)
        val actualResult = classUnderTest.mapToData(input)
        assertEquals(expectedResult, actualResult)
    }
}
