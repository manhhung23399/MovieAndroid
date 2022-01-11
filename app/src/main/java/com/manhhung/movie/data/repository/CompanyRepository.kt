package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.BaseResponse
import com.manhhung.movie.data.model.CompanyDetail

interface CompanyRepository {

    suspend fun getCompanyDetail(id: String): BaseResponse<CompanyDetail>
}