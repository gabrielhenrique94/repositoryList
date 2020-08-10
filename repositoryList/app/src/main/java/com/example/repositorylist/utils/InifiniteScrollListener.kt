package com.example.repositorylist.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.infiniteScrollListener(offset: Int, f: () -> Unit) {
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {

        val linearLayoutManager = layoutManager as? LinearLayoutManager

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val visibleItemCount = linearLayoutManager?.getChildCount() ?: 0
            val totalItemCount = linearLayoutManager?.getItemCount() ?: 0
            val pastVisibleItems = linearLayoutManager?.findFirstVisibleItemPosition() ?: 0
            if ((visibleItemCount + pastVisibleItems + offset) >= totalItemCount) f.invoke()
        }
    })
}