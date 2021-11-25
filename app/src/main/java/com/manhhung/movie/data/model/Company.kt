package com.manhhung.movie.data.model

import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("homePage")
    val homePage: String,
    @SerializedName("head")
    val head: String,
    @SerializedName("country")
    val country: String
)
