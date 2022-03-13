package com.na.sadapay.data.githubrepositories.mapper

import com.na.sadapay.data.core.mapper.ApiToDataModelMapper
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryAuthorDataModel
import com.na.sadapay.data.githubrepositories.model.GithubRepositoryOwnerApiModel
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryAuthorDomainModel
import com.na.takeaway.data.core.mapper.DataToDomainModelMapper

class GithubRepositoryOwnerApiToAuthorDataModelMapper :
    ApiToDataModelMapper<GithubRepositoryOwnerApiModel, GithubRepositoryAuthorDataModel>() {
    override fun mapToData(
        input: GithubRepositoryOwnerApiModel
    ) = GithubRepositoryAuthorDataModel(
        name = input.login,
        avatarUrl = input.avatar_url
    )
}
