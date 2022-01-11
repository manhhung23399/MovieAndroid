package com.manhhung.movie.data.model

import com.google.gson.annotations.SerializedName

data class CastDetail(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("movies")
    val movies: List<Movie>
)
