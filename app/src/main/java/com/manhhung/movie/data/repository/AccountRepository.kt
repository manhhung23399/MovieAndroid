package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.Account
import com.manhhung.movie.data.model.AccountResponse
import retrofit2.Response

interface AccountRepository {
    suspend fun logIn(account: Account): Response<Unit>
}