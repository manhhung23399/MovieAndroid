package com.manhhung.movie.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.manhhung.movie.data.model.Movie

class Converter {
    @TypeConverter
    fun toJsonMovies(movie: Movie): String {
        return Gson().toJson(movie)
    }

    @TypeConverter
    fun fromJsonMovies(json: String): Movie {
        return Gson().fromJson(json, Movie::class.java)
    }
}
