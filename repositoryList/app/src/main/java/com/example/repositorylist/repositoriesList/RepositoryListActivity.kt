package com.example.repositorylist.repositoriesList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repositorylist.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class RepositoryListActivity : AppCompatActivity() {

    private val viewModel: RepositoryListViewModel by inject()
    private val adapter = RepositoryListAdapter()
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
        initListeners()
        listRepositories()
    }

    private fun initListeners() {
        compositeDisposable.add(viewModel.respositoriesList
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                adapter.add(it)
            })
    }

    private fun listRepositories() {
        viewModel.listRepositories()
    }

    private fun initRecycler() {
        repositoryList.layoutManager = LinearLayoutManager(this)
        repositoryList.adapter = adapter;
    }
}