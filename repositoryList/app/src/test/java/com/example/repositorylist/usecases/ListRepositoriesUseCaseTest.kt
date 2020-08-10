package com.example.repositorylist.usecases

import com.example.repositorylist.data.repositories.RepositoriesRepository
import com.example.repositorylist.data.repositories.RepositoriesRepositoryImpl
import com.example.repositorylist.data.repositories.RepositoriesRepositoryImpl.Companion.PAGE_SIZE
import com.example.repositorylist.utils.getRepositoryPage
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*


internal class ListRepositoriesUseCaseTest {
    private var repository: RepositoriesRepository = mock(RepositoriesRepositoryImpl::class.java)
    private var useCase: ListRepositoriesUseCaseImpl = ListRepositoriesUseCaseImpl(repository)

    @Before
    fun setup() {
        repository = mock(RepositoriesRepository::class.java)
        `when`(repository.listRepository(ArgumentMatchers.anyInt())).thenReturn(
            Single.just(
                getRepositoryPage(
                    PAGE_SIZE
                )
            )
        )
        useCase = ListRepositoriesUseCaseImpl(repository)
    }

    @Test
    fun `Test get correct page`() {
        useCase.execute().map { it.size }.test().assertValue(PAGE_SIZE)
        verify(repository, times(1)).listRepository()
        useCase.execute().map { it.size }.test().assertValue(PAGE_SIZE)
        verify(repository).listRepository(2)
    }

    @Test
    fun `Test empty page`() {
        `when`(repository.listRepository(ArgumentMatchers.anyInt())).thenReturn(Single.just(listOf()))
        useCase.execute().map { it.size }.test().assertValue(0)
        verify(repository, times(1)).listRepository()

    }

}
