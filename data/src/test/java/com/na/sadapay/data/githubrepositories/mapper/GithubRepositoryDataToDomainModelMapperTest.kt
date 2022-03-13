package com.na.sadapay.data.githubrepositories

import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryAuthorDataToDomainModelMapper
import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryDataToDomainModelMapper
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryAuthorDataModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryDataModel
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
class GithubRepositoryDataToDomainModelMapperTest(
    private val authorDataModel: GithubRepositoryAuthorDataModel,
    private val authorDomainModel: GithubRepositoryAuthorDomainModel,
    private val input: GithubRepositoryDataModel,
    private val expectedResult: GithubRepositoryDomainModel
) {
    private lateinit var classUnderTest: GithubRepositoryDataToDomainModelMapper

    companion object {
        @JvmStatic
        @Parameters(name = "Given {0} When mapToDomain Thn returns {1}")
        fun params() = listOf(
            arrayOf(
                GithubRepositoryAuthorDataModel(
                    name = "test author 1",
                    avatarUrl = "https://testAuthor/avatar1"
                ),
                GithubRepositoryAuthorDomainModel(
                    name = "test author 1",
                    avatarUrl = "https://testAuthor/avatar1"
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
                ),
                GithubRepositoryDomainModel(
                    fullName = "test repo 1",
                    description = "test description",
                    url = "https://testRepo1/html_url",
                    language = "test language 1",
                    score = 3,
                    author = GithubRepositoryAuthorDomainModel(
                        name = "test author 1",
                        avatarUrl = "https://testAuthor/avatar1"
                    )
                )
            ),
            arrayOf(
                GithubRepositoryAuthorDataModel(
                    name = "test author 2",
                    avatarUrl = "https://testAuthor/avatar2"
                ),
                GithubRepositoryAuthorDomainModel(
                    name = "test author 2",
                    avatarUrl = "https://testAuthor/avatar2"
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
                ),
                GithubRepositoryDomainModel(
                    fullName = "test repo 2",
                    description = "test description",
                    url = "https://testRepo1/html_url",
                    language = "test language 2",
                    score = 42,
                    author = GithubRepositoryAuthorDomainModel(
                        name = "test author 2",
                        avatarUrl = "https://testAuthor/avatar2"
                    )
                )
            )
        )
    }

    @Mock
    lateinit var githubRepositoryAuthorDomainModelMapper: GithubRepositoryAuthorDataToDomainModelMapper

    @get:Rule
    val mockRules: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setup() {
        classUnderTest = GithubRepositoryDataToDomainModelMapper(
            githubRepositoryAuthorDomainModelMapper
        )
    }

    @Test
    fun `Given GithubRepositoryDataModel as input When mapToDomain Then returns expected GithubRepositoryDomainModel`() {
        given(githubRepositoryAuthorDomainModelMapper.mapToDomain(authorDataModel))
            .willReturn(authorDomainModel)
        val actualResult = classUnderTest.mapToDomain(input)
        assertEquals(expectedResult, actualResult)
    }
}
