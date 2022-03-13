package com.na.sadapay.data.githubrepositories.mapper

import com.na.sadapay.data.githubrepositories.model.GithubRepositoryDataModel
import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryDomainModel
import com.na.takeaway.data.core.mapper.DataToDomainModelMapper

class GithubRepositoryDataToDomainModelMapper(
    private val githubRepositoryAuthorDomainModelMapper: GithubRepositoryAuthorDataToDomainModelMapper
): DataToDomainModelMapper<GithubRepositoryDataModel, GithubRepositoryDomainModel>() {
    override fun mapToDomain(input: GithubRepositoryDataModel): GithubRepositoryDomainModel {
        TODO("Not yet implemented")
    }
}
