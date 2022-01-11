package com.manhhung.movie.data.model

import com.google.gson.annotations.SerializedName

data class CompanyDetail(
    @SerializedName("name")
    val name: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("homePage")
    val homePage: String,
    @SerializedName("headQuarter")
    val headQuarter: String,
    @SerializedName("country")
    val country: String
)
