package com.manhhung.movie.data.model

import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("poster")
    val poster: String,
    @SerializedName("vote")
    val vote: Float,
    @SerializedName("voteCount")
    val voteCount: Int,
    @SerializedName("casts")
    val casts: List<Cast>,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("companies")
    val companies: List<Company>
)
