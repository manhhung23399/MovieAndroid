package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.BaseResponse
import com.manhhung.movie.data.model.CastDetail

interface CastRepository {
    suspend fun getCastDetail(id: String): BaseResponse<CastDetail>
}