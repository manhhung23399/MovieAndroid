package com.manhhung.movie.data.repository

import com.manhhung.movie.data.remote.ApiService

class CategoryRepositoryImpl(
    private val apiService: ApiService
) : CategoryRepository {

    override suspend fun getGenres() = apiService.getGenres()
}
