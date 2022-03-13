package com.na.sadapay.data.githubrepositories.mapper

import com.na.sadapay.data.core.mapper.ApiToDataModelMapper
import com.na.sadapay.data.githubrepositories.model.GithubRepositoriesApiModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryDataModel

class GithubRepositoryApiToDataModelMapper(
    private val githubRepositoryAuthorDomainModelMapper: GithubRepositoryOwnerApiToAuthorDataModelMapper
) : ApiToDataModelMapper<GithubRepositoriesApiModel, List<GithubRepositoryDataModel>>() {
    override fun mapToData(
        input: GithubRepositoriesApiModel
    ) = input.items.map { repository ->
        GithubRepositoryDataModel(
            fullName = repository.full_name,
            description = repository.description,
            url = repository.html_url,
            language = repository.language.orEmpty(),
            score = repository.stargazers_count,
            author = githubRepositoryAuthorDomainModelMapper.mapToData(repository.owner)
        )
    }
}
