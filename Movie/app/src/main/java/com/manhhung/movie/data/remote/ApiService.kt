package com.manhhung.movie.data.remote

import com.manhhung.movie.data.model.Movie
import retrofit2.http.GET

interface ApiService {
    @GET("movie")
    suspend fun getMovies(): List<Movie>
}