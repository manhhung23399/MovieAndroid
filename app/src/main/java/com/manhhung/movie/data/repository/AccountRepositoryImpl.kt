package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.Account
import com.manhhung.movie.data.remote.ApiService
import org.json.JSONArray

class AccountRepositoryImpl(
    private val apiService: ApiService
) : AccountRepository {
    override suspend fun logIn(account: Account) = apiService.logIn(account)
}