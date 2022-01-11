package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.Account
import com.manhhung.movie.data.model.Register
import com.manhhung.movie.data.remote.ApiService

class AccountRepositoryImpl(
    private val apiService: ApiService
) : AccountRepository {
    override suspend fun logIn(account: Account) = apiService.logIn(account)
    override suspend fun register(register: Register) = apiService.register(register)
}
