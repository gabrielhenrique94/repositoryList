package com.example.repositorylist.repositoriesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repositorylist.R
import com.example.repositorylist.data.model.repository.Repository

class RepositoryListAdapter : RecyclerView.Adapter<RepositoryViewHolder>() {
    private val list: MutableList<Repository> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun add(repos: List<Repository>) {
        list.addAll(repos)
        notifyDataSetChanged()
    }

}