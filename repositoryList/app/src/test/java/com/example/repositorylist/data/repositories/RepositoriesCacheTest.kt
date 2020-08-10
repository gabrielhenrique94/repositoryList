package com.example.repositorylist.data.repositories

import com.example.repositorylist.data.repositories.RepositoriesRepositoryImpl.Companion.PAGE_SIZE
import com.example.repositorylist.utils.getRepositoryPage
import org.junit.Before
import org.junit.Test


class RepositoriesCacheTest {
    var cache = RepositoriesCacheImpl()

    @Before
    fun initTests() {
        cache = RepositoriesCacheImpl()
    }

    @Test
    fun `Test adding one repositories page`() {
        cache.addNextPage(getRepositoryPage(PAGE_SIZE))
        cache
            .getNextPage(1, PAGE_SIZE)
            .map { it.size }
            .test()
            .assertValue(PAGE_SIZE)

    }

    @Test
    fun `Test adding repositories pages`() {
        cache.addNextPage(getRepositoryPage(PAGE_SIZE * 3))
        cache
            .getNextPage(1, PAGE_SIZE)
            .map { it.size }
            .test()
            .assertValue(PAGE_SIZE)

    }

    @Test
    fun `Test get invalid repositories page`() {
        cache.addNextPage(getRepositoryPage(PAGE_SIZE))
        cache
            .getNextPage(2, PAGE_SIZE)
            .map { it.size }
            .test()
            .assertValue(0)
    }

    @Test
    fun `Test get page from empty cache`() {
        cache
            .getNextPage(1, PAGE_SIZE)
            .map { it.size }
            .test()
            .assertValue(0)
    }
}