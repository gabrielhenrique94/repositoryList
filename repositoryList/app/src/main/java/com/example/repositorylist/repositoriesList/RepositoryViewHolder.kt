package com.example.repositorylist.repositoriesList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.repositorylist.data.model.repository.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Repository) {
        itemView.apply {
            repositoryNameTextView.text = item.repositoryName
            repositoryStars.text = item.stars.toString()
            repositoryOwner.text = item.ownerName;
            repositoryDescription.text = item.description
            Picasso.get()
                .load(item.ownerImgUrl)
                .fit()
                .into(ownerAvatarImageView)
        }
    }
}