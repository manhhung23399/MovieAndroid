package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.BaseResponse
import com.manhhung.movie.data.model.Genre

interface CategoryRepository {
    suspend fun getGenres(): BaseResponse<List<Genre>>
}
