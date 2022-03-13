package com.na.sadapay.data.githubrepositories.mapper

import com.na.sadapay.data.githubrepositories.model.GithubRepositoryAuthorDataModel
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryAuthorDomainModel
import com.na.takeaway.data.core.mapper.DataToDomainModelMapper

class GithubRepositoryAuthorDataToDomainModelMapper :
    DataToDomainModelMapper<GithubRepositoryAuthorDataModel, GithubRepositoryAuthorDomainModel>() {
    override fun mapToDomain(input: GithubRepositoryAuthorDataModel): GithubRepositoryAuthorDomainModel {
        TODO("Not yet implemented")
    }
}
