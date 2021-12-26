package com.manhhung.movie.data.model

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("label")
    val label: String,
    @SerializedName("file")
    val file: String,
    @SerializedName("type")
    val type: String
)
