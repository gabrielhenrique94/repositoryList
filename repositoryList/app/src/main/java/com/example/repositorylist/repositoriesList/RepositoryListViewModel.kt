package com.example.repositorylist.repositoriesList

import com.example.repositorylist.data.model.repository.Repository
import com.example.repositorylist.usecases.ListRepositoriesUseCase
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject

class RepositoryListViewModel(private val useCase: ListRepositoriesUseCase) {

    private val repositoriesSubject: Subject<List<Repository>> = PublishSubject.create()
    val repositoriesList: Observable<List<Repository>> = repositoriesSubject.hide()

    fun getNextPage() {
        useCase.execute()
            .subscribe({ list ->
                repositoriesSubject.onNext(list)
            }, { t ->
                t.printStackTrace()
            })
    }

    fun getFirstPage() {
        useCase.page = 0
        useCase.execute()
            .subscribe({ list ->
                repositoriesSubject.onNext(list)
            }, { t ->
                t.printStackTrace()
            })
    }

    companion object {
        const val INFINITE_SCROLL_OFFSET: Int = 10

    }
}