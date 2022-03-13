package com.na.sadapay.presentation.githubrepositories.mapper

import com.na.sadapay.domain.githubrepositories.model.GithubRepositoryAuthorDomainModel
import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryAuthorPresentationModel
import com.na.takeaway.presentation.core.DomainToPresentationModelMapper

class GithubRepositoryAuthorDomainToPresentationModelMapper :
    DomainToPresentationModelMapper<GithubRepositoryAuthorDomainModel, GithubRepositoryAuthorPresentationModel>() {
    override fun mapToPresentation(input: GithubRepositoryAuthorDomainModel) =
        GithubRepositoryAuthorPresentationModel(
            name = input.name,
            avatarUrl = input.avatarUrl
        )
}
