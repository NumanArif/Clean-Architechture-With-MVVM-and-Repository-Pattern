package com.na.sadapay.ui.githubrepositories.mapper

import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryAuthorPresentationModel
import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryPresentationModel
import com.na.sadapay.ui.githubrepositories.model.GithubRepositoryUiModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class GithubRepositoryPresentationToUiModelMapperTest(
    private val input: GithubRepositoryPresentationModel,
    private val expectedResult: GithubRepositoryUiModel
) {
    private lateinit var classUnderTest: GithubRepositoryPresentationToUiModelMapper

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} When mapToUi Thn returns {1}")
        fun params() = listOf(
            arrayOf(
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
                GithubRepositoryUiModel(
                    fullName = "test repo 1",
                    description = "test description https://testRepo1/html_url",
                    language = "test language 1",
                    score = "3",
                    authorName = "test author 1",
                    authorAvatarUrl = "https://testAuthor/avatar1"
                )
            ),
            arrayOf(
                GithubRepositoryPresentationModel(
                    fullName = "test repo 2",
                    description = "test description",
                    url = "https://testRepo2/html_url",
                    language = "test language 2",
                    score = 114f,
                    author = GithubRepositoryAuthorPresentationModel(
                        name = "test author 2",
                        avatarUrl = "https://testAuthor/avatar2"
                    )
                ),
                GithubRepositoryUiModel(
                    fullName = "test repo 2",
                    description = "test description https://testRepo2/html_url",
                    language = "test language 2",
                    score = "114",
                    authorName = "test author 2",
                    authorAvatarUrl = "https://testAuthor/avatar2"
                )
            )
        )
    }

    @Before
    fun setup() {
        classUnderTest = GithubRepositoryPresentationToUiModelMapper()
    }

    @Test
    fun `Given githubRepositoryPresentationModel as input When mapToUi Then returns expected GithubRepositoryPresentationModel`() {
        val actualResult = classUnderTest.mapToUi(input)
        Assert.assertEquals(expectedResult, actualResult)
    }
}

