package com.na.sadapay.ui.githubrepositories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.na.sadapay.ui.R
import com.na.sadapay.ui.githubrepositories.adapter.TrendingRepositoriesAdapter.TrendingRepositoryViewHolder
import com.na.sadapay.ui.githubrepositories.model.GithubRepositoryUiModel

class TrendingRepositoriesDiffUtils : DiffUtil.ItemCallback<GithubRepositoryUiModel>() {
    override fun areItemsTheSame(
        oldItem: GithubRepositoryUiModel,
        newItem: GithubRepositoryUiModel
    ) = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: GithubRepositoryUiModel,
        newItem: GithubRepositoryUiModel
    ) = oldItem.fullName == newItem.fullName
}

class TrendingRepositoriesAdapter(
    diffCallback: TrendingRepositoriesDiffUtils
) : ListAdapter<GithubRepositoryUiModel, TrendingRepositoryViewHolder>(diffCallback) {

    inner class TrendingRepositoryViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val rootView: View by lazy { itemView.findViewById(R.id.rootView) }
        private val authorAvatarView: ImageView by lazy { itemView.findViewById(R.id.authorAvatar) }
        private val authorNameView: TextView by lazy { itemView.findViewById(R.id.authorName) }
        private val repositoryNameView: TextView by lazy { itemView.findViewById(R.id.repositoryName) }
        private val repositoryDescriptionView: TextView by lazy { itemView.findViewById(R.id.repositoryDescription) }
        private val repositoryLanguageView: TextView by lazy { itemView.findViewById(R.id.repositoryLanguage) }
        private val repositoryScoreView: TextView by lazy { itemView.findViewById(R.id.repositoryScore) }
        private val repositoryDetails: Group by lazy { itemView.findViewById(R.id.repositoryDetails) }

        fun bind(position: Int, repository: GithubRepositoryUiModel) {
            repositoryDetails.isVisible = repository.isExpanded
            Glide.with(itemView.context)
                .load(repository.authorAvatarUrl)
                .transform(CircleCrop())
                .into(authorAvatarView)
            authorNameView.text = repository.authorName
            repositoryNameView.text = repository.fullName
            repositoryDescriptionView.text = repository.description
            repositoryLanguageView.text = repository.language
            repositoryScoreView.text = repository.score
            rootView.setOnClickListener {
                repository.isExpanded = !repository.isExpanded
                notifyItemChanged(position, repository)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = TrendingRepositoryViewHolder(
        itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_trending_repository_view, parent, false)
    )

    override fun onBindViewHolder(holder: TrendingRepositoryViewHolder, position: Int) {
        holder.bind(position, getItem(position))
    }
}
