package com.na.sadapay.presentation.githubrepositories.mapper

import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryAuthorDomainModel
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryDomainModel
import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryAuthorPresentationModel
import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryPresentationModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.MethodRule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.given

@RunWith(Parameterized::class)
class GithubRepositoryDomainToPresentationModelMapperTest(
    private val authorDomainModel: GithubRepositoryAuthorDomainModel,
    private val authorPresentationModel: GithubRepositoryAuthorPresentationModel,
    private val input: GithubRepositoryDomainModel,
    private val expectedResult: GithubRepositoryPresentationModel
) {
    private lateinit var classUnderTest: GithubRepositoryDomainToPresentationModelMapper

    companion object {
        @JvmStatic
        @Parameters(name = "Given {0} When mapToPresentation Thn returns {1}")
        fun params() = listOf(
            arrayOf(
                GithubRepositoryAuthorDomainModel(
                    name = "test author 1",
                    avatarUrl = "https://testAuthor/avatar1"
                ),
                GithubRepositoryAuthorPresentationModel(
                    name = "test author 1",
                    avatarUrl = "https://testAuthor/avatar1"
                ),
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
                )
            ),
            arrayOf(
                GithubRepositoryAuthorDomainModel(
                    name = "test author 2",
                    avatarUrl = "https://testAuthor/avatar2"
                ),
                GithubRepositoryAuthorPresentationModel(
                    name = "test author 2",
                    avatarUrl = "https://testAuthor/avatar2"
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
        )
    }

    @Mock
    lateinit var githubRepositoryAuthorPresentationModelMapper: GithubRepositoryAuthorDomainToPresentationModelMapper

    @get:Rule
    val mockRules: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setup() {
        classUnderTest = GithubRepositoryDomainToPresentationModelMapper(
            githubRepositoryAuthorPresentationModelMapper
        )
    }

    @Test
    fun `Given GithubRepositoryDomainModel as input When mapToPresentation Then returns expected GithubRepositoryPresentationModel`() {
        given(githubRepositoryAuthorPresentationModelMapper.mapToPresentation(authorDomainModel))
            .willReturn(authorPresentationModel)
        val actualResult = classUnderTest.mapToPresentation(input)
        assertEquals(expectedResult, actualResult)
    }
}
