package com.manhhung.movie.data.repository

import com.manhhung.movie.data.remote.ApiService

class CastRepositoryImpl(
    private val apiService: ApiService
) : CastRepository {
    override suspend fun getCastDetail(id: String) = apiService.getCastDetail(id)
}
