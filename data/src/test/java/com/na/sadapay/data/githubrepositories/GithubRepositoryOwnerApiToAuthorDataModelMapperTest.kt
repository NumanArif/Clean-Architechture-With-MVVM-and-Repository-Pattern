package com.na.sadapay.data.githubrepositories

import com.na.sadapay.data.githubrepositories.mapper.GithubRepositoryOwnerApiToAuthorDataModelMapper
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryAuthorDataModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryOwnerApiModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class GithubRepositoryOwnerApiToAuthorDataModelMapperTest(
    private val input: GithubRepositoryOwnerApiModel,
    private val expectedResult: GithubRepositoryAuthorDataModel
) {
    private lateinit var classUnderTest: GithubRepositoryOwnerApiToAuthorDataModelMapper

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
                )
            )
        )
    }

    @Before
    fun setup() {
        classUnderTest = GithubRepositoryOwnerApiToAuthorDataModelMapper()
    }

    @Test
    fun `Given githubRepositoryOwnerApiModel as input When mapToData Then returns expected GithubRepositoryAuthorDataModel`() {
        val actualResult = classUnderTest.mapToData(input)
        assertEquals(expectedResult, actualResult)
    }
}
