package com.manhhung.movie.data.model

import com.google.gson.annotations.SerializedName

data class AccountResponse(
    @SerializedName("email")
    val email: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("refreshToken")
    val refreshToken: String
)
