package com.manhhung.movie.data.model

import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("country")
    val country: String
)
