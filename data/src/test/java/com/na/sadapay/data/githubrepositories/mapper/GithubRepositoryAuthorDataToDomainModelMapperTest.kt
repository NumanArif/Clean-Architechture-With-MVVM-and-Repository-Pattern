package com.na.sadapay.data.githubrepositories

import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryAuthorDataToDomainModelMapper
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryAuthorDataModel
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryAuthorDomainModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class GithubRepositoryAuthorDataToDomainModelMapperTest(
    private val input: GithubRepositoryAuthorDataModel,
    private val expectedResult: GithubRepositoryAuthorDomainModel
) {
    private lateinit var classUnderTest: GithubRepositoryAuthorDataToDomainModelMapper

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
                )
            )
        )
    }

    @Before
    fun setup() {
        classUnderTest = GithubRepositoryAuthorDataToDomainModelMapper()
    }

    @Test
    fun `Given githubRepositoryAuthorDataModel as input When mapToDomain Then returns expected GithubRepositoryAuthorDomainModel`() {
        val actualResult = classUnderTest.mapToDomain(input)
        assertEquals(expectedResult, actualResult)
    }
}
