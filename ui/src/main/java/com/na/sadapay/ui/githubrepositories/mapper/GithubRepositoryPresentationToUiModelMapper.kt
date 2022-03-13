package com.na.sadapay.ui.githubrepositories.mapper

import com.na.sadapay.presentation.githubrepositories.model.GithubRepositoryPresentationModel
import com.na.sadapay.ui.core.PresentationToUiModelMapper
import com.na.sadapay.ui.githubrepositories.model.GithubRepositoryUiModel

class GithubRepositoryPresentationToUiModelMapper :
    PresentationToUiModelMapper<GithubRepositoryPresentationModel, GithubRepositoryUiModel>() {
    override fun mapToUi(input: GithubRepositoryPresentationModel) =
        GithubRepositoryUiModel(
            isExpanded = false,
            fullName = input.fullName,
            description = "${input.description} ${input.url}",
            language = input.language,
            score = input.score.toString(),
            authorName = input.author.name,
            authorAvatarUrl = input.author.avatarUrl
        )
}
