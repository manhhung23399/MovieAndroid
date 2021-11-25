package com.manhhung.movie.data.remote

import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.model.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("movie")
    suspend fun getMovies(): List<Movie>

    @GET("movie/{movieId}")
    suspend fun getMovieDetail(
        @Path("movieId") id: String
    ): MovieDetail
}
