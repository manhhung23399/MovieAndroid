package com.manhhung.movie.data.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T : Any>(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: T
)
