package com.na.sadapay.presentation.githubrepositories.mapper

import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryAuthorDomainModel
import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryAuthorPresentationModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class GithubRepositoryAuthorDomainToPresentationModelMapperTest(
    private val input: GithubRepositoryAuthorDomainModel,
    private val expectedResult: GithubRepositoryAuthorPresentationModel
) {
    private lateinit var classUnderTest: GithubRepositoryAuthorDomainToPresentationModelMapper

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
                )
            )
        )
    }

    @Before
    fun setup() {
        classUnderTest = GithubRepositoryAuthorDomainToPresentationModelMapper()
    }

    @Test
    fun `Given githubRepositoryAuthorDomainModel as input When mapToPresentation Then returns expected GithubRepositoryAuthorPresentationModel`() {
        val actualResult = classUnderTest.mapToPresentation(input)
        assertEquals(expectedResult, actualResult)
    }
}
