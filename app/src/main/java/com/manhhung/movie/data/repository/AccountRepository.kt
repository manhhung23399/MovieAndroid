package com.manhhung.movie.data.repository

import com.manhhung.movie.data.model.*

interface AccountRepository {
    suspend fun logIn(account: Account): BaseResponse<Any>
    suspend fun register(register: Register): BaseResponse<Any>
}
