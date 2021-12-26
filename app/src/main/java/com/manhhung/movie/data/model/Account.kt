package com.manhhung.movie.data.model

import com.google.gson.annotations.SerializedName

data class Account(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)