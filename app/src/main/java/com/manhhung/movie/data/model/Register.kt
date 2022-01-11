package com.manhhung.movie.data.model

import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("confirmPassowrd")
    val confirmPassword: String,
    @SerializedName("displayName")
    val displayName: String
)
