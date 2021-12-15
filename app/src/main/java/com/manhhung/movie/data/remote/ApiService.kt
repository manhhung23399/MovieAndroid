package com.manhhung.movie.data.remote

import com.manhhung.movie.data.model.Movie
import com.manhhung.movie.data.model.MovieDetail
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie")
    suspend fun getMovies(): List<Movie>

    @GET("movie/{movieId}")
    suspend fun getMovieDetail(
        @Path("movieId") id: String
    ): MovieDetail

    @GET("movie")
    suspend fun getMovieByGenre(
        @Query("filter")
        id: String
    ): List<Movie>

    @GET("movie")
    suspend fun getRandomMovie(
        @Query("random") numberMovie: Int
    ): List<Movie>
}
