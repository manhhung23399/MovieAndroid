package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.Account
import com.manhhung.movie.data.model.AccountResponse
import com.manhhung.movie.data.model.BaseResponse
import com.manhhung.movie.data.model.Movie
import retrofit2.Response

interface AccountRepository {
    suspend fun logIn(account: Account): BaseResponse<AccountResponse>
}