package com.manhhung.movie.data.repository

import com.manhhung.movie.data.remote.ApiService

class CompanyRepositoryImpl(private val apiService: ApiService) : CompanyRepository {
    override suspend fun getCompanyDetail(id: String) = apiService.getCompanyDetail(id)
}
