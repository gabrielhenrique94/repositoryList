package com.example.repositorylist.data.repositories

import com.example.repositorylist.api.GithubApi
import com.example.repositorylist.data.repositories.RepositoriesRepositoryImpl.Companion.PAGE_SIZE
import com.example.repositorylist.utils.getRepositoryApiPage
import com.example.repositorylist.utils.getRepositoryPage
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*


internal class RepositoriesRepositoryImplTest {

    val api = mock(GithubApi::class.java)
    val cache = mock(RepositoriesCache::class.java)
    val repository = RepositoriesRepositoryImpl(api, cache)

    @Before
    fun setup() {
        `when`(
            api.getRepositoryList(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString(),
                ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt()
            )
        ).thenReturn(Single.just(getRepositoryApiPage(PAGE_SIZE)))

        `when`(
            cache.getNextPage(
                ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt()
            )
        ).thenReturn(Single.just(getRepositoryPage(PAGE_SIZE)))

    }

    @Test
    fun `Test empty cache`() {
        `when`(
            cache.getNextPage(
                ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt()
            )
        ).thenReturn(Single.just(listOf()))

        repository.listRepository(1).test()

        verify(
            api
        ).getRepositoryList(
            RepositoriesRepositoryImpl.QUERY,
            RepositoriesRepositoryImpl.STARS,
            1
            , PAGE_SIZE
        )
    }

    @Test
    fun `Test cached data`() {
        repository.listRepository(1).test()

        verify(
            cache
        ).getNextPage(1, PAGE_SIZE)
    }
}