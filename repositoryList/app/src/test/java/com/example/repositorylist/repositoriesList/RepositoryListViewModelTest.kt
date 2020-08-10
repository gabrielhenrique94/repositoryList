package com.example.repositorylist.repositoriesList

import com.example.repositorylist.data.repositories.RepositoriesRepositoryImpl.Companion.PAGE_SIZE
import com.example.repositorylist.usecases.ListRepositoriesUseCase
import com.example.repositorylist.utils.getRepositoryPage
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*


internal class RepositoryListViewModelTest {
    val useCase = mock(ListRepositoriesUseCase::class.java)
    val viewModel = RepositoryListViewModel(useCase)

    @Before
    fun setup() {
        `when`(useCase.execute()).thenReturn(Single.just(getRepositoryPage(PAGE_SIZE)))
    }


    @Test
    fun `should call use case to list repositories`() {
        viewModel.getNextPage()
        verify(useCase).execute()
    }

    @Test
    fun `should reset page count on geFirstPage method`() {
        viewModel.getFirstPage()
        verify(useCase).resetPageCount()
        verify(useCase).execute()
    }

}