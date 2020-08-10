package com.example.repositorylist.repositoriesList

import com.example.repositorylist.data.model.repository.Repository
import com.example.repositorylist.usecases.ListRepositoriesUseCase
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject

class RepositoryListViewModel(val useCase: ListRepositoriesUseCase) {

    private val repositoriesSubject: Subject<List<Repository>> = PublishSubject.create()
    val respositoriesList: Observable<List<Repository>> = repositoriesSubject.hide()

    fun listRepositories() {
        useCase.execute()

            .subscribe({ list ->
                repositoriesSubject.onNext(list)
            }, { t ->
                t.printStackTrace()
            })
    }
}