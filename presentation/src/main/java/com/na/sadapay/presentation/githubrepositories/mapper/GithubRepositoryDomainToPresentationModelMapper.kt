package com.na.sadapay.presentation.githubrepositories.mapper

import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryDomainModel
import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryPresentationModel
import com.na.takeaway.presentation.core.DomainToPresentationModelMapper

class GithubRepositoryDomainToPresentationModelMapper(
    private val githubRepositoryAuthorPresentationModelMapper: GithubRepositoryAuthorDomainToPresentationModelMapper
): DomainToPresentationModelMapper<GithubRepositoryDomainModel, GithubRepositoryPresentationModel>() {
    override fun mapToPresentation(input: GithubRepositoryDomainModel): GithubRepositoryPresentationModel {
        TODO("Not yet implemented")
    }
}
